package com.example.forms.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "form51")
public class SuspensionReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foryear;
    private String fordepartment;
    private String forquarter;
    private Integer personsUnderSuspensionStart;
    private Integer personsSuspended;
    private Integer suspensionRevoked;
    private Integer personsSuspended1to3Months;
    private Integer personsSuspended3to6Months;
    private Integer personsSuspendedOver6Months;
    private Integer totalPersonsUnderSuspensionEnd;
    private String staffno;
    private String createdBy;
    private LocalDateTime createdAt;
    private boolean verified;
    private String verificationstatus = "Pending"; // Default value
    private String alertremark;

    // Getter and Setter methods
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

    public Integer getPersonsUnderSuspensionStart() {
        return personsUnderSuspensionStart;
    }

    public void setPersonsUnderSuspensionStart(Integer personsUnderSuspensionStart) {
        this.personsUnderSuspensionStart = personsUnderSuspensionStart;
    }

    public Integer getPersonsSuspended() {
        return personsSuspended;
    }

    public void setPersonsSuspended(Integer personsSuspended) {
        this.personsSuspended = personsSuspended;
    }

    public Integer getSuspensionRevoked() {
        return suspensionRevoked;
    }

    public void setSuspensionRevoked(Integer suspensionRevoked) {
        this.suspensionRevoked = suspensionRevoked;
    }

    public Integer getPersonsSuspended1to3Months() {
        return personsSuspended1to3Months;
    }

    public void setPersonsSuspended1to3Months(Integer personsSuspended1to3Months) {
        this.personsSuspended1to3Months = personsSuspended1to3Months;
    }

    public Integer getPersonsSuspended3to6Months() {
        return personsSuspended3to6Months;
    }

    public void setPersonsSuspended3to6Months(Integer personsSuspended3to6Months) {
        this.personsSuspended3to6Months = personsSuspended3to6Months;
    }

    public Integer getPersonsSuspendedOver6Months() {
        return personsSuspendedOver6Months;
    }

    public void setPersonsSuspendedOver6Months(Integer personsSuspendedOver6Months) {
        this.personsSuspendedOver6Months = personsSuspendedOver6Months;
    }

    public Integer getTotalPersonsUnderSuspensionEnd() {
        return totalPersonsUnderSuspensionEnd;
    }

    public void setTotalPersonsUnderSuspensionEnd(Integer totalPersonsUnderSuspensionEnd) {
        this.totalPersonsUnderSuspensionEnd = totalPersonsUnderSuspensionEnd;
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

    // Method implementation for setting personsSuspended1to3Months
    public void setSuspension1to3Month(Integer personsSuspended1to3Months) {
        this.personsSuspended1to3Months = personsSuspended1to3Months;
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
