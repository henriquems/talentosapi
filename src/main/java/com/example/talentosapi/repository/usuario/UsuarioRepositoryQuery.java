package com.example.talentosapi.repository.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.talentosapi.model.Usuario;
import com.example.talentosapi.repository.filter.UsuarioFilter;

public interface UsuarioRepositoryQuery {
	
	public Page<Usuario> filtrar(UsuarioFilter filtro, Pageable pageable);
	
}
