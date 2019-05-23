package com.example.talentosapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.talentosapi.model.Status;
import com.example.talentosapi.model.Usuario;
import com.example.talentosapi.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario alterar(Long codigo, Usuario usuario){
		Usuario usuarioSalvo = recuperarUsuario(codigo);
		BeanUtils.copyProperties(usuario, usuarioSalvo, "codigo");
		return usuarioRepository.save(usuarioSalvo);
	}

	public void alterarStatus(Long codigo, Status status) {
		Usuario usuarioSalvo = recuperarUsuario(codigo);
		usuarioSalvo.setStatus(status);
		usuarioRepository.save(usuarioSalvo);
	}
	
	private Usuario recuperarUsuario(Long codigo) {
		Usuario usuarioSalvo = usuarioRepository.findOne(codigo);
		if(usuarioRepository == null){
			throw new EmptyResultDataAccessException(1);
		}
		return usuarioSalvo;
	}
}
