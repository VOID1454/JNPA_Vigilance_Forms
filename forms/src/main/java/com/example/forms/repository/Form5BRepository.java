package com.example.forms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.forms.model.Form5B;

public interface Form5BRepository extends JpaRepository<Form5B, Long> {

    List<Form5B> findByStaffno(String staffno);

    @Query("SELECT DISTINCT f.staffno FROM Form5B f")
    List<String> findDistinctStaffno();

     List<Form5B> findByFordepartment(String fordepartment);
}
