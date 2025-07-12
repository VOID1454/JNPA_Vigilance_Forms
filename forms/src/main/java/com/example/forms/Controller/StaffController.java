package com.example.forms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.forms.DTO.StaffDetailsDTO;
import com.example.forms.model.User;
import com.example.forms.service.StaffService;
import com.example.forms.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller

public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private UserService userService; 

    
    @GetMapping("/staff-list")
    public String staffList(HttpSession session, @SessionAttribute("username") String username, Model model) {


        List<User> users = userService.getAllUsers(); 
        model.addAttribute("users", users);
        model.addAttribute("username", username);
        return "staff_list"; 
    }

    
    @GetMapping("/staff/{staffno}")
    public String getStaffDetails(@PathVariable String staffno, HttpSession session, Model model) {



        StaffDetailsDTO staffDetails = staffService.getStaffDetails(staffno);
        model.addAttribute("staffDetails", staffDetails);
        return "staff_details"; 
    }
}
