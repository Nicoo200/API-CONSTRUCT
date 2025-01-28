package com.example.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ConstructDto;
import com.example.entity.ConstructEntity;
import com.example.repository.ConstructRepository;
import com.example.service.ConstructService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ConstructController {
	
	private final ConstructService service;
	private final ConstructRepository repository;
	
	
	public ConstructController (ConstructService service, ConstructRepository repository) {
		this.service = service;
		this.repository = repository;
	}
	
	@PostMapping("/new")
		public ResponseEntity<ConstructEntity> creatConstruct (@Valid @RequestBody ConstructDto dto){
			ConstructEntity newConstruct = service.creatConstruct(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(newConstruct);
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<ConstructEntity> getConstructById(@PathVariable UUID id){
		ConstructEntity entity =service.getConstructById(id);
		return ResponseEntity.ok(entity);
	}
	
    @GetMapping("/list")
    public ResponseEntity<List<ConstructEntity>> getAllConstruct() {
        List<ConstructEntity> allDoces = service.getAllConstruct();
        return ResponseEntity.ok(allDoces);
    }
    
    @PutMapping("/edit{id}")
    public ResponseEntity<Void> updateConstruct(@PathVariable UUID id, @RequestBody ConstructDto dto) {
        service.updateConstruct(id, dto);
        return ResponseEntity.noContent().build();
    }
    

    @DeleteMapping("/dell{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id){
        service.deleteById(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }

}
