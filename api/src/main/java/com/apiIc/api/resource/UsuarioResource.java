package com.apiIc.api.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apiIc.api.dto.LocalizacaoDTO;
import com.apiIc.api.entities.Usuario;
import com.apiIc.api.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {

		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	 @GetMapping(value = "/api/localizacoes")
	    public ResponseEntity<List<LocalizacaoDTO>> obterLocalizacoes() {
	        List<Usuario> usuarios = service.findAll();
	        List<LocalizacaoDTO> localizacoes = usuarios.stream()
	                .map(usuario -> new LocalizacaoDTO(usuario.getLatitude(), usuario.getLongitude()))
	                .collect(Collectors.toList());

	        return ResponseEntity.ok().body(localizacoes);
	    }

	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
	Usuario obj = service.findByiD(id);
	return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario obj){
		 obj = service.insert(obj);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_usuario()).toUri();
		 return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario obj) {
		
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
