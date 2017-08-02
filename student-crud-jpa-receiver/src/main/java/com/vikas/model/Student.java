package com.vikas.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="STUDENT")
public class Student implements Serializable{
	
	private static final long SerialVersionUID = 12345678L;		

@Id
@Column(name="Student_id")
private int id;

@Column(name = "Student_name")
private String name;

@Column(name="Student_percentage")
private float percentage;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public float getPercentage() {
	return percentage;
}

public void setPercentage(float percentage) {
	this.percentage = percentage;
}

public Student(int id, String name, float percentage) {
	super();
	this.id = id;
	this.name = name;
	this.percentage = percentage;
}

public Student() {
	// TODO Auto-generated constructor stub
}


@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", percentage=" + percentage + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Student other = (Student) obj;
	if (id != other.id)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}




	
}
