package com.example.forms.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forms.model.Expenditure;
import com.example.forms.repository.ExpenditureRepository;


@Service
public class ExpenditureService {

    @Autowired
    private ExpenditureRepository expenditureRepository;

    public void saveExpenditure(Expenditure form1) {
        expenditureRepository.save(form1);
    }

    public List<Expenditure> getExpendituresByStaffno(String staffno) {
        return expenditureRepository.findByStaffno(staffno);
    }
}






// @Service
// public class ExpenditureService {

//     @Autowired
//     private ExpenditureRepository expenditureRepository;

//     public void saveExpenditureData(List<String> forquarter, List<String> foryear, List<String> officialNames, List<String> dateGiven, List<String> expenditures, String Staffno, String department, String createdBy) {
//         for (int i = 0; i < officialNames.size(); i++) {



//             Form1 expenditure = new Form1();
//             expenditure.setForquarter(forquarter.get(i));
//             expenditure.setForyear(foryear.get(i));
//             expenditure.setOfficialName(officialNames.get(i));
//             expenditure.setDateGiven(dateGiven.get(i));
//             expenditure.setExpenditure(expenditures.get(i));
//             expenditure.setStaffno(Staffno);
//             expenditure.setCreatedBy(createdBy);
//             expenditure.setFordepartment(department);
            
//             expenditure.setCreatedAt(LocalDateTime.now());

//             // Save each expenditure record to the database
//             expenditureRepository.save(expenditure);
//         }
//     }

//     public List<Form1> getExpendituresByStaffno(String staffno) {
//         return expenditureRepository.findByStaffno(staffno);
//     }

    

    
// }
