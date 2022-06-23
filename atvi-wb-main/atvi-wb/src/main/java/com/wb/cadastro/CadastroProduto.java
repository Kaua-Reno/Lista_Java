package com.wb.cadastro;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;

public class CadastroProduto extends Cadastro{
	private List<Produto> produtos;
	private Entrada entrada;

	public CadastroProduto(List<Produto> produtos) {
		this.produtos = produtos;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("\nInício do cadastro do produto");
		System.out.println("-----------------------------");
		
		System.out.println("Por favor informe o nome do produto:");
		String nome = entrada.receberTexto();
		
		System.out.println("Por favor informe o valor do produto:");
		double valor = entrada.receberNumeroDouble();
		entrada.receberTexto();
		
		Produto produto = new Produto(nome, valor);
		
		this.produtos.add(produto);
		System.out.println("Produto cadastrado com sucesso!");
	}
}
