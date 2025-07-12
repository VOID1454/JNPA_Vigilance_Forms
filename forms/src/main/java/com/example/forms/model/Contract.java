package com.example.forms.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "form6")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String todepartment;
    private String fordepartment;
    private String section;
    private String forthemonth;
    private String tenderNo;
    private String natureOfWork;
    private String tenderEnquiry;
    private String nitDate;
    private String biddingType;
    private String receiptDate;
    private String tenderReceived;
    private String qualifiedParties;
    private String notQualifiedParties;
    private String contractL1;
    private String contractNo;
    private String contractorName;
    private String contractValue;
    private String startDate;
    private String completionDate;
    private String actualCompletionDate;
    private String delayReason;
    private String remarks;
    private String staffno;
    private Date createdAt;
    private String createdBy;
    private boolean verified;
    private String verificationstatus = "Pending"; // Default value
    private String alertremark;

    // Default constructor
    public Contract() {
        // Default constructor required by Hibernate
    }

    // Updated constructor to include verificationstatus
    public Contract(String todepartment, String section, String forthemonth, String tenderNo, 
                   String natureOfWork, String tenderEnquiry, String nitDate, String biddingType, 
                   String receiptDate, String tenderReceived, String qualifiedParties,
                   String notQualifiedParties, String contractL1, String contractNo, 
                   String contractorName, String contractValue, String startDate, 
                   String completionDate, String actualCompletionDate, String delayReason, 
                   String remarks, Date createdAt, String staffno, String createdBy, 
                   String fordepartment, String alertremark) {
        this.fordepartment = fordepartment;
        this.section = section;
        this.forthemonth = forthemonth;
        this.todepartment = todepartment;
        this.tenderNo = tenderNo;
        this.natureOfWork = natureOfWork;
        this.tenderEnquiry = tenderEnquiry;
        this.nitDate = nitDate;
        this.biddingType = biddingType;
        this.receiptDate = receiptDate;
        this.tenderReceived = tenderReceived;
        this.qualifiedParties = qualifiedParties;
        this.notQualifiedParties = notQualifiedParties;
        this.contractL1 = contractL1;
        this.contractNo = contractNo;
        this.contractorName = contractorName;
        this.contractValue = contractValue;
        this.startDate = startDate;
        this.completionDate = completionDate;
        this.actualCompletionDate = actualCompletionDate;
        this.delayReason = delayReason;
        this.remarks = remarks;
        this.createdAt = createdAt;
        this.staffno = staffno;
        this.createdBy = createdBy;
        this.verificationstatus = "Pending"; // Initialize in constructor
        this.alertremark = alertremark;
    }

    // Getters and Setters for all fields including createdAt and createdBy

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

    public String getTenderNo() {
        return tenderNo;
    }

    public void setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
    }

    public String getNatureOfWork() {
        return natureOfWork;
    }

    public void setNatureOfWork(String natureOfWork) {
        this.natureOfWork = natureOfWork;
    }

    public String getTenderEnquiry() {
        return tenderEnquiry;
    }

    public void setTenderEnquiry(String tenderEnquiry) {
        this.tenderEnquiry = tenderEnquiry;
    }

    public String getNitDate() {
        return nitDate;
    }

    public void setNitDate(String nitDate) {
        this.nitDate = nitDate;
    }

    public String getBiddingType() {
        return biddingType;
    }

    public void setBiddingType(String biddingType) {
        this.biddingType = biddingType;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getTenderReceived() {
        return tenderReceived;
    }

    public void setTenderReceived(String tenderReceived) {
        this.tenderReceived = tenderReceived;
    }

    public String getQualifiedParties() {
        return qualifiedParties;
    }

    public void setQualifiedParties(String qualifiedParties) {
        this.qualifiedParties = qualifiedParties;
    }

    public String getNotQualifiedParties() {
        return notQualifiedParties;
    }

    public void setNotQualifiedParties(String notQualifiedParties) {
        this.notQualifiedParties = notQualifiedParties;
    }

    public String getContractL1() {
        return contractL1;
    }

    public void setContractL1(String contractL1) {
        this.contractL1 = contractL1;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public String getContractValue() {
        return contractValue;
    }

    public void setContractValue(String contractValue) {
        this.contractValue = contractValue;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getActualCompletionDate() {
        return actualCompletionDate;
    }

    public void setActualCompletionDate(String actualCompletionDate) {
        this.actualCompletionDate = actualCompletionDate;
    }

    public String getDelayReason() {
        return delayReason;
    }

    public void setDelayReason(String delayReason) {
        this.delayReason = delayReason;
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

    

    public String getSection() {
        return section;
    }

    public void setSection(String Section) {
        this.section = Section;
    }

    public String getForthemonth() {
        return forthemonth;
    }

    public void setForthemonth(String forthemonth) {
        this.forthemonth = forthemonth;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getFordepartment() {
        return fordepartment;
    }

    public void setFordepartment(String fordepartment) {
        this.fordepartment = fordepartment;
    }

    public String getTodepartment() {
        return todepartment;
    }

    public void setTodepartment(String todepartment) {
        this.todepartment = todepartment;
    }
}
