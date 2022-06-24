package com.wb.atualizar;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.listagem.Listagem;
import com.wb.listagem.ListarTodosProdutos;
import com.wb.modelo.Produto;

public class AtualizarProduto extends Atualizacao {
	private List<Produto> produtos;
	private Entrada entrada;

	public AtualizarProduto(List<Produto> produtos) {
		this.produtos = produtos;
		this.entrada = new Entrada();
	}

	@Override
	public void atualizar() {
		System.out.println("\nInício da atualização de um produto");
		System.out.println("-----------------------------------");
		
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

		Produto produto = produtos.get(numProduto - 1);
		
		boolean execucaoSel = true;
		while(execucaoSel) {
			System.out.println("\nInformações do produto:");
			System.out.println("1) Nome: " + produto.nome);
			System.out.println("2) Valor: " + produto.valor);
			System.out.println("0) Sair");
	
			System.out.println("Por favor informe o numero do dado que você deseja atualizar:");
			int numDado = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			
			switch (numDado) {
			case 0:
				System.out.println("Voltando...");
				execucaoSel = false;
				break;
			case 1:
				System.out.println("Por favor informe o novo valor do nome (Atual: " + produto.nome + "):");
				String nome = entrada.receberTexto();
				produto.nome = nome;
				System.out.println("Nome do produto atualizado com sucesso!");
				break;
			case 2:
				System.out.println("Por favor informe o novo valor (Atual: " + produto.valor + "):");
				double valor = entrada.receberNumeroDouble();
				produto.valor = valor;
				System.out.println("Valor do produto atualizado com sucesso!");
				break;
			default:
				System.out.println("Operação não entendida.");
			}
		}
	}
}