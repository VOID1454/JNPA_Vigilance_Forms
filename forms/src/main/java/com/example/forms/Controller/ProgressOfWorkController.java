package com.example.forms.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.forms.model.ProgressOfWork;
import com.example.forms.service.ProgressOfWorkService;

@Controller
@RequestMapping("/user")
public class ProgressOfWorkController {

    @Autowired
    private ProgressOfWorkService progressOfWorkService;

    @RequestMapping("/form-2")
    // ======================================
    // set username and department in session
    // ======================================
    public String showForm(@SessionAttribute("username") String username,
            @SessionAttribute("department") String department, Model model) {

        model.addAttribute("username", username);
        model.addAttribute("department", department);
        return "form-2";
    }

  @PostMapping("/save-progress")
public String saveProgress(@RequestParam("forquarter[]") List<String> forquarter,
        @RequestParam("foryear[]") List<String> foryear,
        @RequestParam("itemName[]") List<String> itemNames,
        @RequestParam("estimatedCost[]") List<String> estimatedCosts,
        @RequestParam("tenderedCost[]") List<String> tenderedCosts,
        @RequestParam("ratePercentage[]") List<String> ratePercentages,
        @RequestParam("agreementNo[]") List<String> agreementNos,
        @RequestParam("commencementDate[]") List<String> commencementDates,
        @RequestParam("completionTime[]") List<String> completionTimes,
        @RequestParam("physicalProgress[]") List<String> physicalProgresses,
        @RequestParam("engineerName[]") List<String> engineerNames,
        @RequestParam("remarks[]") List<String> remarks,
        @SessionAttribute("staffno") String staffno,
        @SessionAttribute("department") String department,
        @SessionAttribute("username") String username) {

    // Log the input lists
    System.out.println("For Quarter: " + forquarter);
    System.out.println("For Year: " + foryear);
    System.out.println("Item Names: " + itemNames);
    System.out.println("Estimated Costs: " + estimatedCosts);
    System.out.println("Tendered Costs: " + tenderedCosts);
    System.out.println("Rate Percentages: " + ratePercentages);
    System.out.println("Agreement Nos: " + agreementNos);
    System.out.println("Commencement Dates: " + commencementDates);
    System.out.println("Completion Times: " + completionTimes);
    System.out.println("Physical Progresses: " + physicalProgresses);
    System.out.println("Engineer Names: " + engineerNames);
    System.out.println("Remarks: " + remarks);

    // Check if any of the lists are empty
    if (forquarter.isEmpty() || foryear.isEmpty() || itemNames.isEmpty() || 
        estimatedCosts.isEmpty() || tenderedCosts.isEmpty() || 
        ratePercentages.isEmpty() || agreementNos.isEmpty() || 
        completionTimes.isEmpty() || physicalProgresses.isEmpty() || 
        engineerNames.isEmpty() || remarks.isEmpty()) {
        // Handle the error, e.g., redirect back to the form with an error message
        return "redirect:/user/form-2?error=Please fill out the form completely.";
    }

    List<ProgressOfWork> progressList = new ArrayList<>();
    Date createdAt = new Date();

    for (int i = 0; i < itemNames.size(); i++) {
        ProgressOfWork progress = new ProgressOfWork();
        progress.setForquarter(forquarter.get(i));
        progress.setForyear(foryear.get(i));
        progress.setItemName(itemNames.get(i));
        progress.setEstimatedCost(estimatedCosts.get(i));
        progress.setTenderedCost(tenderedCosts.get(i));
        progress.setRatePercentage(ratePercentages.get(i));
        progress.setAgreementNo(agreementNos.get(i));

        // Handle empty date
        if (i < commencementDates.size() && (commencementDates.get(i) == null || commencementDates.get(i).isEmpty())) {
            progress.setCommencementDate(null); // Set to null if empty
        } else if (i < commencementDates.size()) {
            progress.setCommencementDate(commencementDates.get(i)); // Set the date if available
        } else {
            progress.setCommencementDate(null); // Set to null if the index is out of bounds
        }

        progress.setCompletionTime(completionTimes.get(i));
        progress.setPhysicalProgress(physicalProgresses.get(i));
        progress.setEngineerName(engineerNames.get(i));
        progress.setRemarks(remarks.get(i));
        progress.setStaffno(staffno);
        progress.setCreatedBy(username);
        progress.setFordepartment(department);
        progress.setCreatedAt(createdAt);

        progressList.add(progress);
        progressOfWorkService.saveProgress(progress);
    }

    return "redirect:/user/form-2"; // Redirect after saving
}






    @GetMapping("/view-progressofwork")
    public String viewProgressOfWork(@SessionAttribute("staffno") String staffno,
            @SessionAttribute("username") String username, Model model) {
        // Fetch progressofwork for the logged-in user's staff number
        List<ProgressOfWork> progressofwork = progressOfWorkService.getProgressOfWorkByStaffno(staffno);

        // Add the data to the model to pass it to the view also add department?

        model.addAttribute("progressofwork", progressofwork);
        model.addAttribute("username", username);
        return "view-progressofwork"; // Return the view template name
    }
}
