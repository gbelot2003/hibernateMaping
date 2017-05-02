package com.gbelot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "student_details")
public class StudentDetails {
	
	@Id
	@Column (name="student_id")
	private int id;
	
	@Column (name="student_name")
	private String studentName;
	
	@Column (name="student_subject")
	private String studentSubject;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSubject() {
		return studentSubject;
	}

	public void setStudentSubject(String studentSubject) {
		this.studentSubject = studentSubject;
	}


}
