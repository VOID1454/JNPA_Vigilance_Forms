package com.example.forms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.forms.model.ForeignVisit;

public interface ForeignVisitRepository extends JpaRepository<ForeignVisit, Long> {
    // You can define custom queries here if needed
     List<ForeignVisit> findByStaffno(String staffno);

      @Query("SELECT DISTINCT f.staffno FROM ForeignVisit f")
    List<String> findDistinctStaffno();

    List<ForeignVisit> findByFordepartment(String fordepartment);
}
