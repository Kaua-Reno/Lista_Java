package com.wb.excluir;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Servico;

public class ExcluirServico extends Exclusao {
	private List<Servico> servicos;
	private Entrada entrada;

	public ExcluirServico(List<Servico> servicos) {
		this.servicos = servicos;
		this.entrada = new Entrada();
	}

	@Override
	public void excluir() {
		System.out.println("\nInício da exclusão de um serviço");
		System.out.println("--------------------------------");
				
		System.out.println("Lista de todos os serviços:");
		int i = 1;
		for (Servico servico : servicos) {
			System.out.println(i + " - " + servico.nome);	
			i++;
		}
		
		int numServico = 0;
		while (true) {
			System.out.println("Por favor informe o numero do serviço que deseja atualizar:");
			numServico = entrada.receberNumeroInteiro();
			if (numServico > 0 && numServico <= servicos.size()) {
				break;
			}
			System.out.println("Número de serviço inválido! Verifique se o número inserido está correto.");
		}
		
		this.servicos.remove(numServico - 1);
		System.out.println("Serviço excluído com sucesso!");
	}
}