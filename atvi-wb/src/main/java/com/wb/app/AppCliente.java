package com.wb.app;

import com.wb.atualizar.Atualizacao;
import com.wb.atualizar.AtualizarCliente;
import com.wb.cadastro.AdicionarProduto;
import com.wb.cadastro.AdicionarServico;
import com.wb.cadastro.Cadastro;
import com.wb.cadastro.CadastroCliente;
import com.wb.excluir.ExcluirCliente;
import com.wb.excluir.Exclusao;
import com.wb.excluir.RemoverProduto;
import com.wb.excluir.RemoverServico;
import com.wb.io.Entrada;
import com.wb.listagem.Listagem;
import com.wb.listagem.ListarTodosClientes;
import com.wb.modelo.Empresa;

public class AppCliente extends Execucao {
	private Empresa empresa;
	private Entrada entrada;

	public AppCliente(Empresa empresa) {
		this.empresa = empresa;
		this.entrada = new Entrada();
	}
	
	@Override
	public void executar() {
		boolean execucao = true;
		while (execucao) {
			System.out.println("\nQue tipo de operação você deseja fazer:");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Listar todos os clientes");
			System.out.println("3 - Atualizar dados de um cliente");
			System.out.println("4 - Excluir cliente");
			System.out.println("5 - Adicionar um serviço consumido por um cliente");
			System.out.println("6 - Adicionar um produto consumido por um cliente");
			System.out.println("7 - Remover um serviço consumido por um cliente");
			System.out.println("8 - Remover um produto consumido por um cliente");
			System.out.println("0 - Voltar para tela inicial");	
			int operacao = entrada.receberNumeroInteiro();
			int operacaoFinal = operacao;
			
			if (operacao == -1) {
				operacaoFinal = -2;
			}
			if (operacao >= 2 && operacao <= 8 && empresa.getClientes().size() == 0) {
				System.out.println("Não há clientes cadastrados!");
				operacaoFinal = -1;
			}
			if ((operacao == 5 || operacao == 7) && empresa.getServicos().size() == 0) {
				System.out.println("Não há serviços cadastrados!");
				operacaoFinal = -1;
			} 
			if ((operacao == 6 || operacao == 8) && empresa.getProdutos().size() == 0) {
				System.out.println("Não há produtos cadastros!");
				operacaoFinal = -1;
			}
			
			switch(operacaoFinal) {
			case -1:
				break;
			case 0:
				execucao = false;
				System.out.println("Voltando para tela inicial...");
				break;
			case 1:
				Cadastro cadastroCliente = new CadastroCliente(empresa.getClientes());
				cadastroCliente.cadastrar();
				break;
			case 2:
				Listagem listagemClientes = new ListarTodosClientes(empresa.getClientes(), 0);
				listagemClientes.listar();
				break;
			case 3:
				Atualizacao atualizarClientes = new AtualizarCliente(empresa.getClientes());
				atualizarClientes.atualizar();
				break;
			case 4:
				Exclusao excluirCliente = new ExcluirCliente(empresa.getClientes());
				excluirCliente.excluir();
				break;
			case 5:
				Cadastro adicionarServico = new AdicionarServico(empresa.getClientes(), empresa.getServicos());
				adicionarServico.cadastrar();
				break;
			case 6:
				Cadastro adicionarProduto = new AdicionarProduto(empresa.getClientes(), empresa.getProdutos());
				adicionarProduto.cadastrar();
				break;
			case 7:
				Exclusao removerServico = new RemoverServico(empresa.getClientes());
				removerServico.excluir();
				break;
			case 8:
				Exclusao removerProduto = new RemoverProduto(empresa.getClientes());
				removerProduto.excluir();
				break;
			default:
				System.out.println("Operação não entendida.");
			}
		}
	}
}