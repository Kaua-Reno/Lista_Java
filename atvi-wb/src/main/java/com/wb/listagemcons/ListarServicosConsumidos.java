package com.wb.listagemcons;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.wb.modelo.Cliente;
import com.wb.modelo.QuantidadeServico;
import com.wb.modelo.Servico;

public class ListarServicosConsumidos extends ListagemServCons {
	private Cliente cliente;
	private int tipo;

	public ListarServicosConsumidos(Cliente cliente, int tipo) {
		this.cliente = cliente;
		this.tipo = tipo;
	}
	
	@Override
	public List<Servico> listarServConsumido() {
		System.out.println("Serviço(s) Consumido(s): ");
		if (cliente.getServicosConsumidos().size() == 0) {
			System.out.println(" Este cliente não possui serviços consumidos.");
		} else {
			Set<Servico> todosServicos = new HashSet<>();
			todosServicos.addAll(cliente.getServicosConsumidos());
			List<QuantidadeServico> quantidadeTodosServicos = new ArrayList<>();
			for (Servico servico : todosServicos) {
				int quantidade = 0;
				for (Servico servicoCliente : cliente.getServicosConsumidos()){
					if (servico.equals(servicoCliente)) {
						quantidade++;
					}
				}
				QuantidadeServico quantidadeServico = new QuantidadeServico(servico, quantidade);
				quantidadeTodosServicos.add(quantidadeServico);		
			}
			int n = 1;
			for (QuantidadeServico quantidadeServico : quantidadeTodosServicos) {
				if (tipo == 1) {
					System.out.print(n + ")");
					n++;
				}
				System.out.println(" Nome: " + quantidadeServico.servico.nome + 
						" - Valor: " + quantidadeServico.servico.valor + 
						" - Quantidade consumido: " +  quantidadeServico.getQuantidadeConsumido());
			}
			if (tipo == 1) {
				List<Servico> servicos = new ArrayList<>();
				servicos.addAll(todosServicos);
				return servicos;
			}
		}
		return null;
	}
}
