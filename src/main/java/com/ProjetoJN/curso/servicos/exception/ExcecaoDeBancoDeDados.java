package com.ProjetoJN.curso.servicos.exception;

public class ExcecaoDeBancoDeDados extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ExcecaoDeBancoDeDados(String mensagem) {
		
		super(mensagem);
	}

}
