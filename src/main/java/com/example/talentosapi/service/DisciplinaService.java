package com.example.talentosapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.talentosapi.model.Disciplina;
import com.example.talentosapi.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	public Disciplina alterar(Long codigo, Disciplina disciplina){
		Disciplina disciplinaSalva = disciplinaRepository.findOne(codigo);
		if(disciplinaSalva == null){
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(disciplina, disciplinaSalva, "codigo");
		return disciplinaRepository.save(disciplinaSalva);
	}
	
}
