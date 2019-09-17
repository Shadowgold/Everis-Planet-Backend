package com.example.demo.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "api_planet")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Planet extends EntityBean {
	
	//Attributes
	@Column(name = "planet_name")
	private String name;
	
	@Column(name = "planet_size")
	private int size;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "star_fk_planet")
	//@JsonBackReference
	//@JsonIgnore
	private Star star;

	
	
	//Constructors
	
	public Planet() {
	}

	
	public Planet(String name, int size) {
		this.name = name;
		this.size = size;
	}


	//Getters & Setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Star getStar() {
		return star;
	}

	public void setStar(Star star) {
		this.star = star;
	}
	
	

}
