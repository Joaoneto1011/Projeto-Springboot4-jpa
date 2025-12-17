package com.ProjetoJN.curso.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoJN.curso.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {
	
	@GetMapping
	public ResponseEntity<Usuario> EncontrarTudo() {
		
		Usuario usuario = new Usuario(1L, "Joao Neto", "Joao@gmail.com", "99999999", "123456789");
		
		return ResponseEntity.ok().body(usuario);
	}

}
