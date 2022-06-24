package com.wb.cadastro;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.listagem.Listagem;
import com.wb.listagem.ListarTodosClientes;
import com.wb.listagem.ListarTodosServicos;
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
		System.out.println("\nInício da adição de serviços consumidos por um cliente");
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
		
		Listagem listarServicos = new ListarTodosServicos(servicos);
		listarServicos.listar();
		
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
		for (int i = 1; i <= numQuantidade; i++) {
			cliente.getServicosConsumidos().add(servico);
		}
		System.out.println("Serviço consumido adicionado com sucesso!");
	}
}