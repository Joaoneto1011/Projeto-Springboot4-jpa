package com.ProjetoJN.curso.configuracoes;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ProjetoJN.curso.entities.Pedido;
import com.ProjetoJN.curso.entities.Usuario;
import com.ProjetoJN.curso.entities.enums.StatusPedido;
import com.ProjetoJN.curso.repositorios.RepositorioPedido;
import com.ProjetoJN.curso.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class ConfiguracaoDeTeste implements CommandLineRunner {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private RepositorioPedido repositorioPedido;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Joao Neto", "joaoneto@gmail.com", "999999999", "123456");
		Usuario u2 = new Usuario(null, "Joao Victor", "joaovictor@gmail.com", "888888888", "654321");
		
		Pedido p1 = new Pedido(null, Instant.parse("2025-12-22T15:40:30Z"), StatusPedido.AGUARDANDO_PAGAMENTO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2025-11-21T16:30:20Z"), StatusPedido.PAGO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2025-10-20T18:20:10Z"), StatusPedido.PAGO, u2);
		
		repositorioUsuario.saveAll(Arrays.asList(u1, u2));
		repositorioPedido.saveAll(Arrays.asList(p1, p2, p3));
	}

}
