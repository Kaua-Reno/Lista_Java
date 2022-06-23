package com.wb.modelo;

public class QuantidadeProduto {
	public Produto produto;
	private Integer quantidadeConsumido;
	
	public QuantidadeProduto(Produto produto, Integer quantidadeConsumido) {
		this.produto = produto;
		this.quantidadeConsumido = quantidadeConsumido;
	}

	public Integer getQuantidadeConsumido() {
		return quantidadeConsumido;
	}
	
	public void setQuantidadeConsumido(Integer quantidadeConsumido) {
		this.quantidadeConsumido = quantidadeConsumido;
	}	
}
