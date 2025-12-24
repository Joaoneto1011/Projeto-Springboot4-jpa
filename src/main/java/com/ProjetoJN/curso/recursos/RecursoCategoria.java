package com.ProjetoJN.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoJN.curso.entities.Categoria;
import com.ProjetoJN.curso.servicos.ServicoCategoria;

@RestController
@RequestMapping(value = "/categorias")
public class RecursoCategoria {
	
	@Autowired
	private ServicoCategoria servico;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> encontrarTudo() {
		
		List<Categoria> list = servico.encontrarTudo();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> encontrarPorId(@PathVariable Long id) {
		
		Categoria obj = servico.encontrarPorId(id);
		
		return ResponseEntity.ok().body(obj);
	}

}
