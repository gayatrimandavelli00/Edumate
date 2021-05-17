package com.ts.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private int regdNo;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private int yearOfStudy;
	private String collegeName;
	private String about;
	private String studentImg;
	private String phone;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getStudentImg() {
		return studentImg;
	}

	public void setStudentImg(String studentImg) {
		this.studentImg = studentImg;
	}

	public int getRegdNo() {
		return regdNo;
	}

	public void setRegdNo(int regdNo) {
		this.regdNo = regdNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	@Override
	public String toString() {
		return "Student [regdNo=" + regdNo + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", password=" + password + ", yearOfStudy=" + yearOfStudy + ", collegeName=" + collegeName
				+ ", about=" + about + ", studentImg=" + studentImg + ", phone=" + phone + "]";
	}
}	