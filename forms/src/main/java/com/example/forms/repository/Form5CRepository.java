package com.example.forms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.forms.model.Form5C;

public interface Form5CRepository extends JpaRepository<Form5C, Long> {
    List<Form5C> findByStaffno(String staffno);

     @Query("SELECT DISTINCT f.staffno FROM Form5C f")
    List<String> findDistinctStaffno();

    List<Form5C> findByFordepartment(String fordepartment);
}
