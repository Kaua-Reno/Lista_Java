package com.wb.listagem;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.wb.listagemcons.ListagemProdCons;
import com.wb.listagemcons.ListagemServCons;
import com.wb.listagemcons.ListarProdutosConsumidos;
import com.wb.listagemcons.ListarServicosConsumidos;
import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class ListarTodosClientes extends Listagem {
	private List<Cliente> clientes;
	private int tipo;

	public ListarTodosClientes(List<Cliente> clientes, int tipo) {
		this.clientes = clientes;
		this.tipo = tipo;
	}

	@Override
	public void listar() {
		int n = 1;
		if (tipo == 2) {
			System.out.println("\nLista de todos os clientes do gênero masculino:");
		} else {
			if (tipo == 3) {
				System.out.println("\nLista de todos os clientes do gênero feminino:");
			}
			else {
				System.out.println("\nLista de todos os clientes:");
			}
		}
		System.out.println("----------------------------------------------");
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (Cliente cliente : clientes) {
			System.out.println(n + ")");
			System.out.println("Nome: " + cliente.nome);
			System.out.println("Nome social: " + cliente.nomeSocial);
			if (tipo != 2 && tipo != 3) {
				System.out.println("Gênero: " + cliente.genero);
			}
			System.out.println("CPF: " + cliente.getCpf().getValor() + " - Data Emissão: " + cliente.getCpf().getDataEmissao().format(formato));
			System.out.println("RG(s): ");
			for (RG rg : cliente.getRgs()) {
				System.out.println(" " + rg.getValor() + " - Data Emissão: "  + rg.getDataEmissao().format(formato));
			}
			System.out.println("Telefone(s): ");
			for (Telefone telefone : cliente.getTelefones()) {
				System.out.println(" (" + telefone.getDdd() + ")" + telefone.getNumero());
			}
			if (tipo == 0) {
				ListagemServCons listarServicosConsumidos = new ListarServicosConsumidos(cliente, 0);
				listarServicosConsumidos.listarServConsumido();
				
				ListagemProdCons listarProdutosConsumidos = new ListarProdutosConsumidos(cliente, 0);
				listarProdutosConsumidos.listarProdConsumido();
			}
			System.out.println("Data de cadastro: " + cliente.getDataCadastro().format(formato));
			System.out.println("----------------------------------------------");
			n++;
		}
	}
}