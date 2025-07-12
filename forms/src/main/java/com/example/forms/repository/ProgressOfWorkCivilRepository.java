package com.example.forms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.forms.model.ProgressOfWorkCivil;

public interface ProgressOfWorkCivilRepository extends JpaRepository<ProgressOfWorkCivil, Long> {

    List<ProgressOfWorkCivil> findByStaffno(String staffno);

    @Query("SELECT DISTINCT f.staffno FROM ProgressOfWorkCivil f")
    List<String> findDistinctStaffno();

    List<ProgressOfWorkCivil> findByFordepartment(String fordepartment);
}
