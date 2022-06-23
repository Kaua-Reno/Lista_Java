package com.wb.excluir;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;

public class RemoverProduto extends Exclusao{
	private List<Cliente> clientes;
	private Entrada entrada;

	public RemoverProduto(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}
	
	@Override
	public void excluir() {
		System.out.println("Lista de todos os clientes:");
		int i = 1;
		for (Cliente cliente : clientes) {
			System.out.println(i + ") " + cliente.nome + " - CPF: " + cliente.getCpf().getValor());	
			i++;
		}
		boolean execucaoCliente = true;
		while(execucaoCliente) {
		
			int numCliente = 0;
			while (true) {
				System.out.println("Por favor informe o numero do cliente (Digite 0 para sair):");
				numCliente = entrada.receberNumeroInteiro();
				if (numCliente >= 0 && numCliente <= clientes.size()) {
					break;
				}
				System.out.println("Número de cliente inválido! Verifique se o número inserido está correto.");
			}
			
			if(numCliente == 0) {
				break;
			}
			
			Cliente cliente = clientes.get(numCliente - 1);
			
			if(cliente.getProdutosConsumidos().size() == 0) {
				System.out.println("Não há produtos consumidos por este cliente");
			} else {
				System.out.println("Lista de todos os produtos deste cliente:");
				int j = 1;
				for (Produto produto : cliente.getProdutosConsumidos()) {
					System.out.println(j + ") " + produto.nome);	
					j++;
				}
				
				int numProduto = 0;
				while (true) {
					System.out.println("Por favor informe o numero do produto que deseja atualizar:");
					numProduto = entrada.receberNumeroInteiro();
					if (numProduto > 0 && numProduto <= cliente.getProdutosConsumidos().size()) {
						break;
					}
					System.out.println("Número de produto inválido! Verifique se o número inserido está correto.");
				}
				
				cliente.getProdutosConsumidos().remove(numProduto - 1);
				execucaoCliente = false;
			}
		}
	}	
}
