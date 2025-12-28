package com.ProjetoJN.curso.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ProjetoJN.curso.entities.Usuario;
import com.ProjetoJN.curso.servicos.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {
	
	@Autowired
	private ServicoUsuario servico;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> encontrarTudo() {
		
		List<Usuario> list = servico.encontrarTudo();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> encontrarPorId(@PathVariable Long id) {
		
		Usuario obj = servico.encontrarPorId(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario obj) {
		
		obj = servico.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}
