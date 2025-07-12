package com.example.forms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forms.model.Contract;
import com.example.forms.repository.ContractRepository;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    public void saveContractData(
            List<String> todepartment, List<String> section, List<String> forthemonth,
            List<String> tenderNos, List<String> natureOfWorks, List<String> tenderEnquiries,
            List<String> nitDates, List<String> biddingTypes, List<String> receiptDates,
            List<String> tenderReceiveds, List<String> qualifiedParties, List<String> notQualifiedParties,
            List<String> contractL1s, List<String> contractNos, List<String> contractorNames,
            List<String> contractValues, List<String> startDates, List<String> completionDates,
            List<String> actualCompletionDates, List<String> delayReasons, List<String> remarks,
            String staffno, String createdBy, String fordepartment, List<String> alertremark ) {

        Date createdAt = new Date(); // Current timestamp

        for (int i = 0; i < tenderNos.size(); i++) {
            Contract contract = new Contract(
                    todepartment.get(i), section.get(i), forthemonth.get(i),
                    tenderNos.get(i), natureOfWorks.get(i), tenderEnquiries.get(i),
                    nitDates.get(i), biddingTypes.get(i), receiptDates.get(i),
                    tenderReceiveds.get(i), qualifiedParties.get(i), notQualifiedParties.get(i),
                    contractL1s.get(i), contractNos.get(i), contractorNames.get(i),
                    contractValues.get(i), startDates.get(i), completionDates.get(i),
                    actualCompletionDates.get(i), delayReasons.get(i), remarks.get(i),
                    createdAt, staffno, createdBy, fordepartment, alertremark.get(i)  );

            contractRepository.save(contract);
        }
    }

    public List<Contract> getContractByStaffno(String staffno) {
        return contractRepository.findByStaffno(staffno); 
    }
}
