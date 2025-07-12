package com.example.forms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forms.model.Form5C;
import com.example.forms.repository.Form5CRepository;

@Service
public class Form5CService {

    @Autowired
    private Form5CRepository form5CRepository;

    public void saveform5C(Form5C form5C) {
        form5CRepository.save(form5C);
    }

    public List<Form5C> getForm5CByStaffno(String staffno) {
        return form5CRepository.findByStaffno(staffno); // Use the autowired instance
    }
}
