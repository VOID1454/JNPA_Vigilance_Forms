package com.example.forms.service;

// SuspensionReportService.java
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forms.model.SuspensionReport;
import com.example.forms.repository.SuspensionReportRepository;

@Service
public class SuspensionReportService {
    
    


    @Autowired
    private SuspensionReportRepository suspensionReportRepository;

    public void saveSuspensionReports(List<SuspensionReport> reports, String createdBy) {
        for (SuspensionReport report : reports) {
           
            report.setCreatedBy(createdBy);
            report.setCreatedAt(LocalDateTime.now());
            suspensionReportRepository.save(report);
        }
    }
    public List<SuspensionReport> getSuspensionReportByStaffno(String staffno) {
        return suspensionReportRepository.findByStaffno(staffno); // Use the autowired instance
    }
    
}

