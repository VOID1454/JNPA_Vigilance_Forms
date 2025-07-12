package com.example.forms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.forms.model.ProgressOfWork;

@Repository
public interface ProgressOfWorkRepository extends JpaRepository<ProgressOfWork, Long> {
    // Custom database queries can be added here

    List<ProgressOfWork> findByFordepartment(String fordepartment);


    List<ProgressOfWork> findByStaffno(String staffno);

    @Query("SELECT DISTINCT p.staffno FROM ProgressOfWork p")
    List<String> findDistinctStaffno();

    
}
