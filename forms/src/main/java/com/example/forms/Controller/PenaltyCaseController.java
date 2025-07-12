package com.example.forms.Controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.forms.model.PenaltyCase;
import com.example.forms.service.PenaltyCaseService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class PenaltyCaseController {

    @Autowired
    private PenaltyCaseService penaltyCaseService;

    @GetMapping("/form-52")
    public String showForm(@SessionAttribute("username") String username, @SessionAttribute("department") String department, Model model) {
     
        model.addAttribute("username", username);
        model.addAttribute("department", department);
        return "form-52"; 
    }

    @PostMapping(value = "/save-penalty-cases", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public String savePenaltyCases(@RequestBody PenaltyCase[] penaltyCases, HttpSession session) {
        String createdBy = (String) session.getAttribute("username");
        String staffno = (String) session.getAttribute("staffno");
        String department = (String) session.getAttribute("department");

        
        if (createdBy == null || staffno == null) {
            throw new RuntimeException("User not logged in or staffno not found");
        }

        
        for (PenaltyCase penaltyCase : penaltyCases) {
            penaltyCase.setCreatedBy(createdBy);
            penaltyCase.setStaffno(staffno);
            penaltyCase.setFordepartment(department);
            penaltyCase.setCreatedAt(LocalDateTime.now()); 
        }

       
        penaltyCaseService.savePenaltyCases(Arrays.asList(penaltyCases), createdBy);

        return "{\"message\":\"Saved successfully\"}";
    }

    @GetMapping("/view-penaltycase")
    public String viewPenaltyCase(@SessionAttribute("staffno") String staffno, @SessionAttribute("username") String username, Model model) {
        List<PenaltyCase> penaltyCaseList = penaltyCaseService.getPenaltyCaseByStaffno(staffno);
        model.addAttribute("penaltycase", penaltyCaseList);
        System.out.println("Fetched penalty cases: " + penaltyCaseList); 
        model.addAttribute("username", username);
        return "view-penaltycase"; 
    }
}
