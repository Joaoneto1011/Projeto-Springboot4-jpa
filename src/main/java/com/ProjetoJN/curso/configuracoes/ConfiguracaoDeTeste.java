package com.ProjetoJN.curso.configuracoes;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ProjetoJN.curso.entities.Usuario;
import com.ProjetoJN.curso.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class ConfiguracaoDeTeste implements CommandLineRunner {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Joao Neto", "joaoneto@gmail.com", "999999999", "123456");
		Usuario u2 = new Usuario(null, "Joao Victor", "joaovictor@gmail.com", "888888888", "654321");
		
		repositorioUsuario.saveAll(Arrays.asList(u1, u2));
	}

}
