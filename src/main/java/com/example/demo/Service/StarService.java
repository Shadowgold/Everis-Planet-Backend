package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.StarDTO;
import com.example.demo.Entity.Star;
import com.example.demo.Repository.StarRepository;

@Service
public class StarService {
	
	//Inyección de dependencia
	private StarRepository starRepository;

	public StarService(StarRepository starRepository) {
		this.starRepository = starRepository;
	}
	
	//findById
	@Transactional
	public StarDTO findById(int id) throws Exception {
		
		Optional<Star> starOptional = starRepository.findById(id);
		try {
			Star star = starOptional.get();
			ModelMapper modelMapper = new ModelMapper();
			return (StarDTO) modelMapper.map(star, StarDTO.class);
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
	
	//findAll
	@Transactional
	public List<StarDTO> findAll() throws Exception{
		
		List<StarDTO> listStarDTO = new ArrayList<StarDTO>();
		try {
			ModelMapper modelMapper = new ModelMapper();
			for (Star star : starRepository.findAll()) {
				StarDTO starDTO = modelMapper.map(star, StarDTO.class);
				listStarDTO.add(starDTO);
			}
		} catch (Exception e) {
			throw new Exception();
		}
		return listStarDTO;
	}
	//save
	@Transactional
	public StarDTO save(StarDTO starDTO) throws Exception{
		
		Star star;
		ModelMapper modelMapper = new ModelMapper();
		try {
			
			star = modelMapper.map(starDTO, Star.class);
			star = starRepository.save(star);
			
			return (StarDTO) modelMapper.map(star, StarDTO.class);
			
			
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
	//update
	@Transactional
	public StarDTO update(StarDTO starDTO, int id) {
		return null;
	}
	//delete
	@Transactional
	public boolean delete(int id) {
		return true;
	}
}
