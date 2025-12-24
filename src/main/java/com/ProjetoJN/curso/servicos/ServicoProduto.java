package com.ProjetoJN.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoJN.curso.entities.Produto;
import com.ProjetoJN.curso.repositorios.RepositorioProduto;

@Service
public class ServicoProduto {
	
	@Autowired
	private RepositorioProduto repositorio;
	
	public List<Produto> encontrarTudo() {
		
		return repositorio.findAll();
	}
	
	public Produto encontrarPorId(Long id) {
		
		Optional<Produto> obj = repositorio.findById(id);
		
		return obj.get();
	}

}
