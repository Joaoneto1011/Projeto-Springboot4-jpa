package com.ProjetoJN.curso.entities.enums;

public enum StatusPedido {
	
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigo;
	
	private StatusPedido(int codigo) {
		
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		
		return codigo;
	}
	
	public static StatusPedido valor(int codigo) {
		
		for (StatusPedido status : StatusPedido.values()) {
			
			if (status.getCodigo() == codigo) {
				
				return status;
			}
	
		}
		
		throw new IllegalArgumentException("Codigo do status do pedido inválido!");
	}
}
