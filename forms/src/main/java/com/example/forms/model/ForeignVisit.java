package com.example.forms.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "form4")
public class ForeignVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foryear;
    private String fordepartment;
    // private String forquarter;
    private String nameDesignation;
    private String estaffno;
    private String countryVisited;
    private String durationOfStay;
    private String sourceOfFunding;
    private String remarks;
 
    private Date createdAt;
    private String staffno;
    private String createdBy;
    private boolean verified;
    private String verificationstatus = "Pending"; // Default value
    private String alertremark;

    // Getters and Setters
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

    public String getNameDesignation() {
        return nameDesignation;
    }

    public void setNameDesignation(String nameDesignation) {
        this.nameDesignation = nameDesignation;
    }

    public String getCountryVisited() {
        return countryVisited;
    }

    public void setCountryVisited(String countryVisited) {
        this.countryVisited = countryVisited;
    }

    public String getDurationOfStay() {
        return durationOfStay;
    }

    public void setDurationOfStay(String durationOfStay) {
        this.durationOfStay = durationOfStay;
    }

    public String getSourceOfFunding() {
        return sourceOfFunding;
    }

    public void setSourceOfFunding(String sourceOfFunding) {
        this.sourceOfFunding = sourceOfFunding;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    public String getEstaffno() {
        return estaffno;
    }

    public void setEstaffno(String estaffno) {
        this.estaffno = estaffno;
    }

    public String getForyear() {
        return foryear;
    }

    public void setForyear(String foryear) {
        this.foryear = foryear;
    }

    public String getFordepartment() {
        return fordepartment;
    }

    public void setFordepartment(String fordepartment) {
        this.fordepartment = fordepartment;
    }

    // public String getForquarter() {
    //     return forquarter;
    // }

    // public void setForquarter(String forquarter) {
    //     this.forquarter = forquarter;
    // }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
