package com.ProjetoJN.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoJN.curso.entities.Pedido;
import com.ProjetoJN.curso.servicos.ServicoPedido;

@RestController
@RequestMapping(value = "/pedidos")
public class RecursoPedido {
	
	@Autowired
	private ServicoPedido servico;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> encontrarTudo() {
		
		List<Pedido> list = servico.encontrarTudo();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> encontrarPorId(@PathVariable Long id) {
		
		Pedido obj = servico.encontrarPorId(id);
		
		return ResponseEntity.ok().body(obj);
	}

}
