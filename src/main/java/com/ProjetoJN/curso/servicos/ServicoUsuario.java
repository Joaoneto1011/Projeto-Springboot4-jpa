package com.ProjetoJN.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ProjetoJN.curso.entities.Usuario;
import com.ProjetoJN.curso.repositorios.RepositorioUsuario;
import com.ProjetoJN.curso.servicos.exception.ExcecaoDeBancoDeDados;
import com.ProjetoJN.curso.servicos.exception.RecursoNaoEncontradoException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ServicoUsuario {

	@Autowired
	private RepositorioUsuario repositorio;

	public List<Usuario> encontrarTudo() {

		return repositorio.findAll();
	}

	public Usuario encontrarPorId(Long id) {

		Optional<Usuario> obj = repositorio.findById(id);

		return obj.orElseThrow(() -> new RecursoNaoEncontradoException(id));
	}

	public Usuario inserir(Usuario obj) {

		return repositorio.save(obj);
	}

	public void deletar(Long id) {
		
		if(!repositorio.existsById(id)) {
			throw new RecursoNaoEncontradoException(id);
		}
		
		try {
			repositorio.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new ExcecaoDeBancoDeDados(e.getMessage());
		}

	}

	public Usuario atualizar(Long id, Usuario obj) {

		try {
		Usuario entidade = repositorio.getReferenceById(id);
		atualizarDados(entidade, obj);
		return repositorio.save(entidade);
		} catch (EntityNotFoundException e) {
			throw new RecursoNaoEncontradoException(id);
		}
	}

	private void atualizarDados(Usuario entidade, Usuario obj) {

		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());

	}

}
