package com.ProjetoJN.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoJN.curso.entities.Produto;
import com.ProjetoJN.curso.servicos.ServicoProduto;

@RestController
@RequestMapping(value = "/produtos")
public class RecursoProduto {
	
	@Autowired
	private ServicoProduto servico;
	
	@GetMapping
	public ResponseEntity<List<Produto>> encontrarTudo() {
		
		List<Produto> list = servico.encontrarTudo();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> encontrarPorId(@PathVariable Long id) {
		
		Produto obj = servico.encontrarPorId(id);
		
		return ResponseEntity.ok().body(obj);
	}

}
