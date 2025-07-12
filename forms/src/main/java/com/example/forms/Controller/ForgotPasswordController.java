package com.example.forms.Controller;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.forms.model.User;
import com.example.forms.service.EmailService;
import com.example.forms.service.UserService;

@Controller
public class ForgotPasswordController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "forgot-password";
    }

    @PostMapping("/forgot-password")
    public String processForgotPassword(@RequestParam String email, Model model) {
        User user = userService.findByEmail(email);
        if (user == null) {
            model.addAttribute("error", "User with this email does not exist.");
            return "forgot-password";
        }

        // Generate OTP
        String otp = generateOTP();
        user.setOtp(otp);
        user.setOtpExpirationTime(LocalDateTime.now().plusMinutes(5)); // OTP valid for 5 minutes
        userService.saveUser(user);

        // Send OTP via email
        String subject = "Your OTP for Password Reset";
        String content = "Your OTP is: " + otp + ". It will expire in 5 minutes.";
        emailService.sendEmail(user.getEmail(), subject, content);

        model.addAttribute("message", "An OTP has been sent to your email.");
        return "verify-otp";
    }

    private String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }
}