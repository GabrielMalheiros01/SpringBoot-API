package com.apiIc.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiIc.api.Repositories.DeficienciaRepository;
import com.apiIc.api.entities.Deficiencia;

@Service
public class DeficienciaService {
	
	@Autowired
	private DeficienciaRepository repository;
	
	public List<Deficiencia> findAll(){
		return repository.findAll();
				
	}
	
	public Deficiencia findByiD(Long id) {
		Optional<Deficiencia> obj = repository.findById(id);
		return obj.get();
	}
	
	public Deficiencia insert(Deficiencia obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Deficiencia update(Long id, Deficiencia obj) {
		Deficiencia entity = repository.getReferenceById(id);
		updateData(entity,obj);
		return repository.save(entity);
	}
	
	private void updateData(Deficiencia entity, Deficiencia obj) {
		
		entity.setDesc_deficiencia(obj.getDesc_deficiencia());
		
	}
}
