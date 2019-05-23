package com.example.talentosapi.model;

public enum Status {	
	
	ATIVO("ATIVO", "#0101DF"),
	INATIVO("INATIVO", "#B40404");
	
	private String descricao;
	private String cor;
	
	Status(String descricao, String cor){
		this.descricao = descricao;
		this.cor = cor;
	}
	
	public String getDescricao(){
		return descricao;
	}
	
	public String getCor(){
		return cor;
	}
	
}
