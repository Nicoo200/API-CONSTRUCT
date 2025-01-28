package com.example.entity;


import java.util.UUID;

import com.example.dto.ConstructDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contatos")
public class ConstructEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String nome;
	private String preco;
	private String descricao;
	private String localizacao;

	
	public ConstructEntity() {
	}
	
	public ConstructEntity(ConstructDto dto) {
		this.nome = dto.nome();
		this.preco = dto.preco();
		this.descricao = dto.descricao();
		this.localizacao = dto.localizacao();
	}
	
	public ConstructEntity(UUID id, String nome, String preco, String descricao, String localizacao) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.localizacao = localizacao;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
}
