package com.example.forms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forms.model.ProgressOfWork;
import com.example.forms.repository.ProgressOfWorkRepository;

@Service
public class ProgressOfWorkService {

    @Autowired
    private ProgressOfWorkRepository progressOfWorkRepository;

    public void saveProgress(ProgressOfWork progress) {
        progressOfWorkRepository.save(progress); // Save each record to the database
    }


     public List<ProgressOfWork> getProgressOfWorkByStaffno(String staffno) {
        return progressOfWorkRepository.findByStaffno(staffno);
    }
}
