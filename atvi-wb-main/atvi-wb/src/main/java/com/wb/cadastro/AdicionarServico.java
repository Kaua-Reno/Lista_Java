package com.wb.cadastro;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Servico;

public class AdicionarServico extends Cadastro {
	private List<Cliente> clientes;
	private List<Servico> servicos;
	private Entrada entrada;

	public AdicionarServico(List<Cliente> clientes, List<Servico> servicos) {
		this.clientes = clientes;
		this.servicos = servicos;
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
			System.out.println("Número de cliente inválido! Verifique se o número inserido está correto.");
		}
		
		Cliente cliente = clientes.get(numCliente - 1);
		
		System.out.println("Lista de todos os serviços:");
		int j = 1;
		for (Servico servico : servicos) {
			System.out.println(j + ") " + servico.nome);	
			j++;
		}
		
		int numServico = 0;
		while (true) {
			System.out.println("Por favor informe o numero do serviço que deseja adicionar:");
			numServico = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (numServico > 0 && numServico <= servicos.size()) {
				break;
			}
			System.out.println("Número de serviço inválido! Verifique se o número inserido está correto.");
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
		
		Servico servico = servicos.get(numServico - 1);
		for (i = 1; i <= numQuantidade; i++) {
			cliente.getServicosConsumidos().add(servico);
		}
	}
}
