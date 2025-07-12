package com.example.forms.Controller;

// SuspensionReportController.java
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.forms.model.SuspensionReport;
import com.example.forms.service.SuspensionReportService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class SuspensionReportController {

    @Autowired
    private SuspensionReportService suspensionReportService;

    @GetMapping("/form-51")
    public String showForm(@SessionAttribute("username") String username, @SessionAttribute("department") String department, Model model) {
        // Add the username to the model to display it in the view
        model.addAttribute("username", username);
        model.addAttribute("department", department);
        return "form-51";  // Returns the HTML form
    }

    @PostMapping("/form-51")
public String saveSuspensionReport(@RequestParam("forquarter[]") List<String> forquarter,
@RequestParam("foryear[]") List<String> foryear,
@RequestParam List<Integer> personsUnderSuspensionStart,
                                    @RequestParam List<Integer> personsSuspended,
                                    @RequestParam List<Integer> suspensionRevoked,
                                    @RequestParam List<Integer> personsSuspended1to3Months,
                                    @RequestParam List<Integer> personsSuspended3to6Months,
                                    @RequestParam List<Integer> personsSuspendedOver6Months,
                                    @RequestParam List<Integer> totalPersonsUnderSuspensionEnd,
                                    
                                    HttpSession session) {
                                        String department = (String) session.getAttribute("department");
    String staffno = (String) session.getAttribute("staffno");                                    
    String createdBy = (String) session.getAttribute("username");
    List<SuspensionReport> reports = new ArrayList<>();

    for (int i = 0; i < personsUnderSuspensionStart.size(); i++) {
        SuspensionReport report = new SuspensionReport();

        report.setForquarter(forquarter.get(i));
        report.setForyear(foryear.get(i));
        report.setPersonsUnderSuspensionStart(personsUnderSuspensionStart.get(i));
        report.setPersonsSuspended(personsSuspended.get(i));
        report.setSuspensionRevoked(suspensionRevoked.get(i));
        report.setPersonsSuspended1to3Months(personsSuspended1to3Months.get(i));
        report.setPersonsSuspended3to6Months(personsSuspended3to6Months.get(i));
        report.setPersonsSuspendedOver6Months(personsSuspendedOver6Months.get(i));
        report.setTotalPersonsUnderSuspensionEnd(totalPersonsUnderSuspensionEnd.get(i));
        report.setFordepartment(department);
        report.setStaffno(staffno);
        report.setCreatedBy(createdBy);  // Add createdBy information

        reports.add(report);
    }

    suspensionReportService.saveSuspensionReports(reports, createdBy);
    return "redirect:/user/form-51";
}


@GetMapping("/view-suspensionreport")
    public String viewSuspensionReport(@SessionAttribute("staffno") String staffno, @SessionAttribute("username") String username, Model model) {
    // Fetch progressofwork for the logged-in user's staff number
    List<SuspensionReport> suspensionreport = suspensionReportService.getSuspensionReportByStaffno(staffno);

    // Add the data to the model to pass it to the view
    model.addAttribute("suspensionreport", suspensionreport);
    model.addAttribute("username", username);
    return "view-suspensionreport";  // Return the view template name
}




}
