package com.wb.excluir;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Servico;

public class RemoverServico extends Exclusao {
	private List<Cliente> clientes;
	private Entrada entrada;

	public RemoverServico(List<Cliente> clientes) {
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
			
			if(cliente.getServicosConsumidos().size() == 0) {
				System.out.println("Não há serviços consumidos por este cliente");
			} else {
				System.out.println("Lista de todos os serviços deste cliente:");
				int j = 1;
				for (Servico servico : cliente.getServicosConsumidos()) {
					System.out.println(j + ") " + servico.nome);	
					j++;
				}
				
				System.out.println("Por favor informe o número do serviço a ser removido:");
				int numServico = entrada.receberNumeroInteiro();
				
				cliente.getServicosConsumidos().remove(numServico - 1);
				execucaoCliente = false;
			}
		
		}

	}

}
