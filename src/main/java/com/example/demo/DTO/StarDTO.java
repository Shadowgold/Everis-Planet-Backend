package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entity.Planet;

public class StarDTO {

	private int id;
	
	private String name;
	
	private int density;
	
	//private List<PlanetDTO> planets = new ArrayList();

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

	public int getDensity() {
		return density;
	}

	public void setDensity(int density) {
		this.density = density;
	}

	/*public List<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}*/

	
	
}
