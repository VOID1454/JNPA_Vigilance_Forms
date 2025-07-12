package com.example.forms.Controller;

import java.security.Principal;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.forms.DTO.approverDTO;
import com.example.forms.model.User;
import com.example.forms.repository.UserRepository;
import com.example.forms.service.ApproverService; // Import the ApproverService
import com.example.forms.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/approver")
public class ApproverController { // Ensure the class name is spelled correctly

    @Autowired
    UserRepository userrepo;

    @Autowired
    private UserService userService;

    @Autowired
    private ApproverService approverService; // Declare the ApproverService

    public void commondata(Model model, Principal principal) {
        String username = principal.getName();
        System.out.println("username" + username);
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")
    public String approverDashboard(Model model, HttpSession session) {
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
        return "approverhome";
    }

    @GetMapping("/change-password")
    public String showChangePasswordPage(@SessionAttribute("username") String username, Model model) {
        model.addAttribute("username", username);
        return "change-password";
    }

    @PostMapping("/change-password")
    public String changePassword(@RequestParam String oldPassword,
            @RequestParam String newPassword,
            @RequestParam String confirmPassword,
            HttpSession session,
            Model model) {
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            model.addAttribute("logmessage", "User  not logged in!");
            return "change-password";
        }

        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("logmessage", "New password and Confirm password do not match!");
            return "change-password";
        }

        if (!isValidPassword(newPassword)) {
            model.addAttribute("logmessage",
                    "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, and one special character.");
            return "change-password";
        }

        String response = userService.changePassword(userId, oldPassword, newPassword);

        if (response.equals("Password changed successfully!")) {
            model.addAttribute("successMessage", response);
        } else {
            model.addAttribute("logmessage", response);
        }

        return "change-password";
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8 &&
                Pattern.compile("[A-Z]").matcher(password).find() &&
                Pattern.compile("[a -z]").matcher(password).find() &&
                Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]").matcher(password).find();
    }

    @GetMapping("/verify")
    public String getFormsByDepartment(HttpSession session, Model model) {
        String department = (String) session.getAttribute("department");
        approverDTO approverData = approverService.getFormsByDepartment(department);
        model.addAttribute("approverData", approverData); // Change here
        return "verify";
    }

    @GetMapping("/verified")
    public String getFormsByDepartmentverified(HttpSession session, Model model) {
        String department = (String) session.getAttribute("department");
        approverDTO approverData = approverService.getFormsByDepartment(department);
        model.addAttribute("approverData", approverData); // Change here
        return "verified";
    }

    @GetMapping("/Rejected")
    public String getFormsByDepartmentrejected(HttpSession session, Model model) {
        String department = (String) session.getAttribute("department");
        approverDTO approverData = approverService.getFormsByDepartment(department);
        model.addAttribute("approverData", approverData); // Change here
        return "Rejected";
    }




    @GetMapping("/adminaction")
    public String getFormsByDepartmentadmin(HttpSession session, Model model) {
        String department = (String) session.getAttribute("department");
        approverDTO approverData = approverService.getFormsByDepartment(department);
        model.addAttribute("approverData", approverData); // Change here
        return "adminaction";
    }

    @PostMapping("/verifyentry")
    public String verifyRecord(@RequestParam Long id, @RequestParam String entityType) {
        approverService.verifyRecord(id, entityType);
        return "redirect:/approver/verify"; // Redirect back to the verify page after verification
    }


     @PostMapping("/hodapprove")
    public String approveByHOD(@RequestParam Long id, 
                             @RequestParam String entityType,
                             RedirectAttributes redirectAttributes) {
        try {
            // Update verification status to Approved_By_HOD
            approverService.updateVerificationStatus(id, entityType, "Approved_By_HOD");
            redirectAttributes.addFlashAttribute("successMessage", "Form approved successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error approving form: " + e.getMessage());
        }
        return "redirect:/approver/verify"; // Redirect back to approver page
    }

    // @PostMapping("/hodreject")
    // public String rejectByHOD(@RequestParam Long id, 
    //                         @RequestParam String entityType,
    //                         RedirectAttributes redirectAttributes) {
    //     try {
    //         // Update verification status to Rejected_By_HOD
    //         approverService.updateVerificationStatus(id, entityType, "Rejected_By_HOD");
    //         redirectAttributes.addFlashAttribute("successMessage", "Form rejected successfully!");
    //     } catch (Exception e) {
    //         redirectAttributes.addFlashAttribute("errorMessage", "Error rejecting form: " + e.getMessage());
    //     }
    //     return "redirect:/approver/verify"; // Redirect back to approver page
    // }



    @PostMapping("/hodreject")
public String rejectByHOD(@RequestParam Long id, 
                        @RequestParam String entityType,
                        @RequestParam String rejectionReason,
                        RedirectAttributes redirectAttributes,
                        HttpServletRequest request) {
    try {
        approverService.updateVerificationStatusAndRemark(id, entityType, "Rejected_By_HOD", rejectionReason);
        redirectAttributes.addFlashAttribute("successMessage", "Form rejected successfully!");
    } catch (Exception e) {
        redirectAttributes.addFlashAttribute("errorMessage", "Error rejecting form: " + e.getMessage());
    }
    String referer = request.getHeader("Referer");
    return "redirect:" + referer;
}
}