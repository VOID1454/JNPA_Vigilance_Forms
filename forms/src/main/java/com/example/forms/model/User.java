package com.example.forms.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = true) // Set nullable to false if the department is mandatory
	private String department;

	@Column(nullable = true)
	private String contactno;

	@Column(nullable = false, unique = true)
	private String staffno;

	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PasswordHistory> PasswordHistory;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Expenditure> expenditures = new ArrayList<>();

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "user_id")
	// private List<ProgressOfWork> progressofworks = new ArrayList<>();

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "user_id")
	// private List<ProgressOfWorkCivil> progressofworkcivils = new ArrayList<>();

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "user_id")
	// private List<ForeignVisit> foreignVisits = new ArrayList<>();

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "user_id")
	// private List<SuspensionReport> suspensionreports = new ArrayList<>();

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "user_id")
	// private List<PenaltyCase> penaltyCases = new ArrayList<>();

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "user_id")
	// private List<Form5A> form5as = new ArrayList<>();

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "user_id")
	// private List<Form5B> form5bs = new ArrayList<>();

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "user_id")
	// private List<Form5C> form5cs = new ArrayList<>();

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "user_id")
	// private List<Contract> contracts = new ArrayList<>();

	@Column(name = "otp")
	private String otp;

	@Column(name = "otp_expiration_time")
	private LocalDateTime otpExpirationTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getStaffno() {
		return staffno;
	}

	public void setStaffno(String staffno) {
		this.staffno = staffno;
	}

	// Getter for otp
	public String getOtp() {
		return otp;
	}

	// Setter for otp
	public void setOtp(String otp) {
		this.otp = otp;
	}

	// Getter for otpExpirationTime
	public LocalDateTime getOtpExpirationTime() {
		return otpExpirationTime;
	}

	// Setter for otpExpirationTime
	public void setOtpExpirationTime(LocalDateTime otpExpirationTime) {
		this.otpExpirationTime = otpExpirationTime;
	}

}
