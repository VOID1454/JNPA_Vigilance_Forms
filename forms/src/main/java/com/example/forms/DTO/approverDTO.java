package com.example.forms.DTO;

import java.util.List;

import com.example.forms.model.Contract;
import com.example.forms.model.ForeignVisit;
import com.example.forms.model.Expenditure;
import com.example.forms.model.Form5A;
import com.example.forms.model.Form5B;
import com.example.forms.model.Form5C;
import com.example.forms.model.PenaltyCase;
import com.example.forms.model.ProgressOfWork;
import com.example.forms.model.ProgressOfWorkCivil;
import com.example.forms.model.SuspensionReport;
import com.example.forms.model.User;

public class approverDTO {
private String staffno;
private String fordepartment;
    private User user;
    private List<SuspensionReport> suspensionReport;
    private List<ProgressOfWorkCivil> progressOfWorkCivils;
    private List<ProgressOfWork> progressOfWorks;
    private List<PenaltyCase> penaltyCase;
    private List<Form5C> form5Cs;
    private List<Form5B> form5Bs;
    private List<Form5A> form5As;
    private List<ForeignVisit> foreignVisits;
    private List<Expenditure> expenditures;
    private List<Contract> contracts;

    // Getters and Setters
    public String getStaffno() {
        return staffno;
    }

    public void setStaffno(String staffno) {
        this.staffno = staffno;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<SuspensionReport> getSuspensionReport() {
        return suspensionReport;
    }

    public void setSuspensionReport(List<SuspensionReport> suspensionReport) {
        this.suspensionReport = suspensionReport;
    }

    public List<ProgressOfWorkCivil> getProgressOfWorkCivils() {
        return progressOfWorkCivils;
    }

    public void setProgressOfWorkCivils(List<ProgressOfWorkCivil> progressOfWorkCivils) {
        this.progressOfWorkCivils = progressOfWorkCivils;
    }

    public List<ProgressOfWork> getProgressOfWorks() {
        return progressOfWorks;
    }

    public void setProgressOfWorks(List<ProgressOfWork> progressOfWorks) {
        this.progressOfWorks = progressOfWorks;
    }

    public List<PenaltyCase> getPenaltyCase() {
        return penaltyCase;
    }

    public void setPenaltyCase(List<PenaltyCase> penaltyCase) {
        this.penaltyCase = penaltyCase;
    }

    public List<Form5C> getForm5Cs() {
        return form5Cs;
    }

    public void setForm5Cs(List<Form5C> form5Cs) {
        this.form5Cs = form5Cs;
    }

    public List<Form5B> getForm5Bs() {
        return form5Bs;
    }

    public void setForm5Bs(List<Form5B> form5Bs) {
        this.form5Bs = form5Bs;
    }

    public List<Form5A> getForm5As() {
        return form5As;
    }

    public void setForm5As(List<Form5A> form5As) {
        this.form5As = form5As;
    }

    public List<ForeignVisit> getForeignVisits() {
        return foreignVisits;
    }

    public void setForeignVisits(List<ForeignVisit> foreignVisits) {
        this.foreignVisits = foreignVisits;
    }

    public List<Expenditure> getExpenditures() {
        return expenditures;
    }

    public void setExpenditures(List<Expenditure> expenditures) {
        this.expenditures = expenditures;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

  

    public String getFordepartment() {
        return fordepartment;
    }

    public void setFordepartment(String fordepartment) {
        this.fordepartment = fordepartment;
    }
}

