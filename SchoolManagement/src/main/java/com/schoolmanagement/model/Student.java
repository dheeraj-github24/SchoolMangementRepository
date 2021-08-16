package com.schoolmanagement.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentID;
	
	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name = "LastName")
	private String lastName;
	
	@Column(name = "EmailID")
	private String email;
	
	@Column(name = "Gender")
	private char gender;
	
	
	public Student() {
		super();
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Course> course = new HashSet<>();
	
	public Set<Course> getCourse() {
		return course;
	}


	public void setCourse(Set<Course> course) {
		this.course = course;
	}


	public Student(long studentID, String firstName, String lastName, String email, char gender) {
		super();
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
	}


	public long getStudentID() {
		return studentID;
	}
	public void setStudentID(long studentID) {
		this.studentID = studentID;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
}
