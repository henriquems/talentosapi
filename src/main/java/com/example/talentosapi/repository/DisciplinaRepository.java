package com.example.talentosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.talentosapi.model.Disciplina;
import com.example.talentosapi.repository.disciplina.DisciplinaRepositoryQuery;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>, DisciplinaRepositoryQuery {

}
