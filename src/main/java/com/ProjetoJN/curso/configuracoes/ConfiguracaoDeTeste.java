package com.ProjetoJN.curso.configuracoes;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ProjetoJN.curso.entities.Categoria;
import com.ProjetoJN.curso.entities.ItemDoPedido;
import com.ProjetoJN.curso.entities.Pedido;
import com.ProjetoJN.curso.entities.Produto;
import com.ProjetoJN.curso.entities.Usuario;
import com.ProjetoJN.curso.entities.enums.StatusPedido;
import com.ProjetoJN.curso.repositorios.RepositorioCategoria;
import com.ProjetoJN.curso.repositorios.RepositorioItemDoPedido;
import com.ProjetoJN.curso.repositorios.RepositorioPedido;
import com.ProjetoJN.curso.repositorios.RepositorioProduto;
import com.ProjetoJN.curso.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class ConfiguracaoDeTeste implements CommandLineRunner {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private RepositorioPedido repositorioPedido;
	
	@Autowired
	private RepositorioCategoria repositorioCategoria;

	@Autowired
	private RepositorioProduto repositorioProduto;
	
	@Autowired
	private RepositorioItemDoPedido repositorioItemDoPedido;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria c1 = new Categoria(null, "Eletronicos");
		Categoria c2 = new Categoria(null, "Livros");
		Categoria c3 = new Categoria(null, "Computadores");
		
		Produto P1 = new Produto(null, "O senhor dos anéis", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto P2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto P3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto P4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto P5 = new Produto(null, "Trilhos para Leigos", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 

		repositorioCategoria.saveAll(Arrays.asList(c1, c2, c3));
		repositorioProduto.saveAll(Arrays.asList(P1, P2, P3, P4, P5));
		
		P1.getCategorias().add(c2);
		P2.getCategorias().add(c1);
		P2.getCategorias().add(c3);
		P3.getCategorias().add(c3);
		P4.getCategorias().add(c3);
		P5.getCategorias().add(c2);
		
		repositorioProduto.saveAll(Arrays.asList(P1, P2, P3, P4, P5));
		
		Usuario u1 = new Usuario(null, "Joao Neto", "joaoneto@gmail.com", "999999999", "123456");
		Usuario u2 = new Usuario(null, "Joao Victor", "joaovictor@gmail.com", "888888888", "654321");
		
		Pedido p1 = new Pedido(null, Instant.parse("2025-12-22T15:40:30Z"), StatusPedido.AGUARDANDO_PAGAMENTO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2025-11-21T16:30:20Z"), StatusPedido.PAGO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2025-10-20T18:20:10Z"), StatusPedido.PAGO, u2);
		
		repositorioUsuario.saveAll(Arrays.asList(u1, u2));
		repositorioPedido.saveAll(Arrays.asList(p1, p2, p3));
		
		ItemDoPedido item1 = new ItemDoPedido(p1, P1, 2, P1.getPreco());
		ItemDoPedido item2 = new ItemDoPedido(p1, P3, 1, P4.getPreco());
		ItemDoPedido item3 = new ItemDoPedido(p2, P3, 2, P1.getPreco());
		ItemDoPedido item4 = new ItemDoPedido(p3, P5, 2, P5.getPreco());
		
		repositorioItemDoPedido.saveAll(Arrays.asList(item1, item2, item3, item4));
	}

}
