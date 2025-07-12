package com.example.forms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.forms.model.PenaltyCase;

@Repository
public interface PenaltyCaseRepository extends JpaRepository<PenaltyCase, Long> {

List<PenaltyCase> findByStaffno(String staffno);

@Query("SELECT DISTINCT p.staffno FROM PenaltyCase p")
    List<String> findDistinctStaffno();

List<PenaltyCase> findByFordepartment(String fordepartment);
}