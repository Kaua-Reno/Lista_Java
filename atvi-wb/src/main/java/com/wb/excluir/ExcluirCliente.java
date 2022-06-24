package com.wb.excluir;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.listagem.Listagem;
import com.wb.listagem.ListarTodosClientes;
import com.wb.modelo.Cliente;

public class ExcluirCliente extends Exclusao{
	private List<Cliente> clientes;
	private Entrada entrada;

	public ExcluirCliente(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}

	@Override
	public void excluir() {
		System.out.println("\nInício da exclusão de um cliente");
		System.out.println("--------------------------------");
				
		Listagem listagemClientes = new ListarTodosClientes(clientes, 1);
		listagemClientes.listar();
		
		int numCliente = 0;
		while (true) {
			System.out.println("Por favor informe o numero do cliente que deseja excluir:");
			numCliente = entrada.receberNumeroInteiro();
			if (numCliente > 0 && numCliente <= clientes.size()) {
				break;
			}
			System.out.println("Número de cliente inválido! Verifique se o número inserido está correto.");
		}
		
		this.clientes.remove(numCliente - 1);
		System.out.println("Cliente excluído com sucesso!");
	}
}