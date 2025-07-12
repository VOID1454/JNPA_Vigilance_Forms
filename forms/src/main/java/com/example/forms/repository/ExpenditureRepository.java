package com.example.forms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.forms.model.Expenditure;

public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {
    
    List<Expenditure> findByStaffno(String staffno);
    
    List<Expenditure> findByFordepartment(String fordepartment);
    

    //  @Query("SELECT DISTINCT e.staffno FROM Expenditure e")
    // List<String> findDistinctStaffno();

}
