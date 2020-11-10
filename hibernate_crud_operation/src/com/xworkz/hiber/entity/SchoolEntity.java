package com.xworkz.hiber.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="school")
@NamedQueries({
	@NamedQuery(name="fetchAll", query="select school from SchoolEntity school"),
	@NamedQuery(name="fetchByFees", query="select school from SchoolEntity school where school.fees=:fe"),
	@NamedQuery(name="fecthNameById", query="select school.name from SchoolEntity school where school.id=:i")
})
public class SchoolEntity implements Serializable{
	@Id
	@GenericGenerator(name="auto", strategy="increment")
	@GeneratedValue(generator="auto")
	@Column(name="S_ID")
	private int id;
	@Column(name="S_NAME")
	private String name;
	@Column(name="S_LOCATION")
	private String location;
	@Column(name="S_TEACHERS")
	private int noOfTeachears;
	@Column(name="S_FEES")
	private double fees;
	
	public SchoolEntity() {
		System.out.println("created:" +this.getClass().getSimpleName());
	}
	
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getNoOfTeachears() {
		return noOfTeachears;
	}
	public void setNoOfTeachears(int noOfTeachears) {
		this.noOfTeachears = noOfTeachears;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "SchoolEntity [id=" + id + ", name=" + name + ", location=" + location + ", noOfTeachears="
				+ noOfTeachears + ", fees=" + fees + "]";
	}
	public SchoolEntity(String name, String location, int noOfTeachears, double fees) {
		super();
		this.name = name;
		this.location = location;
		this.noOfTeachears = noOfTeachears;
		this.fees = fees;
	}
	
	

}
