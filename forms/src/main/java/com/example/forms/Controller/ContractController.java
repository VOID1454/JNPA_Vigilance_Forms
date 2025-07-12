package com.example.forms.Controller;

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

import com.example.forms.model.Contract;
import com.example.forms.service.ContractService;

@Controller
@RequestMapping("/user")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @RequestMapping("/form-6")
    public String showForm(@SessionAttribute("username") String username, @SessionAttribute("department") String department, Model model) {
       
        model.addAttribute("username", username);
        model.addAttribute("department", department);
        return "form-6"; 
    }

    @PostMapping("/save-table-6")
public String saveTable(
        @RequestParam(value = "todepartment[]", required = false) List<String> todepartment,  
        @RequestParam(value = "section[]", required = false) List<String> section,
        @RequestParam(value = "forthemonth[]", required = false) List<String> forthemonth,
        @RequestParam(value = "tenderNo[]", required = false) List<String> tenderNos,
        @RequestParam(value = "natureOfWork[]", required = false) List<String> natureOfWorks,
        @RequestParam(value = "tenderEnquiry[]", required = false) List<String> tenderEnquiries,
        @RequestParam(value = "nitDate[]", required = false) List<String> nitDates,
        @RequestParam(value = "biddingType[]", required = false) List<String> biddingTypes,
        @RequestParam(value = "receiptDate[]", required = false) List<String> receiptDates,
        @RequestParam(value = "tenderReceived[]", required = false) List<String> tenderReceiveds,
        @RequestParam(value = "qualifiedParties[]", required = false) List<String> qualifiedParties,
        @RequestParam(value = "notQualifiedParties[]", required = false) List<String> notQualifiedParties,
        @RequestParam(value = "contractL1[]", required = false) List<String> contractL1s,
        @RequestParam(value = "contractNo[]", required = false) List<String> contractNos,
        @RequestParam(value = "contractorName[]", required = false) List<String> contractorNames,
        @RequestParam(value = "contractValue[]", required = false) List<String> contractValues,
        @RequestParam(value = "startDate[]", required = false) List<String> startDates,
        @RequestParam(value = "completionDate[]", required = false) List<String> completionDates,
        @RequestParam(value = "actualCompletionDate[]", required = false) List<String> actualCompletionDates,
        @RequestParam(value = "delayReason[]", required = false) List<String> delayReasons,
        @RequestParam(value = "remarks[]", required = false) List<String> remarks,
        @RequestParam(value = "alertremark[]", required = false) List<String> alertremark,
        @SessionAttribute("staffno") String staffno,
        @SessionAttribute("username") String username,
        @SessionAttribute("department") String department) {

    // Replace null or empty lists with default values
    todepartment = (todepartment == null || todepartment.isEmpty()) ? List.of("") : todepartment;
    section = (section == null || section.isEmpty()) ? List.of("") : section;
    forthemonth = (forthemonth == null || forthemonth.isEmpty()) ? List.of("") : forthemonth;
    tenderNos = (tenderNos == null || tenderNos.isEmpty()) ? List.of("") : tenderNos;
    natureOfWorks = (natureOfWorks == null || natureOfWorks.isEmpty()) ? List.of("") : natureOfWorks;
    tenderEnquiries = (tenderEnquiries == null || tenderEnquiries.isEmpty()) ? List.of("") : tenderEnquiries;
    nitDates = (nitDates == null || nitDates.isEmpty()) ? List.of("") : nitDates;
    biddingTypes = (biddingTypes == null || biddingTypes.isEmpty()) ? List.of("") : biddingTypes;
    receiptDates = (receiptDates == null || receiptDates.isEmpty()) ? List.of("") : receiptDates;
    tenderReceiveds = (tenderReceiveds == null || tenderReceiveds.isEmpty()) ? List.of("") : tenderReceiveds;
    qualifiedParties = (qualifiedParties == null || qualifiedParties.isEmpty()) ? List.of("") : qualifiedParties;
    notQualifiedParties = (notQualifiedParties == null || notQualifiedParties.isEmpty()) ? List.of("") : notQualifiedParties;
    contractL1s = (contractL1s == null || contractL1s.isEmpty()) ? List.of("") : contractL1s;
    contractNos = (contractNos == null || contractNos.isEmpty()) ? List.of("") : contractNos;
    contractorNames = (contractorNames == null || contractorNames.isEmpty()) ? List.of("") : contractorNames;
    contractValues = (contractValues == null || contractValues.isEmpty()) ? List.of("") : contractValues;
    startDates = (startDates == null || startDates.isEmpty()) ? List.of("") : startDates;
    completionDates = (completionDates == null || completionDates.isEmpty()) ? List.of("") : completionDates;
    actualCompletionDates = (actualCompletionDates == null || actualCompletionDates.isEmpty()) ? List.of("") : actualCompletionDates;
    delayReasons = (delayReasons == null || delayReasons.isEmpty()) ? List.of("") : delayReasons;
    remarks = (remarks == null || remarks.isEmpty()) ? List.of("") : remarks;

    // Decode textarea inputs by replacing "|" with "," to prevent encoding issues
    todepartment = todepartment.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
    section = section.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
    forthemonth = forthemonth.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
    tenderNos = tenderNos.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
    natureOfWorks = natureOfWorks.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
    tenderEnquiries = tenderEnquiries.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
    biddingTypes = biddingTypes.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
    tenderReceiveds = tenderReceiveds.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
    qualifiedParties = qualifiedParties.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
    notQualifiedParties = notQualifiedParties.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
    contractNos = contractNos.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
    contractorNames = contractorNames.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
    contractValues = contractValues.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
    delayReasons = delayReasons.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());
    remarks = remarks.stream().map(s -> s.replace("|", ",")).collect(Collectors.toList());

    contractService.saveContractData(
            todepartment, section, forthemonth, tenderNos, natureOfWorks, tenderEnquiries, nitDates, biddingTypes, receiptDates,
            tenderReceiveds, qualifiedParties, notQualifiedParties, contractL1s, contractNos,
            contractorNames, contractValues, startDates, completionDates, actualCompletionDates,
            delayReasons, remarks, staffno, username, department, alertremark);

    return "redirect:/user/form-6"; 
}


    @GetMapping("/view-contract")
    public String viewContract(@SessionAttribute("staffno") String staffno,@SessionAttribute("username") String username,@SessionAttribute("department") String department,

    Model model) {
        List<Contract> contractList = contractService.getContractByStaffno(staffno);
        model.addAttribute("contract", contractList);
        System.out.println("Fetched penalty cases: " + contractList); 
        model.addAttribute("username", username);
        model.addAttribute("department", department);
        return "view-contract"; 
    }
}
