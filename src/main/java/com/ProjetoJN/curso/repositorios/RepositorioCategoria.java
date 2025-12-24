package com.ProjetoJN.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoJN.curso.entities.Categoria;


public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {

}
