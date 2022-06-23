package com.wb.cadastro;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;

public class AdicionarProduto extends Cadastro{
	private List<Cliente> clientes;
	private List<Produto> produtos;
	private Entrada entrada;

	public AdicionarProduto(List<Cliente> clientes, List<Produto> produtos) {
		this.clientes = clientes;
		this.produtos = produtos;
		this.entrada = new Entrada();
	}
	
	@Override
	public void cadastrar() {
		System.out.println("Lista de todos os clientes:");
		int i = 1;
		for (Cliente cliente : clientes) {
			System.out.println(i + ") " + cliente.nome + " - CPF: " + cliente.getCpf().getValor());	
			i++;
		}
		
		int numCliente = 0;
		while (true) {
			System.out.println("Por favor informe o numero do cliente:");
			numCliente = entrada.receberNumeroInteiro();
			if (numCliente > 0 && numCliente <= clientes.size()) {
				break;
			}
			System.out.println("N�mero de cliente inv�lido! Verifique se o n�mero inserido est� correto.");
		}
		
		Cliente cliente = clientes.get(numCliente - 1);
		
		System.out.println("Lista de todos os produtos:");
		int j = 1;
		for (Produto produto : produtos) {
			System.out.println(j + ") " + produto.nome);	
			j++;
		}
		
		int numProduto = 0;
		while (true) {
			System.out.println("Por favor informe o numero do produto que deseja atualizar:");
			numProduto = entrada.receberNumeroInteiro();
			if (numProduto > 0 && numProduto <= produtos.size()) {
				break;
			}
			System.out.println("N�mero de produto inv�lido! Verifique se o n�mero inserido est� correto.");
		}
		int numQuantidade = 0;
		while (true) {
			System.out.println("Por favor informe a quantidade que deseja adicionar:");
			numQuantidade = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (numQuantidade > 0) {
				break;
			}
			System.out.println("N�mero de servi�o inv�lido! Verifique se o n�mero inserido est� correto.");
		}
		
		Produto produto = produtos.get(numProduto - 1);
		for (i = 1; i <= numQuantidade; i++) {
			cliente.getProdutosConsumidos().add(produto);
		}
	}
}
