package com.example.forms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forms.model.Form5B;
import com.example.forms.repository.Form5BRepository;

@Service
public class Form5BService {

    @Autowired
    private Form5BRepository form5BRepository;

    public void saveForm5B(Form5B form5B) {
        form5BRepository.save(form5B);
    }


    public List<Form5B> getForm5BByStaffno(String staffno) {
        return form5BRepository.findByStaffno(staffno); // Use the autowired instance
    }
}
