package com.ProjetoJN.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoJN.curso.entities.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

}
