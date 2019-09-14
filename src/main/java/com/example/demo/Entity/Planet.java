package com.example.demo.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "api_planet")
public class Planet extends EntityBean {
	
	//Attributes
	@Column(name = "planet_name")
	private String name;
	
	@Column(name = "planet_size")
	private int size;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "star_fk_planet")
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
