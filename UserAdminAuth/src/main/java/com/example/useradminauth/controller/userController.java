package com.example.useradminauth.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.useradminauth.model.User;
import com.example.useradminauth.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class userController {
	@Autowired
	UserRepository userrepo;
	
	public void commondata(Model model, Principal principal) {
		
		String username = principal.getName();
		System.out.println("username" + username);
	}
	
	
//	 @GetMapping("/home")
//	    public String userHome(Principal principal, Model model) {
//		 String username = principal.getName();
//		 
//		 
//			System.out.println("username" + username);
//			
//		 
//		 System.out.println("hello log");
//	        return "user-dashboard";	
//	    }
	
	
	
//	@GetMapping("/home")
//    public String userDashboard(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        
//        model.addAttribute("username", userDetails.getUsername());
//        model.addAttribute("roles", authentication.getAuthorities());
//        
//        return "user-dashboard";
//    }
	
	
	
	
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
                

                // Add user data to the model
                model.addAttribute("username", user.getName());
                model.addAttribute("staffno", user.getStaffno());
                
            }
        }
        return "user-dashboard"; // Return the view
    }
	

}
