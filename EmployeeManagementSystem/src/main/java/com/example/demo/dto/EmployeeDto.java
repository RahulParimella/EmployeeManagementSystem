package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Employee_Id")
	private int id;
	
	@NotEmpty(message = "First name is required")
	@Size(min = 2, message = "first name should have at least 2 characters")
	@Column(name="First_Name")
	private String first_Name;
	
	@NotEmpty(message = "Last name is required")
	@Size(min = 2, message = "last name should have at least 2 characters")
	@Column(name="Last_Name")
	private String last_Name;
	
	@NotEmpty(message = "Email is required")
	@Email
	@Column(name="Email_Id")
	private String emailId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_Name=" + first_Name + ", last_Name=" + last_Name + ", emailId=" + emailId
				+ "]";
	}
}