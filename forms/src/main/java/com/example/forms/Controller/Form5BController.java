package com.example.forms.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.forms.model.Form5B;
import com.example.forms.service.Form5BService;

import jakarta.servlet.http.HttpSession;

@Controller
public class Form5BController {

    @Autowired
    private Form5BService form5BService;

    @GetMapping("/user/form-5B")
    public String showForm(@SessionAttribute("username") String username, @SessionAttribute("department") String department, Model model) {
       
        model.addAttribute("username", username);
        model.addAttribute("department", department);
        return "form-5B"; 
    }

     @PostMapping("/form52/saveform5B")
    public String saveForm5B(
        @RequestParam("forquarter[]") List<String> forquarter,
        @RequestParam("foryear[]") List<String> foryear,
        @RequestParam List<String> officerName,
        @RequestParam List<String> chargeSheetDate,
        @RequestParam List<String> inquiringOfficerAppointmentDate,
        @RequestParam List<String> caseBrief,
        @RequestParam List<String> currentStatus,
        @RequestParam List<String> remarks,
        @SessionAttribute("department") String department,
        HttpSession session) {

        // Decode all textarea inputs by replacing "|" with ","
        officerName = officerName.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
        caseBrief = caseBrief.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
        currentStatus = currentStatus.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
        remarks = remarks.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());

        String staffno = (String) session.getAttribute("staffno");                        
        String createdBy = (String) session.getAttribute("username");
        String createdAt = java.time.LocalDateTime.now().toString();

        for (int i = 0; i < officerName.size(); i++) {
            Form5B form5B = new Form5B();
            form5B.setForquarter(forquarter.get(i));
            form5B.setForyear(foryear.get(i));
            form5B.setOfficerName(officerName.get(i));

            // Handle empty chargeSheetDate
            if (i < chargeSheetDate.size() && (chargeSheetDate.get(i) == null || chargeSheetDate.get(i).isEmpty())) {
                form5B.setChargeSheetDate(null); // Set to null if empty
            } else if (i < chargeSheetDate.size()) {
                form5B.setChargeSheetDate(chargeSheetDate.get(i)); // Set the date if available
            } else {
                form5B.setChargeSheetDate(null); // Set to null if the index is out of bounds
            }

            // Handle empty inquiringOfficerAppointmentDate
            if (i < inquiringOfficerAppointmentDate.size() && (inquiringOfficerAppointmentDate.get(i) == null || inquiringOfficerAppointmentDate.get(i).isEmpty())) {
                form5B.setInquiryOfficerAppointedDate(null); // Set to null if empty
            } else if (i < inquiringOfficerAppointmentDate.size()) {
                form5B.setInquiryOfficerAppointedDate(inquiringOfficerAppointmentDate.get(i)); // Set the date if available
            } else {
                form5B.setInquiryOfficerAppointedDate(null); // Set to null if the index is out of bounds
            }

            form5B.setCaseBrief(caseBrief.get(i));  
            form5B.setCurrentStatus(currentStatus.get(i));
            form5B.setRemarks(remarks.get(i));
            form5B.setStaffno(staffno);
            form5B.setFordepartment(department);
            form5B.setCreatedBy(createdBy);
            form5B.setCreatedAt(createdAt);

            form5BService.saveForm5B(form5B);
        }
        return "redirect:/user/form-5B"; 
    }

    @GetMapping("/user/view-5B")
    public String viewForm5B(@SessionAttribute("staffno") String staffno, @SessionAttribute("username") String username,
    Model model) {
        List<Form5B> form5BList = form5BService.getForm5BByStaffno(staffno);
        model.addAttribute("form5B", form5BList);
        System.out.println("Fetched penalty cases: " + form5BList); 
        model.addAttribute("username", username);
        return "view-5B"; 
    }
}
