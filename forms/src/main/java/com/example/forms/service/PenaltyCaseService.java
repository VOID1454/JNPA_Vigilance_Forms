package com.example.forms.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.forms.model.PenaltyCase;
import com.example.forms.repository.PenaltyCaseRepository;

@Service
public class PenaltyCaseService {
    private final PenaltyCaseRepository penaltyCaseRepository;

    public PenaltyCaseService(PenaltyCaseRepository penaltyCaseRepository) {
        this.penaltyCaseRepository = penaltyCaseRepository;
    }

    public void savePenaltyCases(List<PenaltyCase> cases, String createdBy) {
        for (PenaltyCase penaltyCase : cases) {
            
            penaltyCase.setCreatedBy(createdBy);
            penaltyCase.setCreatedAt(LocalDateTime.now());
            penaltyCaseRepository.save(penaltyCase);
        }
    }


    public List<PenaltyCase> getPenaltyCaseByStaffno(String staffno) {
        return penaltyCaseRepository.findByStaffno(staffno); // Use the autowired instance
    }
}
