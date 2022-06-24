package com.wb.app;

import com.wb.atualizar.Atualizacao;
import com.wb.atualizar.AtualizarProduto;
import com.wb.cadastro.Cadastro;
import com.wb.cadastro.CadastroProduto;
import com.wb.excluir.ExcluirProduto;
import com.wb.excluir.Exclusao;
import com.wb.io.Entrada;
import com.wb.listagem.Listagem;
import com.wb.listagem.ListarTodosProdutos;
import com.wb.modelo.Empresa;

public class AppProduto extends Execucao {
	private Empresa empresa;
	private Entrada entrada;

	public AppProduto(Empresa empresa) {
		this.empresa = empresa;
		this.entrada = new Entrada();
	}
	
	@Override
	public void executar() {
		boolean execucao = true;
		while (execucao) {
			System.out.println("\nQue tipo de operação você deseja fazer:");
			System.out.println("1 - Cadastrar produto");
			System.out.println("2 - Listar todos os produtos");
			System.out.println("3 - Atualizar dados de um produto");
			System.out.println("4 - Excluir produto");
			System.out.println("0 - Voltar para tela inicial");
			
			int operacao = entrada.receberNumeroInteiro();
			
			switch(operacao) {
			case 0:
				execucao = false;
				System.out.println("Voltando para tela inicial...");
				break;
			case 1:
				Cadastro cadastroProduto = new CadastroProduto(empresa.getProdutos());
				cadastroProduto.cadastrar();
				break;
			case 2:
				if (empresa.getProdutos().size() == 0) {
					System.out.println("Não há produto cadastrados!");
					break;
				}
				Listagem listagemProdutos = new ListarTodosProdutos(empresa.getProdutos());
				listagemProdutos.listar();
				break;
			case 3:
				if (empresa.getProdutos().size() == 0) {
					System.out.println("Não há produto cadastrados!");
					break;
				}
				Atualizacao atualizarProduto = new AtualizarProduto(empresa.getProdutos());
				atualizarProduto.atualizar();
				break;
			case 4:
				if (empresa.getProdutos().size() == 0) {
					System.out.println("Não há produto cadastrados!");
					break;
				}
				Exclusao excluirProduto = new ExcluirProduto(empresa.getProdutos());
				excluirProduto.excluir();
				break;
			default:
				System.out.println("Operação não entendida");
			}
		}
	}
}