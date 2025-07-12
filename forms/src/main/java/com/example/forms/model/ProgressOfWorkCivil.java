package com.example.forms.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "form3")
public class ProgressOfWorkCivil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fordepartment;
    private String forquarter;
    private String foryear;
    private String descriptionOfWork;
    private String estimatedCost;
    private String tenderedCost;
    private String ratePercentage;
    private String agreementNo;
    private String agency;
    private Date commencementDate;
    private String completionTime;
    private String physicalProgress;
    private String contractvalue;
    private String engineerInCharge;
    private String remarks;

    // Add new fields for createdAt and createdBy
    private String department;
    private String staffno;
    private Date createdAt;
    private String createdBy;
    private boolean verified;
    private String verificationstatus = "Pending"; // Default value
    private String alertremark;

    // Getters and setters
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

    public String getDescriptionOfWork() {
        return descriptionOfWork;
    }

    public void setDescriptionOfWork(String descriptionOfWork) {
        this.descriptionOfWork = descriptionOfWork;
    }

    public String getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(String estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public String getTenderedCost() {
        return tenderedCost;
    }

    public void setTenderedCost(String tenderedCost) {
        this.tenderedCost = tenderedCost;
    }

    public String getRatePercentage() {
        return ratePercentage;
    }

    public void setRatePercentage(String ratePercentage) {
        this.ratePercentage = ratePercentage;
    }

    public String getAgreementNo() {
        return agreementNo;
    }

    public void setAgreementNo(String agreementNo) {
        this.agreementNo = agreementNo;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public Date getCommencementDate() {
        return commencementDate;
    }

    public void setCommencementDate(Date commencementDate) {
        this.commencementDate = commencementDate;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    public String getPhysicalProgress() {
        return physicalProgress;
    }

    public void setPhysicalProgress(String physicalProgress) {
        this.physicalProgress = physicalProgress;
    }




    public String getContractValue() {
        return contractvalue;
    }

    public void setContractValue(String contractvalue) {
        this.contractvalue = contractvalue;
    }

    public String getEngineerInCharge() {
        return engineerInCharge;
    }

    public void setEngineerInCharge(String engineerInCharge) {
        this.engineerInCharge = engineerInCharge;
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

    public String getForquarter() {
        return forquarter;
    }

    public void setForquarter(String forquarter) {
        this.forquarter = forquarter;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public String getForyear() {
        return foryear;
    }

    public void setForyear(String foryear) {
        this.foryear = foryear;
    }
}
