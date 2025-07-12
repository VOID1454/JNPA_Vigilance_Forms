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

import com.example.forms.model.Form5A;
import com.example.forms.service.Form5AService;

import jakarta.servlet.http.HttpSession;

@Controller
public class Form5AController {

    @Autowired
    private Form5AService form5AService;

    @GetMapping("/user/form-5A")
    public String showForm(@SessionAttribute("username") String username, @SessionAttribute("department") String department, Model model) {
        // Add the username to the model to display it in the view
        model.addAttribute("username", username);
        model.addAttribute("department", department);
        return "form-5A"; // Your HTML page name (form-5A.html)
    }

     @PostMapping("/form52/saveform5A")
    public String saveForm5A(@RequestParam("forquarter[]") List<String> forquarter,
                              @RequestParam("foryear[]") List<String> foryear,
                              @RequestParam List<String> officerName,
                              @RequestParam List<String> suspensionDate,
                              @RequestParam List<String> reasonForSuspension,
                              @RequestParam List<String> casesReviewed,
                              @RequestParam List<String> currentStatus,
                              @RequestParam List<String> remarks,
                              @SessionAttribute("department") String department,
                              HttpSession session) {

        // Decode all textarea inputs by replacing "|" with ","
        officerName = officerName.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
        reasonForSuspension = reasonForSuspension.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
        currentStatus = currentStatus.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
        remarks = remarks.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());

        String staffno = (String) session.getAttribute("staffno");
        String createdBy = (String) session.getAttribute("username");
        String createdAt = java.time.LocalDateTime.now().toString();

        for (int i = 0; i < officerName.size(); i++) {
            Form5A form5A = new Form5A();
            form5A.setOfficerName(officerName.get(i));
            form5A.setForquarter(forquarter.get(i));
            form5A.setForyear(foryear.get(i));

            // Handle empty suspension date
            if (i < suspensionDate.size() && (suspensionDate.get(i) == null || suspensionDate.get(i).isEmpty())) {
                form5A.setSuspensionDate(null); // Set to null if empty
            } else if (i < suspensionDate.size()) {
                form5A.setSuspensionDate(suspensionDate.get(i)); // Set the date if available
            } else {
                form5A.setSuspensionDate(null); // Set to null if the index is out of bounds
            }

            form5A.setReasonForSuspension(reasonForSuspension.get(i));
            form5A.setCasesReviewed(casesReviewed.get(i));
            form5A.setCurrentStatus(currentStatus.get(i));
            form5A.setRemarks(remarks.get(i));
            form5A.setStaffno(staffno);
            form5A.setFordepartment(department);
            form5A.setCreatedBy(createdBy);
            form5A.setCreatedAt(createdAt);

            form5AService.saveForm5A(form5A);
        }
        return "redirect:/user/form-5A";
    }
            
    @GetMapping("/user/view-5A")
    public String viewForm5A(@SessionAttribute("staffno") String staffno, @SessionAttribute("username") String username,
    Model model) {
        List<Form5A> form5AList = form5AService.getForm5AByStaffno(staffno);
        model.addAttribute("form5A", form5AList);
        System.out.println("Fetched penalty cases: " + form5AList); 
        model.addAttribute("username", username);
        return "view-5A"; 
    }
    
}










