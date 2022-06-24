package com.wb.excluir;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.listagem.Listagem;
import com.wb.listagem.ListarTodosProdutos;
import com.wb.modelo.Produto;

public class ExcluirProduto extends Exclusao{
	private List<Produto> produtos;
	private Entrada entrada;

	public ExcluirProduto(List<Produto> produtos) {
		this.produtos = produtos;
		this.entrada = new Entrada();
	}

	@Override
	public void excluir() {
		System.out.println("\nInício da exclusão de um produto");
		System.out.println("--------------------------------");
				
		Listagem listarProdutos = new ListarTodosProdutos(produtos);
		listarProdutos.listar();
		
		int numProduto = 0;
		while (true) {
			System.out.println("Por favor informe o numero do produto que deseja atualizar:");
			numProduto = entrada.receberNumeroInteiro();
			if (numProduto > 0 && numProduto <= produtos.size()) {
				break;
			}
			System.out.println("Número de produto inválido! Verifique se o número inserido está correto.");
		}
		
		this.produtos.remove(numProduto - 1);
		System.out.println("Produto excluído com sucesso!");
	}
}