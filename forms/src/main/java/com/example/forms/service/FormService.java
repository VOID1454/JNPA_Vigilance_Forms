package com.example.forms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forms.repository.ContractRepository;
import com.example.forms.repository.ExpenditureRepository;
import com.example.forms.repository.ForeignVisitRepository;
import com.example.forms.repository.Form5ARepository;
import com.example.forms.repository.Form5BRepository;
import com.example.forms.repository.Form5CRepository;
import com.example.forms.repository.PenaltyCaseRepository;
import com.example.forms.repository.ProgressOfWorkCivilRepository;
import com.example.forms.repository.ProgressOfWorkRepository;
import com.example.forms.repository.SuspensionReportRepository;

@Service
public class FormService {

    @Autowired
    private ExpenditureRepository expenditureRepository;

    @Autowired
    private ProgressOfWorkRepository progressOfWorkRepository;

    @Autowired
    private ProgressOfWorkCivilRepository progressOfWorkCivilRepository;

    @Autowired
    private ForeignVisitRepository foreignVisitRepository;

    @Autowired
    private SuspensionReportRepository suspensionReportRepository;

    @Autowired
    private PenaltyCaseRepository penaltyCaseRepository;

    @Autowired
    private Form5ARepository form5ARepository;

    @Autowired
    private Form5BRepository form5BRepository;

    @Autowired
    private Form5CRepository form5CRepository;

    @Autowired
    private ContractRepository contractRepository;

    public List<Map<String, String>> getUserFormDetails() {
        Set<String> allStaffnos = new HashSet<>();
        Map<String, String> staffnoToUsername = new HashMap<>();

        // Fetch distinct staff numbers and corresponding usernames
        expenditureRepository.findAll().forEach(entry -> {
            allStaffnos.add(entry.getStaffno());
            staffnoToUsername.put(entry.getStaffno(), entry.getCreatedBy());
        });
        progressOfWorkRepository.findAll().forEach(entry -> {
            allStaffnos.add(entry.getStaffno());
            staffnoToUsername.putIfAbsent(entry.getStaffno(), entry.getCreatedBy());
        });
        progressOfWorkCivilRepository.findAll().forEach(entry -> {
            allStaffnos.add(entry.getStaffno());
            staffnoToUsername.putIfAbsent(entry.getStaffno(), entry.getCreatedBy());
        });
        foreignVisitRepository.findAll().forEach(entry -> {
            allStaffnos.add(entry.getStaffno());
            staffnoToUsername.putIfAbsent(entry.getStaffno(), entry.getCreatedBy());
        });
        suspensionReportRepository.findAll().forEach(entry -> {
            allStaffnos.add(entry.getStaffno());
            staffnoToUsername.putIfAbsent(entry.getStaffno(), entry.getCreatedBy());
        });
        penaltyCaseRepository.findAll().forEach(entry -> {
            allStaffnos.add(entry.getStaffno());
            staffnoToUsername.putIfAbsent(entry.getStaffno(), entry.getCreatedBy());
        });
        form5ARepository.findAll().forEach(entry -> {
            allStaffnos.add(entry.getStaffno());
            staffnoToUsername.putIfAbsent(entry.getStaffno(), entry.getCreatedBy());
        });
        form5BRepository.findAll().forEach(entry -> {
            allStaffnos.add(entry.getStaffno());
            staffnoToUsername.putIfAbsent(entry.getStaffno(), entry.getCreatedBy());
        });
        form5CRepository.findAll().forEach(entry -> {
            allStaffnos.add(entry.getStaffno());
            staffnoToUsername.putIfAbsent(entry.getStaffno(), entry.getCreatedBy());
        });
        contractRepository.findAll().forEach(entry -> {
            allStaffnos.add(entry.getStaffno());
            staffnoToUsername.putIfAbsent(entry.getStaffno(), entry.getCreatedBy());
        });

        List<Map<String, String>> userDetails = new ArrayList<>();

        // Populate user details
        for (String staffno : allStaffnos) {
            Map<String, String> userDetail = new HashMap<>();
            userDetail.put("staffno", staffno);
            userDetail.put("username", staffnoToUsername.getOrDefault(staffno, "Unknown"));

            // Check each form's status (empty or filled)
            userDetail.put("form-1", expenditureRepository.findByStaffno(staffno).isEmpty() ? "red" : "green");
            userDetail.put("form-2", progressOfWorkRepository.findByStaffno(staffno).isEmpty() ? "red" : "green");
            userDetail.put("form-3", progressOfWorkCivilRepository.findByStaffno(staffno).isEmpty() ? "red" : "green");
            userDetail.put("form-4", foreignVisitRepository.findByStaffno(staffno).isEmpty() ? "red" : "green");
            userDetail.put("form-5", suspensionReportRepository.findByStaffno(staffno).isEmpty() ? "red" : "green");
            userDetail.put("form-5.1", penaltyCaseRepository.findByStaffno(staffno).isEmpty() ? "red" : "green");
            userDetail.put("form-5A", form5ARepository.findByStaffno(staffno).isEmpty() ? "red" : "green");
            userDetail.put("form-5B", form5BRepository.findByStaffno(staffno).isEmpty() ? "red" : "green");
            userDetail.put("form-5C", form5CRepository.findByStaffno(staffno).isEmpty() ? "red" : "green");
            userDetail.put("form-6", contractRepository.findByStaffno(staffno).isEmpty() ? "red" : "green");

            userDetails.add(userDetail);
        }

        return userDetails;
    }
}
