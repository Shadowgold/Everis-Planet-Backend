package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.PlanetDTO;
import com.example.demo.Repository.PlanetRepository;

@Service
public class PlanetService {

	//Inyección de dependencia
	private PlanetRepository planetRepository;

	public PlanetService(PlanetRepository planetRepository) {
		this.planetRepository = planetRepository;
	}
	
	
	//findById
	public PlanetDTO findById(int id) {
		return null;
	}
	//findAll
	public List<PlanetDTO> findAll(){
		return null;
	}
	//save
	public PlanetDTO save(PlanetDTO planetDTO) {
		return null;
	}
	//update
	public PlanetDTO update(PlanetDTO planetDTO, int id) {
		return null;
	}
	//delete
	public boolean delete(int id) {
		return true;
	}
}
