package com.wb.listagem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;
import com.wb.modelo.QuantidadeCliente;

public class ListarDezConsumiram extends Listagem {
	private Empresa empresa;
	private String maisOuMenos;
	private Entrada entrada;

	public ListarDezConsumiram(Empresa empresa, String maisOuMenos) {
		this.empresa = empresa;
		this.maisOuMenos = maisOuMenos;
		this.entrada = new Entrada();
	}
	
	@Override
	public void listar() {
		int consumidoNum = 0;
		boolean execucaoConsumido = true;
		while(execucaoConsumido) {
			System.out.println("Deseja mostrar os 10 clientes que " + maisOuMenos + " consumiram, em quantidade, serviços ou produtos?");
			System.out.println("1 - Serviços");
			System.out.println("2 - Produtos");
			consumidoNum = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (consumidoNum == 1 || consumidoNum == 2) {
				execucaoConsumido = false;
			}
			else {
				System.out.println("Valor inválido! Verifique se você digitou corretamente!");
			}
		}
		
		String consumido = "";
		List <QuantidadeCliente> quantidadeTodosClientes = new ArrayList<>();
		for (Cliente cliente : empresa.getClientes()) {
			if (consumidoNum == 1) {
				consumido = "serviços";
				int quantidadeServicos = cliente.getServicosConsumidos().size();
				QuantidadeCliente quantidadeCliente = new QuantidadeCliente(cliente, quantidadeServicos);
				quantidadeTodosClientes.add(quantidadeCliente);
			} else {
				consumido = "produtos";
				int quantidadeProdutos = cliente.getProdutosConsumidos().size();
				QuantidadeCliente quantidadeCliente = new QuantidadeCliente(cliente, quantidadeProdutos);
				quantidadeTodosClientes.add(quantidadeCliente);
			}
		}
			
		if (maisOuMenos.equals("mais")) {
			Collections.sort(quantidadeTodosClientes, new Comparator<QuantidadeCliente>() {
				  @Override
				  public int compare(QuantidadeCliente qc1, QuantidadeCliente qc2) {
				    return qc2.getQuantidadeConsumido().compareTo(qc1.getQuantidadeConsumido());
				  }
				});
		} else {
			Collections.sort(quantidadeTodosClientes, new Comparator<QuantidadeCliente>() {
				  @Override
				  public int compare(QuantidadeCliente qc1, QuantidadeCliente qc2) {
				    return qc1.getQuantidadeConsumido().compareTo(qc2.getQuantidadeConsumido());
				  }
				});
		}
			
		int cont = 1;
		System.out.println("\nLista dos 10 clientes que " + maisOuMenos + " consumiram " + consumido);
		System.out.println("--------------------------------------------------");
		for (QuantidadeCliente quantidadeCliente : quantidadeTodosClientes) {
			if (cont > 10) {
				break;
			}
			System.out.println(cont + ")");
			System.out.println("Nome: " + quantidadeCliente.cliente.nome);
			System.out.println("CPF: " + quantidadeCliente.cliente.getCpf().getValor());
			System.out.println("Quantidade de " + consumido +  " consumidos: " + quantidadeCliente.getQuantidadeConsumido());
			System.out.println("--------------------------------------");
			cont++;			
		}	
	}
}