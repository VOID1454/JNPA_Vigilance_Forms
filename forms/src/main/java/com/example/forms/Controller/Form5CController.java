package com.example.forms.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.forms.model.Form5C;
import com.example.forms.service.Form5CService;

import jakarta.servlet.http.HttpSession;

@Controller
public class Form5CController {

    @Autowired
    private Form5CService form5CService;

    @GetMapping("/user/form-5C")
    public String showForm(@SessionAttribute("username") String username,
            @SessionAttribute("department") String department, Model model) {

        model.addAttribute("username", username);
        model.addAttribute("department", department);
        return "form-5C";
    }

    @PostMapping("/form52/saveform5C")
    public String saveform5C(
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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < officerName.size(); i++) {
            Form5C form5C = new Form5C();
            form5C.setForquarter(forquarter.get(i));
            form5C.setForyear(foryear.get(i));
            form5C.setOfficerName(officerName.get(i));

            // Handle empty chargeSheetDate
            if (i < chargeSheetDate.size() && (chargeSheetDate.get(i) == null || chargeSheetDate.get(i).isEmpty())) {
                form5C.setChargeSheetDate(null); // Set to null if empty
            } else if (i < chargeSheetDate.size()) {
                LocalDate chargeSheetDateParsed = LocalDate.parse(chargeSheetDate.get(i), formatter);
                form5C.setChargeSheetDate(chargeSheetDateParsed.toString()); // Convert to String
            } else {
                form5C.setChargeSheetDate(null); // Set to null if the index is out of bounds
            }

            // Handle empty inquiringOfficerAppointmentDate
            if (i < inquiringOfficerAppointmentDate.size() && (inquiringOfficerAppointmentDate.get(i) == null || inquiringOfficerAppointmentDate.get(i).isEmpty())) {
                form5C.setInquiryOfficerAppointedDate(null); // Set to null if empty
            } else if (i < inquiringOfficerAppointmentDate.size()) {
                LocalDate inquiryOfficerAppointedDateParsed = LocalDate.parse(inquiringOfficerAppointmentDate.get(i), formatter);
                form5C.setInquiryOfficerAppointedDate(inquiryOfficerAppointedDateParsed.toString()); // Convert to String
            } else {
                form5C.setInquiryOfficerAppointedDate(null); // Set to null if the index is out of bounds
            }

            form5C.setCaseBrief(caseBrief.get(i));
            form5C.setCurrentStatus(currentStatus.get(i));
            form5C.setRemarks(remarks.get(i));
            form5C.setStaffno(staffno);
            form5C.setFordepartment(department);
            form5C.setCreatedBy(createdBy);
            form5C.setCreatedAt(createdAt);

            form5CService.saveform5C(form5C);
        }

        return "redirect:/user/form-5C";
    }

    @GetMapping("/user/view-5C")
    public String viewForm5C(@SessionAttribute("staffno") String staffno, @SessionAttribute("username") String username,
            Model model) {
        List<Form5C> form5CList = form5CService.getForm5CByStaffno(staffno);
        model.addAttribute("form5C", form5CList);
        System.out.println("Fetched penalty cases: " + form5CList);
        model.addAttribute("username", username);
        return "view-5C";
    }
}
