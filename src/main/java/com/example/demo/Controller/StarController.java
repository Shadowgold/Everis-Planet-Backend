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

import com.example.demo.DTO.StarDTO;
import com.example.demo.Service.StarService;

@Controller
@RestController
@RequestMapping(path = "api/v1/stars")
public class StarController {

	//Inyección de dependencia
	private StarService starService;

	public StarController(StarService starService) {
		this.starService = starService;
	}
	
	//getOne
	//localhost:9000/api/v1/stars/{id}
	@GetMapping("/{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity getOne(@PathVariable int id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(starService.findById(id));
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
			return ResponseEntity.status(HttpStatus.OK).body(starService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Error. Vuelva a intentar luego.\"}");
		}
		
	}
	//post
	@PostMapping("/")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity post(@RequestBody StarDTO starDTO) {
		try {
			StarDTO result = (StarDTO) starService.save(starDTO);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Verificar el BODY request y volver a intentar\"}");
		}
	}
	//put
	@PutMapping("{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity put(@RequestBody StarDTO starDTO, @PathVariable int id) {
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(starService.update(starDTO, id));
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
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(starService.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Verificar el ID y volver a intentar\"}");
		}
	}
}
