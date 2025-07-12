package com.example.forms.Controller;

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

import com.example.forms.model.ForeignVisit;
import com.example.forms.service.ForeignVisitService;

@Controller
@RequestMapping("/user")
public class ForeignVisitController {

    @Autowired
    private ForeignVisitService foreignVisitService;

    @RequestMapping("/form-4")
    public String showForm(@SessionAttribute("username") String username, @SessionAttribute("department") String department, Model model) {
        
        model.addAttribute("username", username);
        model.addAttribute("department", department);
        return "form-4"; 
    }

    @PostMapping("/save-table-4")
    public String saveTable( 
        // @RequestParam("forquarter[]") List<String> forquarter,
    @RequestParam("foryear[]") List<String> foryear,
            @RequestParam("nameDesignation[]") List<String> namesAndDesignations,
            @RequestParam("estaffno[]") List<String> estaffno,
            @RequestParam("countryVisited[]") List<String> countriesVisited,
            @RequestParam("durationOfStay[]") List<String> durationsOfStay,
            @RequestParam("sourceOfFunding[]") List<String> sourcesOfFunding,
            @RequestParam("remarks[]") List<String> remarks,
            @SessionAttribute("staffno") String staffno, 
            @SessionAttribute("department") String department,
            @SessionAttribute("username") String username) {

    // Decode all textarea inputs by replacing "|" with ","
    namesAndDesignations = namesAndDesignations.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
    estaffno = estaffno.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());            
    countriesVisited = countriesVisited.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
    durationsOfStay = durationsOfStay.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
    sourcesOfFunding = sourcesOfFunding.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());


       
        // System.out.println("Names and Designations: " + namesAndDesignations);
        // System.out.println("Countries Visited: " + countriesVisited);
        // System.out.println("Durations of Stay: " + durationsOfStay);
        // System.out.println("Sources of Funding: " + sourcesOfFunding);
        // System.out.println("Remarks: " + remarks);

       
        Date createdAt = new Date();

        foreignVisitService.saveForeignVisitData(  foryear, namesAndDesignations, estaffno, countriesVisited, durationsOfStay, sourcesOfFunding, remarks, createdAt, staffno, department, username);

        return "redirect:/user/form-4";
    }


    @GetMapping("/view-foreignvisits")
    public String viewForeignVisits(@SessionAttribute("staffno") String staffno,@SessionAttribute("username") String username, Model model) {
        
        List<ForeignVisit> foreignVisits = foreignVisitService.getForeignVisitsByStaffno(staffno);

       
        model.addAttribute("foreignVisits", foreignVisits);
        model.addAttribute("username", username);
        return "view-foreignvisits"; 
    }


}
