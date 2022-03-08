package com.example.sharks.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;

@Entity
public class Shark {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	@Max(300)
	private int age;
	
	@Column
	private int numOfTeeth;
	
	@Column(unique = false, nullable = false)
	private String name;
	
	public Shark() {}
	
	public Shark(@Max(300) int age, int numOfTeeth, String name) {
		this.age = age;
		this.numOfTeeth = numOfTeeth;
		this.name = name;
	}

	public Shark(long id, @Max(300) int age, int numOfTeeth, String name) {
		super();
		this.id = id;
		this.age = age;
		this.numOfTeeth = numOfTeeth;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumOfTeeth() {
		return numOfTeeth;
	}

	public void setNumOfTeeth(int numOfTeeth) {
		this.numOfTeeth = numOfTeeth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Shark [id=" + id + ", age=" + age + ", numOfTeeth=" + numOfTeeth + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, id, name, numOfTeeth);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shark other = (Shark) obj;
		return age == other.age && id == other.id && Objects.equals(name, other.name) && numOfTeeth == other.numOfTeeth;
	}
	
}
