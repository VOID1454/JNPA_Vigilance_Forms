package com.example.forms.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "form1")
public class Expenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foryear;
    private String fordepartment;
    private String forquarter;
    private String officialName;
    private LocalDate dateofgiftgiven;
    private String expenditure;
    private String staffno;
    private String createdBy;
    private LocalDateTime createdAt;
    private boolean verified;
      private String verificationstatus = "Pending"; // Default value
    private String alertremark;

    

    

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    public String getAlertremark() {
        return alertremark;
    }
    // Setter for alertremark
    public void setAlertremark(String alertremark) {
        this.alertremark = alertremark;
    }

    public String getVerificationstatus() {
        return verificationstatus;
    }
    
    public void setVerificationstatus(String verificationstatus) {
        this.verificationstatus = verificationstatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public String getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(String expenditure) {
        this.expenditure = expenditure;
    }

    public String getStaffno() {
        return staffno;
    }

    public void setStaffno(String staffno) {
        this.staffno = staffno;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getForyear() {
        return foryear;
    }

    public void setForyear(String foryear) {
        this.foryear = foryear;
    }

    public String getForquarter() {
        return forquarter;
    }

    public void setForquarter(String forquarter) {
        this.forquarter = forquarter;
    }

    public String getFordepartment() {
        return fordepartment;
    }

    public void setFordepartment(String fordepartment) {
        this.fordepartment = fordepartment;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDateofgiftgiven() {
        return dateofgiftgiven;
    }

    public void setDateofgiftgiven(LocalDate dateofgiftgiven) {
        this.dateofgiftgiven = dateofgiftgiven;
    }

}
