package com.apiIc.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiIc.api.Repositories.ProfissaoRepository;
import com.apiIc.api.entities.Profissao;


@Service
public class ProfissaoService {
	
	@Autowired
	private ProfissaoRepository repository;
	
	public List<Profissao> findAll(){
		return repository.findAll();
				
	}
	
	public Profissao findByiD(Long id) {
		Optional<Profissao> obj = repository.findById(id);
		return obj.get();
	}
	
	public Profissao insert(Profissao obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Profissao update(Long id, Profissao obj) {
		Profissao entity = repository.getReferenceById(id);
		updateData(entity,obj);
		return repository.save(entity);
	}
	
	private void updateData(Profissao entity, Profissao obj) {
		
		entity.setDesc_profissao(obj.getDesc_profissao());
		
	}

}
