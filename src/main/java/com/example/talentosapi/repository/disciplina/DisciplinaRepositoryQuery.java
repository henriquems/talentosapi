package com.example.talentosapi.repository.disciplina;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.talentosapi.model.Disciplina;
import com.example.talentosapi.repository.filter.DisciplinaFilter;

public interface DisciplinaRepositoryQuery {
	
	public Page<Disciplina> filtrar(DisciplinaFilter filtro, Pageable pageable);
	
}
