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
import com.example.talentosapi.model.Disciplina;
import com.example.talentosapi.repository.DisciplinaRepository;
import com.example.talentosapi.repository.filter.DisciplinaFilter;
import com.example.talentosapi.service.DisciplinaService;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaResource {
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_DISCIPLINA') and #oauth2.hasScope('read')")
	public Page<Disciplina> pesquisar(DisciplinaFilter filtro, Pageable pageable) {
		return disciplinaRepository.filtrar(filtro, pageable);
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_DISCIPLINA') and #oauth2.hasScope('write')")
	public ResponseEntity<Disciplina> cadastrar(@Valid @RequestBody Disciplina disciplina, HttpServletResponse response){
		Disciplina disciplinaSalva = disciplinaRepository.save(disciplina);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, disciplinaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaSalva);
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_DISCIPLINA') and #oauth2.hasScope('read')")
	public ResponseEntity<Disciplina> recuperar(@PathVariable Long codigo){
		Disciplina disciplina = disciplinaRepository.findOne(codigo);
		return disciplina != null ? ResponseEntity.ok(disciplina) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_EXCLUIR_DISCIPLINA') and #oauth2.hasScope('write')")
	public void excluir(@PathVariable Long codigo){
		disciplinaRepository.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_ALTERAR_DISCIPLINA') and #oauth2.hasScope('write')")
	public ResponseEntity<Disciplina> alterar(@PathVariable Long codigo, @Valid @RequestBody Disciplina disciplina){
		Disciplina disciplinaSalva = disciplinaService.alterar(codigo, disciplina);
		return ResponseEntity.ok(disciplinaSalva);
	}
}
