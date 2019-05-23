package com.example.talentosapi.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.talentosapi.event.RecursoCriadoEvent;
import com.example.talentosapi.model.Status;
import com.example.talentosapi.model.Usuario;
import com.example.talentosapi.repository.UsuarioRepository;
import com.example.talentosapi.repository.filter.UsuarioFilter;
import com.example.talentosapi.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_USUARIO') and #oauth2.hasScope('read')")
	public Page<Usuario> pesquisar(UsuarioFilter filtro, Pageable pageable){
		return usuarioRepository.filtrar(filtro, pageable);
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_USUARIO') and #oauth2.hasScope('write')")
	public ResponseEntity<Usuario> cadastrar(@Valid @RequestBody Usuario usuario, HttpServletResponse response){
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_USUARIO') and #oauth2.hasScope('read')")
	public ResponseEntity<Usuario> recuperar(@PathVariable Long codigo){
		Usuario usuario = usuarioRepository.findOne(codigo);
		return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_EXCLUIR_USUARIO') and #oauth2.hasScope('write')")
	public void excluir(@PathVariable Long codigo){
		usuarioRepository.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_ALTERAR_USUARIO') and #oauth2.hasScope('write')")
	public ResponseEntity<Usuario> alterar(@PathVariable Long codigo, @Valid @RequestBody Usuario usuario){
		Usuario usuarioSalvo = usuarioService.alterar(codigo, usuario);
		return ResponseEntity.ok(usuarioSalvo);
	}
	
	@PutMapping("/{codigo}/status")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterarStatus(@PathVariable Long codigo, @RequestBody Status status){
		usuarioService.alterarStatus(codigo, status);
	}
}
