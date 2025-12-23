package com.ProjetoJN.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoJN.curso.entities.Pedido;


public interface RepositorioPedido extends JpaRepository<Pedido, Long> {

}
