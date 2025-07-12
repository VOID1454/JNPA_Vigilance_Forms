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

import com.example.forms.model.User;
import com.example.forms.repository.UserRepository;
import com.example.forms.service.UserService;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/user")
public class userController {
	@Autowired
	UserRepository userrepo;

       @Autowired
    private UserService userService;
	
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
        return "home"; // Return the view
    }

    @GetMapping("/change-password")
    public String showChangePasswordPage(@SessionAttribute("username") String username,
    Model model) {
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
            model.addAttribute("logmessage", "User not logged in!");
            return "change-password";
        }

        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("logmessage", "New password and Confirm password do not match!");
            return "change-password";
        }

        if (!isValidPassword(newPassword)) {
            model.addAttribute("logmessage", "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, and one special character.");
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
               Pattern.compile("[a-z]").matcher(password).find() &&
               Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();
    }

	

}

