package com.wb.listagem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;
import com.wb.modelo.Produto;
import com.wb.modelo.QuantidadeCliente;
import com.wb.modelo.Servico;

public class ListarMaisConsumiramValor extends Listagem {
	private Empresa empresa;
	private Entrada entrada;

	public ListarMaisConsumiramValor(Empresa empresa) {
		this.empresa = empresa;
		this.entrada = new Entrada();
	}
	
	@Override
	public void listar() {
		int consumidoNum = 0;
		boolean execucaoConsumido = true;
		while(execucaoConsumido) {
			System.out.println("Deseja mostrar os 5 clientes que mais consumiram, em valor, serviços ou produtos?");
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
				double valorServicos = 0;
				for (Servico servico : cliente.getServicosConsumidos()) {
					valorServicos += servico.valor;
				}	
				QuantidadeCliente quantidadeCliente = new QuantidadeCliente(cliente, valorServicos);
				quantidadeTodosClientes.add(quantidadeCliente);
			} else {
				consumido = "produtos";
				double valorProdutos = 0;
				for (Produto produto : cliente.getProdutosConsumidos()) {
					valorProdutos += produto.valor;
				}	
				QuantidadeCliente quantidadeCliente = new QuantidadeCliente(cliente, valorProdutos);
				quantidadeTodosClientes.add(quantidadeCliente);
			}
		}
			
		Collections.sort(quantidadeTodosClientes, new Comparator<QuantidadeCliente>() {
			  @Override
			  public int compare(QuantidadeCliente qc1, QuantidadeCliente qc2) {
			    return qc2.getValorConsumido().compareTo(qc1.getValorConsumido());
			  }
			});
		
		int cont = 1;
		System.out.println("\nLista dos 5 clientes que mais gastaram em " + consumido);
		System.out.println("-------------------------------------------------");
		for (QuantidadeCliente quantidadeCliente : quantidadeTodosClientes) {
			if (cont > 5) {
				break;
			}
			System.out.println(cont + ")");
			System.out.println("Nome: " + quantidadeCliente.cliente.nome);
			System.out.println("CPF: " + quantidadeCliente.cliente.getCpf().getValor());
			System.out.println("Valor total de " + consumido +  " consumidos: " + quantidadeCliente.getValorConsumido());
			System.out.println("-------------------------------------------------");
			cont++;			
		}	
	}
}
