package com.example.forms.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.forms.service.FormService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class FormController {

    @Autowired
    private FormService formService;

    
    @GetMapping("/forms")
    public String showUsersForms(HttpSession session,  @SessionAttribute("username") String username, Model model) {
      

        List<Map<String, String>> userDetails = formService.getUserFormDetails();
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("username", username);
        return "user-forms"; 
    }
}
