package com.ProjetoJN.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoJN.curso.entities.Categoria;
import com.ProjetoJN.curso.repositorios.RepositorioCategoria;

@Service
public class ServicoCategoria {
	
	@Autowired
	private RepositorioCategoria repositorio;
	
	public List<Categoria> encontrarTudo() {
		
		return repositorio.findAll();
	}
	
	public Categoria encontrarPorId(Long id) {
		
		Optional<Categoria> obj = repositorio.findById(id);
		
		return obj.get();
	}

}
