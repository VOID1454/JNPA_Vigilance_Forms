package com.example.forms.Controller;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.forms.model.Role;
import com.example.forms.model.User;
import com.example.forms.service.UserService;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", Role.values()); 
        return "register";
    }
    @PostMapping("/register")
    public String registerUser (@ModelAttribute User user, @RequestParam("role") String role, Model model) {
        // Validate password
        if (!isValidPassword(user.getPassword())) {
            model.addAttribute("error", "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, and one special character.");
            return "register"; // Return to the registration form with an error message
        }

        // Set user role and encode password
        user.setRole(Role.valueOf(role)); 
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword())); // Encode the password before saving

        userService.saveUser (user);
        return "redirect:/login";
    }



     @GetMapping("/uploadUsers")
    public String showUploadForm() {
        return "uploadUsers";
    }

    @PostMapping("/uploadUsers")
    public String uploadUsers(@RequestParam("file") MultipartFile file, Model model) {
        if (file.isEmpty()) {
            model.addAttribute("error", "Please select a CSV file to upload.");
            return "uploadUsers";
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            List<User> users = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    User user = new User();
                    user.setName(data[0]);
                    user.setEmail(data[1]);
                    user.setContactno(data[2]);
                    user.setStaffno(data[3]);
                    user.setPassword(data[4]);
                    user.setRole(Role.valueOf(data[5]));
 users.add(user);
                }
            }
            userService.saveAllUsers(users);
            model.addAttribute("message", "Users registered successfully!");
        } catch (Exception e) {
            model.addAttribute("error", "Error processing file: " + e.getMessage());
        }
        return "uploadUsers";
    }






    private boolean isValidPassword(String password) {
        return password.length() >= 8 &&
               Pattern.compile("[A-Z]").matcher(password).find() &&
               Pattern.compile("[a-z]").matcher(password).find() &&
               Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    public class PasswordTest {
        public static void main(String[] args) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String hashed = encoder.encode("test123");
            System.out.println(hashed);
            System.out.println(encoder.matches("test123", hashed)); 
        }
    }

   

}
