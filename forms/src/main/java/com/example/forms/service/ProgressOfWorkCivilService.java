package com.example.forms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forms.model.ProgressOfWorkCivil;
import com.example.forms.repository.ProgressOfWorkCivilRepository;

@Service
public class ProgressOfWorkCivilService {

    @Autowired
    private ProgressOfWorkCivilRepository progressOfWorkCivilRepository;

    public void saveProgress(ProgressOfWorkCivil progressOfWorkCivil) {
        progressOfWorkCivilRepository.save(progressOfWorkCivil);
    }

    public List<ProgressOfWorkCivil> getProgressOfWorkCivilByStaffno(String staffno) {
        return progressOfWorkCivilRepository.findByStaffno(staffno);
    }
}
