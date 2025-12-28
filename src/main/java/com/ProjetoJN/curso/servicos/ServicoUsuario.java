package com.ProjetoJN.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoJN.curso.entities.Usuario;
import com.ProjetoJN.curso.repositorios.RepositorioUsuario;

@Service
public class ServicoUsuario {
	
	@Autowired
	private RepositorioUsuario repositorio;
	
	public List<Usuario> encontrarTudo() {
		
		return repositorio.findAll();
	}
	
	public Usuario encontrarPorId(Long id) {
		
		Optional<Usuario> obj = repositorio.findById(id);
		
		return obj.get();
	}
	
	public Usuario inserir(Usuario obj) {
		
		return repositorio.save(obj);
	}

}
