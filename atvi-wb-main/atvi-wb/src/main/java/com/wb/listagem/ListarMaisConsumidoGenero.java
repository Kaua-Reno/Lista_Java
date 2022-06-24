package com.wb.listagem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;
import com.wb.modelo.Produto;
import com.wb.modelo.QuantidadeProduto;
import com.wb.modelo.QuantidadeServico;
import com.wb.modelo.Servico;

public class ListarMaisConsumidoGenero extends Listagem {
	private Empresa empresa;
	private Entrada entrada;

	public ListarMaisConsumidoGenero(Empresa empresa) {
		this.empresa = empresa;
		this.entrada = new Entrada();
	}
	
	@Override
	public void listar() {
		boolean execucaoConsumido = true;
		int consumidoNum = 0;
		while(execucaoConsumido) {		
			System.out.println("Deseja mostrar serviços ou produtos mais consumidos?");
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

		String genero = "";
		boolean execucaoGenero = true;
		while(execucaoGenero) {
			System.out.println("Por qual gênero você deseja listar?");
			System.out.println("1 - Masculino");
			System.out.println("2 - Feminino");
			int generoNum = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (generoNum == 1) {
				genero = "Masculino";
				execucaoGenero = false;
			} else {
				if (generoNum == 2) {
					genero = "Feminino";
					execucaoGenero = false;
				}
				else {
				System.out.println("Valor inválido! Verifique se você digitou corretamente!");
				}
			}
		}
		
		if (consumidoNum == 1) {
			List <QuantidadeServico> quantidadeTodosServicos = new ArrayList<>();
			for (Servico servico : empresa.getServicos()) {
				int quantidade = 0;
				for (Cliente cliente : empresa.getClientes()) {
					for (Servico servicoCliente : cliente.getServicosConsumidos()) {
						if(servico.equals(servicoCliente) && cliente.genero.equals(genero)) {
							quantidade++;
						}
					}
				}
				QuantidadeServico quantidadeServico = new QuantidadeServico(servico, quantidade);
				quantidadeTodosServicos.add(quantidadeServico);
			}
			
			Collections.sort(quantidadeTodosServicos, new Comparator<QuantidadeServico>() {
				  @Override
				  public int compare(QuantidadeServico qs1, QuantidadeServico qs2) {
				    return qs2.getQuantidadeConsumido().compareTo(qs1.getQuantidadeConsumido());
				  }
				});
			
			if(quantidadeTodosServicos.size() == 0) {
				System.out.println("Não há serviços cadastrados!");
			} else {
				System.out.println("\nLista dos serviços mais consumidos pelo gênero " + genero.toLowerCase());
				System.out.println("--------------------------------------");
				for (QuantidadeServico quantidadeServico : quantidadeTodosServicos) {
					System.out.println("Nome: " + quantidadeServico.servico.nome);
					System.out.println("Quantidade de vezes consumido: " + quantidadeServico.getQuantidadeConsumido());
					System.out.println("--------------------------------------");
				}
			}
			execucaoConsumido = false;
		} else {
			if (consumidoNum == 2) {
				List <QuantidadeProduto> quantidadeTodosProdutos = new ArrayList<>();
				for (Produto produto : empresa.getProdutos()) {
					int quantidade = 0;
					for (Cliente cliente : empresa.getClientes()) {
						for (Produto clienteProduto : cliente.getProdutosConsumidos()) {
							if(produto.equals(clienteProduto) && cliente.genero.equals(genero)) {
								quantidade++;
							}
						}
					}
					QuantidadeProduto quantidadeProduto = new QuantidadeProduto(produto, quantidade);
					quantidadeTodosProdutos.add(quantidadeProduto);
				}
				
				Collections.sort(quantidadeTodosProdutos, new Comparator<QuantidadeProduto>() {
					  @Override
					  public int compare(QuantidadeProduto qp1, QuantidadeProduto qp2) {
					    return qp2.getQuantidadeConsumido().compareTo(qp1.getQuantidadeConsumido());
					  }
					});
				if(quantidadeTodosProdutos.size() == 0) {
					System.out.println("Não há produtos cadastrados!");
				} else {
					System.out.println("\nLista dos produtos mais consumidos pelo gênero " + genero.toLowerCase());
					System.out.println("--------------------------------------------------------");
					for (QuantidadeProduto quantidadeProduto : quantidadeTodosProdutos) {
						System.out.println("Nome: " + quantidadeProduto.produto.nome);
						System.out.println("Quantidade de vezes consumido: " + quantidadeProduto.getQuantidadeConsumido());
						System.out.println("--------------------------------------------------------");
					}	
				}
				execucaoConsumido = false;
			}
			else {
				System.out.println("Valor inválido! Verifique se você digitou corretamente!");
			}
		}
	}
}