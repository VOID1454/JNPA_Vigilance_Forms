package com.example.forms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.forms.model.Form5A;

public interface Form5ARepository extends JpaRepository<Form5A, Long> {

List<Form5A> findByStaffno(String staffno);

 @Query("SELECT DISTINCT f.staffno FROM Form5A f")
    List<String> findDistinctStaffno();
    
    List<Form5A> findByFordepartment(String fordepartment);
}
