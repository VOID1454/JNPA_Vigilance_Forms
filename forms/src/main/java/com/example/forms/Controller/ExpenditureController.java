package com.example.forms.Controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.forms.model.Expenditure;
import com.example.forms.model.User;
import com.example.forms.repository.ExpenditureRepository;
import com.example.forms.repository.UserRepository;
import com.example.forms.service.ExpenditureService;

@Controller
@RequestMapping("/user")
public class ExpenditureController {

    @Autowired
    private ExpenditureService expenditureService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExpenditureRepository expenditureRepository;

    @GetMapping("/form-1")
    public String showForm(@SessionAttribute("username") String username,
            @SessionAttribute("department") String department,
            Model model) {
        model.addAttribute("username", username);
        model.addAttribute("department", department);
        return "form-1";
    }

    @PostMapping("/save-table")
    public String saveTable(@ModelAttribute("object") Expenditure expDetails,

            Principal principal) {

        String username1 = principal.getName();
        User user = userRepository.findbyemailUser(username1);

        expDetails.setCreatedAt(LocalDateTime.now());
        expDetails.setUser(user);
        expDetails.setStaffno(user.getStaffno());
        expDetails.setFordepartment(user.getDepartment());
        expDetails.setCreatedBy(user.getName());

        expenditureRepository.save(expDetails);
        

        return "redirect:/user/form-1";
    }

    @GetMapping("/view-expenditures")
    public String viewExpenditures(@SessionAttribute("staffno") String staffno,
            @SessionAttribute("username") String username,
            Model model) {
        List<Expenditure> expenditures = expenditureService.getExpendituresByStaffno(staffno);
        model.addAttribute("expenditures", expenditures);
        model.addAttribute("username", username);
        return "view-expenditures";
    }

    @PostMapping("/copy-to-form")
    public String copyToForm(@RequestParam String quarter,
            @RequestParam String year,
            @RequestParam String officialName,
            @RequestParam String dateGiven,
            @RequestParam String expenditure,
            Model model) {
        model.addAttribute("quarter", quarter);
        model.addAttribute("year", year);
        model.addAttribute("officialName", officialName);
        model.addAttribute("dateGiven", dateGiven);
        model.addAttribute("expenditure", expenditure);
        return "form-1"; // Redirect to the form page
    }


    
}