package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "api_star")
public class Star extends EntityBean{
	
	//Attributes
	@Column(name = "star_name")
	private String name;
	
	@Column(name = "star_density")
	private int density;
	
	@OneToMany(mappedBy = "star")
	private List<Planet> planets = new ArrayList();

	
	
	//Constructors
	
	public Star() {
	}
	
	

	public Star(String name, int density) {
		this.name = name;
		this.density = density;
	}



	//Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDensity() {
		return density;
	}

	public void setDensity(int density) {
		this.density = density;
	}

	public List<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}
	
	

}
