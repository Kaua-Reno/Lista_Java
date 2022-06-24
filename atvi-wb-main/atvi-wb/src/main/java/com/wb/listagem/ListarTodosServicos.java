package com.wb.listagem;

import java.util.List;

import com.wb.modelo.Servico;

public class ListarTodosServicos extends Listagem {
	private List<Servico> servicos;

	public ListarTodosServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	@Override
	public void listar() {
		int n = 1;
		System.out.println("\nLista de todos os serviços:");
		System.out.println("---------------------------");
		for (Servico servico : servicos) {
			System.out.println(n + ")");
			System.out.println("Nome: " + servico.nome);
			System.out.println("Valor: " + servico.valor);
			System.out.println("---------------------------");
			n++;
		}
	}
}
