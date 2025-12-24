package com.ProjetoJN.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoJN.curso.entities.Produto;


public interface RepositorioProduto extends JpaRepository<Produto, Long> {

}
