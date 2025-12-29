package com.ProjetoJN.curso.recursos.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErroPadrao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataHora;
	private Integer codigoStatus;
	private String erro;
	private String mensagem;
	private String caminhoRequisicao;
	
	public ErroPadrao() {
		
	}

	public ErroPadrao(Instant dataHora, Integer codigoStatus, String erro, String mensagem, String caminhoRequisicao) {
		this.dataHora = dataHora;
		this.codigoStatus = codigoStatus;
		this.erro = erro;
		this.mensagem = mensagem;
		this.caminhoRequisicao = caminhoRequisicao;
	}

	public Instant getDataHora() {
		return dataHora;
	}

	public void setDataHora(Instant dataHora) {
		this.dataHora = dataHora;
	}

	public Integer getCodigoStatus() {
		return codigoStatus;
	}

	public void setCodigoStatus(Integer codigoStatus) {
		this.codigoStatus = codigoStatus;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getCaminhoRequisicao() {
		return caminhoRequisicao;
	}

	public void setCaminhoRequisicao(String caminhoRequisicao) {
		this.caminhoRequisicao = caminhoRequisicao;
	}

}
