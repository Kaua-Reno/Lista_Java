package com.wb.modelo;

public class QuantidadeCliente {
	public Cliente cliente;
	private Integer quantidadeConsumido;
	private Double valorConsumido;
		
	public QuantidadeCliente(Cliente cliente, Integer quantidadeConsumido) {
		this.cliente = cliente;
		this.quantidadeConsumido = quantidadeConsumido;
	}
	
	public QuantidadeCliente(Cliente cliente, Double valorConsumido) {
		this.cliente = cliente;
		this.valorConsumido = valorConsumido;
	}

	public Integer getQuantidadeConsumido() {
		return quantidadeConsumido;
	}
	
	public void setQuantidadeConsumido(Integer quantidadeConsumido) {
		this.quantidadeConsumido = quantidadeConsumido;
	}

	public Double getValorConsumido() {
		return valorConsumido;
	}

	public void setValorConsumido(Double valorConsumido) {
		this.valorConsumido = valorConsumido;
	}
}
