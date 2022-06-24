package com.wb.listagemcons;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;
import com.wb.modelo.QuantidadeProduto;

public class ListarProdutosConsumidos extends ListagemProdCons {
	private Cliente cliente;
	private int tipo;

	public ListarProdutosConsumidos(Cliente cliente, int tipo) {
		this.cliente = cliente;
		this.tipo = tipo;
	}
	
	@Override
	public List<Produto> listarProdConsumido() {
		System.out.println("Produto(s) Consumido(s): ");
		if (cliente.getProdutosConsumidos().size() == 0) {
			System.out.println(" Este cliente não possui produtos consumidos.");
		} else {
			Set<Produto> todosProdutos = new HashSet<>();
			todosProdutos.addAll(cliente.getProdutosConsumidos());
			List<QuantidadeProduto> quantidadeTodosProdutos = new ArrayList<>();
			for (Produto produto : todosProdutos) {
				int quantidade = 0;
				for (Produto produtoCliente : cliente.getProdutosConsumidos()){
					if (produto.equals(produtoCliente)) {
						quantidade++;
					}
				}
				QuantidadeProduto quantidadeProduto = new QuantidadeProduto(produto, quantidade);
				quantidadeTodosProdutos.add(quantidadeProduto);		
			}
			int n = 1;
			for (QuantidadeProduto quantidadeProduto : quantidadeTodosProdutos) {
				if (tipo == 1) {
					System.out.print(n + ")");
					n++;
				}
				System.out.println(" Nome: " + quantidadeProduto.produto.nome + 
						" - Valor: " + quantidadeProduto.produto.valor +
						" - Quantidade consumido: " +  quantidadeProduto.getQuantidadeConsumido());
			}
			if (tipo == 1) {
				List<Produto> produtos = new ArrayList<>();
				produtos.addAll(todosProdutos);
				return produtos;
			}
		}
		return null;
	}
}