package com.example.demo.Controller;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.PlanetDTO;
import com.example.demo.Service.PlanetService;

@Controller
@RestController
@RequestMapping(path = "api/v1/Planets")
public class PlanetController {

	//Inyección de dependencia
	private PlanetService PlanetService;

	public PlanetController(PlanetService PlanetService) {
		this.PlanetService = PlanetService;
	}
	
	//getOne
	//localhost:9000/api/v1/Planets/{id}
	@GetMapping("/{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity getOne(@PathVariable int id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(PlanetService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Verifique por favor el ID y vuelva a intentar.\"}");
		}
	}
	//getAll
	@GetMapping("/")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(PlanetService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Error. Vuelva a intentar luego.\"}");
		}
		
	}
	//post
	@PostMapping("/")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity post(@RequestBody PlanetDTO PlanetDTO) {
		try {
			PlanetDTO result = (PlanetDTO) PlanetService.save(PlanetDTO);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Verificar el BODY request y volver a intentar\"}");
		}
	}
	//put
	@PutMapping("{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity put(@RequestBody PlanetDTO PlanetDTO, @PathVariable int id) {
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(PlanetService.update(PlanetDTO, id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Verificar el ID y el BODY request y volver a intentar\"}");
		}
	}
	//delete
	@DeleteMapping("{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity delete(@PathVariable int id) {
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(PlanetService.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Verificar el ID y volver a intentar\"}");
		}
	}
}