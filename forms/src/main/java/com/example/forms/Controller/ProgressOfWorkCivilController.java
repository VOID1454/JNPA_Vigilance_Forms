package com.example.forms.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.forms.model.ProgressOfWorkCivil;
import com.example.forms.service.ProgressOfWorkCivilService;

@Controller
@RequestMapping("/user")
public class ProgressOfWorkCivilController {

    @Autowired
    private ProgressOfWorkCivilService progressOfWorkCivilService;

    @RequestMapping("/form-3")
    public String showForm(@SessionAttribute("username") String username, @SessionAttribute("department") String department, Model model) {
        // Add the username to the model
        model.addAttribute("username", username);
        model.addAttribute("department", department);
        return "form-3";  // Return the form view (form-3.html)
    }


    @PostMapping("/save-progress-form-3")
    public String saveProgress(@RequestParam("forquarter[]") List<String> forquarter,
            @RequestParam("foryear[]") List<String> foryear,
            @RequestParam("descriptionOfWork[]") List<String> descriptionOfWork,
            @RequestParam("estimatedCost[]") List<String> estimatedCost,
            @RequestParam("tenderedCost[]") List<String> tenderedCost,
            @RequestParam("ratePercentage[]") List<String> ratePercentage,
            @RequestParam("agreementNo[]") List<String> agreementNo,
            @RequestParam("agency[]") List<String> agency,
            @RequestParam("commencementDate[]") List<String> commencementDate,
            @RequestParam("completionTime[]") List<String> completionTime,
            @RequestParam("physicalProgress[]") List<String> physicalProgress,
            @RequestParam("contractvalue[]") List<String> contractvalue,
            @RequestParam("engineerInCharge[]") List<String> engineerInCharge,
            @RequestParam("remarks[]") List<String> remarks,
            @SessionAttribute("staffno") String staffno,  
            @SessionAttribute("department") String department,
            @SessionAttribute("username") String username) throws ParseException {

// Replace '|' with ',' in all input fields
        forquarter = forquarter.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
        descriptionOfWork = descriptionOfWork.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
        estimatedCost = estimatedCost.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
        tenderedCost = tenderedCost.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
        ratePercentage = ratePercentage.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
        agreementNo = agreementNo.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
        agency = agency.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
        completionTime = completionTime.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
        physicalProgress = physicalProgress.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
        contractvalue = contractvalue.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
        engineerInCharge = engineerInCharge.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
        remarks = remarks.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date createdAt = new Date();  // Set the current timestamp for createdAt
        // Loop through the list to save each progress entry
        for (int i = 0; i < descriptionOfWork.size(); i++) {
            ProgressOfWorkCivil progress = new ProgressOfWorkCivil();
            // Set the values from the form
            progress.setForquarter(forquarter.get(i));
            progress.setForyear(foryear.get(i));
            progress.setDescriptionOfWork(descriptionOfWork.get(i));
            progress.setEstimatedCost(estimatedCost.get(i));
            progress.setTenderedCost(tenderedCost.get(i));
            progress.setRatePercentage(ratePercentage.get(i));
            progress.setAgreementNo(agreementNo.get(i));
            progress.setAgency(agency.get(i));
            // Handle empty commencement date
            if (i < commencementDate.size() && (commencementDate.get(i) == null || commencementDate.get(i).isEmpty())) {
                progress.setCommencementDate(null); // Set to null if empty
            } else if (i < commencementDate.size()) {
                progress.setCommencementDate(sdf.parse(commencementDate.get(i))); // Parse the date if available
            } else {
                progress.setCommencementDate(null); // Set to null if the index is out of bounds
            }
            progress.setCompletionTime(completionTime.get(i));
            progress.setPhysicalProgress(physicalProgress.get(i));
            progress.setContractValue(contractvalue.get(i));
            progress.setEngineerInCharge(engineerInCharge.get(i));
            progress.setRemarks(remarks.get(i));
            progress.setStaffno(staffno);
            // Set createdBy and createdAt
            progress.setCreatedBy(username);
            progress.setFordepartment(department);
            progress.setCreatedAt(createdAt);
            // Save each progress record
            progressOfWorkCivilService.saveProgress(progress);
        }
        return "redirect:/user/form-3";  // Redirect after saving
    }


    @GetMapping("/view-progressofworkCivil")
    public String viewProgressOfWork(@SessionAttribute("staffno") String staffno, @SessionAttribute("username") String username, Model model) {
        // Fetch progressofwork for the logged-in user's staff number
        List<ProgressOfWorkCivil> progressOfWorkCivil = progressOfWorkCivilService.getProgressOfWorkCivilByStaffno(staffno);
    
        // Add the data to the model to pass it to the view
        model.addAttribute("progressofworkcivil", progressOfWorkCivil);
        // Add the username to the model
        model.addAttribute("username", username);
        return "view-progressofworkcivil";  // Return the view template name
    }

}
