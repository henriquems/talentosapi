package com.example.talentosapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.talentosapi.model.Usuario;
import com.example.talentosapi.repository.usuario.UsuarioRepositoryQuery;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioRepositoryQuery {
	
	public Optional<Usuario> findByEmail(String email);
	
}
