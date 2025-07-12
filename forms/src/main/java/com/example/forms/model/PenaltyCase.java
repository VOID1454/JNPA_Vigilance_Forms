package com.example.forms.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "form52")
public class PenaltyCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foryear;
    private String fordepartment;
    private String forquarter;
    private String majorPendingStart;
    private String minorPendingStart;
    private String majorInitiated;
    private String minorInitiated;
    private String majorFinalized;
    private String minorFinalized;
    private String majorPendingEnd;
    private String minorPendingEnd;
    private String staffno;
    private String createdBy;
    private LocalDateTime createdAt;
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

    public String getMajorPendingStart() {
        return majorPendingStart;
    }

    public void setMajorPendingStart(String majorPendingStart) {
        this.majorPendingStart = majorPendingStart;
    }

    public String getMinorPendingStart() {
        return minorPendingStart;
    }

    public void setMinorPendingStart(String minorPendingStart) {
        this.minorPendingStart = minorPendingStart;
    }

    public String getMajorInitiated() {
        return majorInitiated;
    }

    public void setMajorInitiated(String majorInitiated) {
        this.majorInitiated = majorInitiated;
    }

    public String getMinorInitiated() {
        return minorInitiated;
    }

    public void setMinorInitiated(String minorInitiated) {
        this.minorInitiated = minorInitiated;
    }

    public String getMajorFinalized() {
        return majorFinalized;
    }

    public void setMajorFinalized(String majorFinalized) {
        this.majorFinalized = majorFinalized;
    }

    public String getMinorFinalized() {
        return minorFinalized;
    }

    public void setMinorFinalized(String minorFinalized) {
        this.minorFinalized = minorFinalized;
    }

    public String getMajorPendingEnd() {
        return majorPendingEnd;
    }

    public void setMajorPendingEnd(String majorPendingEnd) {
        this.majorPendingEnd = majorPendingEnd;
    }

    public String getMinorPendingEnd() {
        return minorPendingEnd;
    }

    public void setMinorPendingEnd(String minorPendingEnd) {
        this.minorPendingEnd = minorPendingEnd;
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