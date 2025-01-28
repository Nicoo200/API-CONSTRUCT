package com.example.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.dto.ConstructDto;
import com.example.entity.ConstructEntity;
import com.example.repository.ConstructRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ConstructService {
	
	//ADICIONADO O POST
	private final ConstructRepository repository;
	
	public ConstructService (ConstructRepository repository) {
		this.repository = repository;
	}

	public ConstructEntity creatConstruct(ConstructDto dto) {
		ConstructEntity newConstruct = new ConstructEntity(dto);
		return repository.save(newConstruct);
	}
	
    // ADICIONANDO O GET
    public ConstructEntity getConstructById(UUID id) {
        return repository.findById(id).orElseThrow();
    }
    
    public List<ConstructEntity> getAllConstruct(){
    	return repository.findAll();
    }
    
    
    // ADICIONANDO O PUT
    
    public void updateConstruct(UUID id,ConstructDto dto) {
    	ConstructEntity existingModel = repository.findById(id)
    	.orElseThrow(() -> new EntityNotFoundException("Doce com ID " + id + " não encontrado"));
    	
    	existingModel.setNome(dto.nome());
    	existingModel.setPreco(dto.preco());
    	existingModel.setDescricao(dto.descricao());
    	existingModel.setLocalizacao(dto.localizacao());
    	
    	repository.save(existingModel);
    }
    
    
    // ADICIONANDO O DELETE
    
    public void deleteById(String id) {
    	var constructid = UUID.fromString(id);
    	
    	var constructExists = repository.existsById(constructid);
    	
    	if(constructExists) {
    		repository.deleteById(constructid);
    	}
    }


	
}
