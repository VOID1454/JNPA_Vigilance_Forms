package com.example.forms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Form5A {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String officerName;
    private String foryear;
    private String fordepartment;
    private String forquarter;
    private String suspensionDate;
    private String reasonForSuspension;
    private String casesReviewed;
    private String currentStatus;
    private String remarks;
    private String staffno;
    private String createdBy;
    private String createdAt;
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

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getSuspensionDate() {
        return suspensionDate;
    }

    public void setSuspensionDate(String suspensionDate) {
        this.suspensionDate = suspensionDate;
    }

    public String getReasonForSuspension() {
        return reasonForSuspension;
    }

    public void setReasonForSuspension(String reasonForSuspension) {
        this.reasonForSuspension = reasonForSuspension;
    }

    public String getCasesReviewed() {
        return casesReviewed;
    }

    public void setCasesReviewed(String casesReviewed) {
        this.casesReviewed = casesReviewed;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
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

    public String getForquarter() {
        return forquarter;
    }

    public void setForquarter(String forquarter) {
        this.forquarter = forquarter;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
