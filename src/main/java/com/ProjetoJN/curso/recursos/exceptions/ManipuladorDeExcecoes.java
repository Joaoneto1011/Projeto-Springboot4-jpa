package com.ProjetoJN.curso.recursos.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ProjetoJN.curso.servicos.exception.ExcecaoDeBancoDeDados;
import com.ProjetoJN.curso.servicos.exception.RecursoNaoEncontradoException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ManipuladorDeExcecoes {

	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<ErroPadrao> recursoNaoEncontrado(RecursoNaoEncontradoException e, HttpServletRequest request) {
		
		String erro = "Recurso nao encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(erroPadrao);
	}
	
	@ExceptionHandler(ExcecaoDeBancoDeDados.class)
	public ResponseEntity<ErroPadrao> bancoDeDados(ExcecaoDeBancoDeDados e, HttpServletRequest request) {
		
		String erro = "Erro no Banco de Dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(erroPadrao);
	}
	
	
}
