package com.ProjetoJN.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoJN.curso.entities.ItemDoPedido;
import com.ProjetoJN.curso.entities.pk.ItemDoPedidoPK;


public interface RepositorioItemDoPedido extends JpaRepository<ItemDoPedido, ItemDoPedidoPK> {

}
