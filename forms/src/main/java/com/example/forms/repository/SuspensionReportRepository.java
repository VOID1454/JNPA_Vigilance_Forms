package com.example.forms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.forms.model.SuspensionReport;

public interface SuspensionReportRepository extends JpaRepository<SuspensionReport, Long> {
    // Custom query methods can be defined here if needed
    
    List<SuspensionReport> findByStaffno(String staffno);

    @Query("SELECT DISTINCT s.staffno FROM SuspensionReport s")
    List<String> findDistinctStaffno();

    
 List<SuspensionReport> findByFordepartment(String fordepartment);
}
