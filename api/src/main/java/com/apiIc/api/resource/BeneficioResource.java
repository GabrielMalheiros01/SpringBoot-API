package com.apiIc.api.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apiIc.api.entities.Beneficio;
import com.apiIc.api.services.BeneficioService;

@RestController
@RequestMapping(value = "/beneficios")
public class BeneficioResource {

	@Autowired
	private BeneficioService service;
	
	@GetMapping
	public ResponseEntity<List<Beneficio>> findAll() {

		List<Beneficio> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Beneficio> findById(@PathVariable Long id){
	Beneficio obj = service.findByiD(id);
	return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Beneficio> insert(@RequestBody Beneficio obj){
		obj = service.insert(obj);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_beneficio()).toUri();
		 return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Beneficio> update(@PathVariable Long id, @RequestBody Beneficio obj) {
		
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
