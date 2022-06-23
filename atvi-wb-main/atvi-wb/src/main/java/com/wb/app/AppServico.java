package com.wb.app;

import com.wb.atualizar.Atualizacao;
import com.wb.atualizar.AtualizarServico;
import com.wb.cadastro.Cadastro;
import com.wb.cadastro.CadastroServico;
import com.wb.excluir.ExcluirServico;
import com.wb.excluir.Exclusao;
import com.wb.io.Entrada;
import com.wb.listagem.Listagem;
import com.wb.listagem.ListarTodosServicos;
import com.wb.modelo.Empresa;

public class AppServico extends Execucao {
	private Empresa empresa;
	private Entrada entrada;

	public AppServico(Empresa empresa) {
		this.empresa = empresa;
		this.entrada = new Entrada();
	}
	
	@Override
	public void executar() {
		boolean execucao = true;
		while (execucao) {
			System.out.println("\nQue tipo de operação você deseja fazer:");
			System.out.println("1 - Cadastrar serviço");
			System.out.println("2 - Listar todos os serviços");
			System.out.println("3 - Atualizar dados de um serviço");
			System.out.println("4 - Excluir serviço");
			System.out.println("0 - Voltar para tela inicial");
			
			int operacao = entrada.receberNumeroInteiro();
			
			switch(operacao) {
			case 0:
				execucao = false;
				System.out.println("Voltando para tela inicial...");
				break;
			case 1:
				Cadastro cadastroServico = new CadastroServico(empresa.getServicos());
				cadastroServico.cadastrar();
				break;
			case 2:
				if (empresa.getServicos().size() == 0) {
					System.out.println("Não há serviços cadastrados!");
					break;
				}
				Listagem listagemServicos = new ListarTodosServicos(empresa.getServicos());
				listagemServicos.listar();
				break;
			case 3:
				if (empresa.getServicos().size() == 0) {
					System.out.println("Não há serviços cadastrados!");
					break;
				}
				Atualizacao atualizarServico = new AtualizarServico(empresa.getServicos());
				atualizarServico.atualizar();
				break;
			case 4:
				if (empresa.getServicos().size() == 0) {
					System.out.println("Não há serviços cadastrados!");
					break;
				}
				Exclusao excluirServico = new ExcluirServico(empresa.getServicos());
				excluirServico.excluir();
				break;
			default:
				System.out.println("Operação não entendida");
			}
		}
	}
}