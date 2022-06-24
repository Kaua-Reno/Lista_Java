package com.wb.cadastro;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.listagem.Listagem;
import com.wb.listagem.ListarTodosClientes;
import com.wb.listagem.ListarTodosProdutos;
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
		System.out.println("\nInício da adição de produtos consumidos por um cliente");
		System.out.println("------------------------------------------------------");
		
		Listagem listagemClientes = new ListarTodosClientes(clientes, 2);
		listagemClientes.listar();
		
		int numCliente = 0;
		while (true) {
			System.out.println("Por favor informe o numero do cliente:");
			numCliente = entrada.receberNumeroInteiro();
			if (numCliente > 0 && numCliente <= clientes.size()) {
				break;
			}
			System.out.println("Número de cliente inválido! Verifique se o número inserido está correto.");
		}
		
		Cliente cliente = clientes.get(numCliente - 1);
		
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
		int numQuantidade = 0;
		while (true) {
			System.out.println("Por favor informe a quantidade que deseja adicionar:");
			numQuantidade = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (numQuantidade > 0) {
				break;
			}
			System.out.println("Número de serviço inválido! Verifique se o número inserido está correto.");
		}
		
		Produto produto = produtos.get(numProduto - 1);
		for (int i = 1; i <= numQuantidade; i++) {
			cliente.getProdutosConsumidos().add(produto);
		}
		System.out.println("Produto consumido adicionado com sucesso!");
	}
}