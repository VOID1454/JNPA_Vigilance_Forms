package com.example.useradminauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.useradminauth.model.Role;
import com.example.useradminauth.model.User;
import com.example.useradminauth.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", Role.values()); // Pass roles to view
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, @RequestParam("role") String role) {
        user.setRole(Role.valueOf(role)); // Set role from form selection
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

   

    @GetMapping("/admin/home")
    public String adminHome() {
        return "admin-home";
    }
    
    
    
    
    

    public class PasswordTest {
        public static void main(String[] args) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String hashed = encoder.encode("test123");
            System.out.println(hashed);
            System.out.println(encoder.matches("test123", hashed)); // Should print true
        }
    }

}
