package com.wb;

import com.wb.app.AppCliente;
import com.wb.app.AppOutro;
import com.wb.app.AppProduto;
import com.wb.app.AppServico;
import com.wb.app.Execucao;
import com.wb.io.Entrada;
import com.wb.modelo.Empresa;

public class App {
	public static void main(String[] args) {
		System.out.println("Bem-vindo ao cadastro de clientes do Grupo World Beauty");
		
		Empresa empresa = new Empresa();
		boolean execucao = true;
		while (execucao) {
			System.out.println("O que deseja consultar:");
			System.out.println("1 - Controle de Clientes");
			System.out.println("2 - Controle de Serviços");
			System.out.println("3 - Controle de Produtos");
			System.out.println("4 - Outras funções");
			System.out.println("0 - Sair");

			Entrada entrada = new Entrada();
			int operacao = entrada.receberNumeroInteiro();

			switch (operacao) {
			case 0:
				execucao = false;
				System.out.println("Até mais!\n");
				break;
			case 1:
				Execucao appCliente = new AppCliente(empresa);
				appCliente.executar();
				break;	
			case 2:
				Execucao appServico = new AppServico(empresa);
				appServico.executar();
				break;		
			case 3:
				Execucao appProduto = new AppProduto(empresa);
				appProduto.executar();
				break;	
			case 4:
				Execucao appOutro = new AppOutro(empresa);
				appOutro.executar();
				break;
			}
		}
	}
}