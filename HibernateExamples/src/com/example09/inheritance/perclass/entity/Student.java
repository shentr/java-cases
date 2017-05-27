package com.example09.inheritance.perclass.entity;

import javax.persistence.Entity;

@Entity
public class Student extends Person {
	private int grade;

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}
