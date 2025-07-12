package com.example.forms.Controller;

import java.security.Principal;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.forms.DTO.StaffDetailsDTO;
import com.example.forms.model.User;
import com.example.forms.repository.UserRepository;
import com.example.forms.service.StaffService;
import com.example.forms.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserRepository userrepo;

    public void commondata(Model model, Principal principal) {

        String username = principal.getName();
        System.out.println("username" + username);
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")
    public String userDashboard(Model model, HttpSession session) {
        // Get the authentication object
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            // Get the logged-in user's username (email)
            String email = ((UserDetails) authentication.getPrincipal()).getUsername();

            // Fetch the user from the database
            User user = userRepository.findByEmail(email).orElse(null);
            model.addAttribute("roles", authentication.getAuthorities());
            if (user != null) {
                // Store user details in session
                session.setAttribute("loggedInUser", user);
                session.setAttribute("staffno", user.getStaffno());
                session.setAttribute("username", user.getName());
                session.setAttribute("userId", user.getId());
                session.setAttribute("department", user.getDepartment());

                // Add user data to the model
                model.addAttribute("username", user.getName());
                model.addAttribute("staffno", user.getStaffno());
                model.addAttribute("userId", user.getId());
                model.addAttribute("department", user.getDepartment());

            }
        }
        return "adminhome";
    }

    @Autowired
    private StaffService staffService;

    @Autowired
    private UserService userService;

    @GetMapping("/staff-list")
    public String staffList(HttpSession session, Model model) {

        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "staff_list";
    }

    @GetMapping("/staff/{staffno}")
    public String getStaffDetails(@PathVariable String staffno, HttpSession session, Model model) {

        StaffDetailsDTO staffDetails = staffService.getStaffDetails(staffno);
        model.addAttribute("staffDetails", staffDetails);
        return "staff_details";
    }

    @GetMapping("/change-password")
    public String showChangePasswordPage(@SessionAttribute("username") String username,
            Model model) {
        model.addAttribute("username", username);
        return "Adminchangepassword";
    }

    @PostMapping("/change-password")
    public String changePassword(@RequestParam String oldPassword,
            @RequestParam String newPassword,
            @RequestParam String confirmPassword,
            HttpSession session,
            Model model) {
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            model.addAttribute("logmessage", "User not logged in!");
            return "Adminchangepassword";
        }

        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("logmessage", "New password and Confirm password do not match!");
            return "Adminchangepassword";
        }

        if (!isValidPassword(newPassword)) {
            model.addAttribute("logmessage",
                    "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, and one special character.");
            return "Adminchangepassword";
        }

        String response = userService.changePassword(userId, oldPassword, newPassword);

        if (response.equals("Password changed successfully!")) {
            model.addAttribute("successMessage", response);
        } else {
            model.addAttribute("logmessage", response);
        }

        return "Adminchangepassword";
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8 &&
                Pattern.compile("[A-Z]").matcher(password).find() &&
                Pattern.compile("[a-z]").matcher(password).find() &&
                Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();
    }








    //  @PostMapping("/adminapprove")
    // public String approveByAdmin(@RequestParam Long id, 
    //                            @RequestParam String entityType,
    //                            RedirectAttributes redirectAttributes) {
    //     try {
    //         staffService.updateVerificationStatus(id, entityType, "Verified_By_Admin");
    //         redirectAttributes.addFlashAttribute("successMessage", "Form approved successfully!");
    //     } catch (Exception e) {
    //         redirectAttributes.addFlashAttribute("errorMessage", "Error approving form: " + e.getMessage());
    //     }
    //     return "redirect:/admin/staff-list"; // Redirect back to staff list
    // }

    // @PostMapping("/adminreject")
    // public String rejectByAdmin(@RequestParam Long id, 
    //                           @RequestParam String entityType,
    //                           RedirectAttributes redirectAttributes) {
    //     try {
    //         staffService.updateVerificationStatus(id, entityType, "Rejected_By_Admin");
    //         redirectAttributes.addFlashAttribute("successMessage", "Form rejected successfully!");
    //     } catch (Exception e) {
    //         redirectAttributes.addFlashAttribute("errorMessage", "Error rejecting form: " + e.getMessage());
    //     }
    //     return "redirect:/admin/staff-list"; // Redirect back to staff list
    // }  public String 





    @PostMapping("/adminapprove")
public String approveByAdmin(@RequestParam Long id, 
                           @RequestParam String entityType,
                           @RequestParam String staffno,
                           RedirectAttributes redirectAttributes,
                           HttpServletRequest request) {
    try {
        staffService.updateVerificationStatus(id, entityType, "Verified_By_Admin");
        redirectAttributes.addFlashAttribute("successMessage", "Form approved successfully!");
    } catch (Exception e) {
        redirectAttributes.addFlashAttribute("errorMessage", "Error approving form: " + e.getMessage());
    }
    // Get the referer URL to stay on the same page
    String referer = request.getHeader("Referer");
    return "redirect:" + referer;
}

// @PostMapping("/adminreject")
// public String rejectByAdmin(@RequestParam Long id, 
//                           @RequestParam String entityType,
//                           @RequestParam String staffno,
//                           RedirectAttributes redirectAttributes,
//                           HttpServletRequest request) {
//     try {
//         staffService.updateVerificationStatus(id, entityType, "Rejected_By_Admin");
//         redirectAttributes.addFlashAttribute("successMessage", "Form rejected successfully!");
//     } catch (Exception e) {
//         redirectAttributes.addFlashAttribute("errorMessage", "Error rejecting form: " + e.getMessage());
//     }
//     // Get the referer URL to stay on the same page
//     String referer = request.getHeader("Referer");
//     return "redirect:" + referer;
// }



@PostMapping("/adminreject")
public String rejectByAdmin(@RequestParam Long id, 
                          @RequestParam String entityType,
                          @RequestParam String staffno,
                          @RequestParam String rejectionReason,
                          RedirectAttributes redirectAttributes,
                          HttpServletRequest request) {
    try {
        staffService.updateVerificationStatusAndRemark(id, entityType, 
            "Rejected_By_Admin", rejectionReason);
        redirectAttributes.addFlashAttribute("successMessage", "Form rejected successfully!");
    } catch (Exception e) {
        redirectAttributes.addFlashAttribute("errorMessage", "Error rejecting form: " + e.getMessage());
    }
    String referer = request.getHeader("Referer");
    return "redirect:" + referer;
}
}


