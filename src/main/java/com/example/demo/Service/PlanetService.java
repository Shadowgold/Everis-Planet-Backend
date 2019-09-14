package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.PlanetDTO;
import com.example.demo.Entity.Planet;
import com.example.demo.Repository.PlanetRepository;

@Service
public class PlanetService {

	//Inyección de dependencia
	private PlanetRepository planetRepository;

	public PlanetService(PlanetRepository planetRepository) {
		this.planetRepository = planetRepository;
	}
	
	
	//findById
	public PlanetDTO findById(int id) throws Exception{
		Optional<Planet> planetOptional = planetRepository.findById(id);
		ModelMapper modelMapper = new ModelMapper();
		try {
			Planet planet = planetOptional.get();
			return (PlanetDTO) modelMapper.map(planet, PlanetDTO.class);
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
	//findAll
	public List<PlanetDTO> findAll() throws Exception{
		List<PlanetDTO> listPlanetDTO =  new ArrayList<PlanetDTO>();
		ModelMapper modelMapper = new ModelMapper();
		try {
			for (Planet planet : planetRepository.findAll()) {
				PlanetDTO planetDTO = modelMapper.map(planet, PlanetDTO.class);
				listPlanetDTO.add(planetDTO);
				
			}
		} catch (Exception e) {
			throw new Exception();
		}
		return listPlanetDTO;
	}
	//save
	public PlanetDTO save(PlanetDTO planetDTO) throws Exception{
		ModelMapper modelMapper = new ModelMapper();
		try {
			Planet planet = modelMapper.map(planetDTO, Planet.class);
			planet = planetRepository.save(planet);
			return (PlanetDTO) modelMapper.map(planet, PlanetDTO.class);
			 
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
	//update
	public PlanetDTO update(PlanetDTO planetDTO, int id) throws Exception{
		Optional<Planet> planetOptional = planetRepository.findById(id);
		ModelMapper modelMapper = new ModelMapper();
		try {
			Planet planet = planetOptional.get();
			planet = modelMapper.map(planetDTO, Planet.class);
			planetRepository.save(planet);
			return (PlanetDTO) modelMapper.map(planet, PlanetDTO.class);
			
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
	//delete
	public boolean delete(int id) throws Exception{
		Optional<Planet> planetOptional = planetRepository.findById(id);
		try {
			planetRepository.delete(planetOptional.get());
			return true;
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
}
