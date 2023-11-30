package com.apiIc.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiIc.api.Repositories.BeneficioRepository;
import com.apiIc.api.entities.Beneficio;


@Service
public class BeneficioService {
	
	@Autowired
	private BeneficioRepository repository;
	
	public List<Beneficio> findAll(){
		return repository.findAll();
				
	}
	
	public Beneficio findByiD(Long id) {
		Optional<Beneficio> obj = repository.findById(id);
		return obj.get();
	}
	
	public Beneficio insert(Beneficio obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Beneficio update(Long id, Beneficio obj) {
		Beneficio entity = repository.getReferenceById(id);
		updateData(entity,obj);
		return repository.save(entity);
	}
	
	private void updateData(Beneficio entity, Beneficio obj) {
		
		entity.setDesc_beneficio(obj.getDesc_beneficio());
		
	}

}
