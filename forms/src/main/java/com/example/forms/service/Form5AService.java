package com.example.forms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forms.model.Form5A;
import com.example.forms.repository.Form5ARepository;

@Service
public class Form5AService {

    @Autowired
    private Form5ARepository form5ARepository;

    public void saveForm5A(Form5A form5A) {
        form5ARepository.save(form5A);
    }

    public List<Form5A> getForm5AByStaffno(String staffno) {
        return form5ARepository.findByStaffno(staffno); // Use the autowired instance
    }
}
