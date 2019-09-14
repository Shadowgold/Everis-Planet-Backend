package com.example.demo.DTO;

import com.example.demo.Entity.Star;

public class PlanetDTO {
	
	private int id;
	
	private String name;
	
	private int size;
	
	private Star star;

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
