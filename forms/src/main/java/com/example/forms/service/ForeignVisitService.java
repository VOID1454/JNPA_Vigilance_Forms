package com.example.forms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forms.model.ForeignVisit;
import com.example.forms.repository.ForeignVisitRepository;

@Service
public class ForeignVisitService {

    @Autowired
    private ForeignVisitRepository foreignVisitRepository;

    public void saveForeignVisitData(
        // List<String> forquarter,
        List<String> foryear,
            List<String> nameDesignations,
            List<String> estaffno,
            List<String> countriesVisited,
            List<String> durationsOfStay,
            List<String> sourcesOfFunding,
            List<String> remarks,
            Date createdAt,
            String staffno,
            String department,
            String createdBy) {



               
        // Save each row into the database
        for (int i = 0; i < nameDesignations.size(); i++) {
            ForeignVisit foreignVisit = new ForeignVisit();
            // foreignVisit.setForquarter(forquarter.get(i));
            foreignVisit.setForyear(foryear.get(i));
            foreignVisit.setNameDesignation(nameDesignations.get(i));
            foreignVisit.setEstaffno(estaffno.get(i));
            foreignVisit.setCountryVisited(countriesVisited.get(i));
            foreignVisit.setDurationOfStay(durationsOfStay.get(i));
            foreignVisit.setSourceOfFunding(sourcesOfFunding.get(i));
            foreignVisit.setRemarks(remarks.size() > i ? remarks.get(i) : "");
            foreignVisit.setCreatedAt(createdAt);
            foreignVisit.setStaffno(staffno);  // Set created date
            foreignVisit.setFordepartment(department);
            foreignVisit.setCreatedBy(createdBy);  // Set logged-in user

            // Save the entity to the database
            foreignVisitRepository.save(foreignVisit);
        }
    }

    public List<ForeignVisit> getForeignVisitsByStaffno(String staffno) {
        return foreignVisitRepository.findByStaffno(staffno); // Call the method on the autowired instance
    }

}
