package com.wb.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;
import com.wb.modelo.Produto;
import com.wb.modelo.RG;
import com.wb.modelo.Servico;
import com.wb.modelo.Telefone;

public class CadastrosInicial extends Execucao{
	private Empresa empresa;

	public CadastrosInicial(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public void executar(){
		for(int i = 1; i <= 20; i++) {
			this.empresa.getProdutos().add(new Produto("Produto " + i, (i+0.25)*3));
			this.empresa.getServicos().add(new Servico("Serviço " + i, (i+0.5)*2));
		}
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for(int i = 1; i <= 30; i++) {
			String genero = "";
			if(i % 2 == 0) {
				genero = "Feminino";
			} else {
				genero = "Masculino";
			}
			if (i < 10) {
				Cliente cliente = new Cliente("Gerson " + i, "Gers0" + i, 
						new CPF(LocalDate.parse("15/0" + i + "/200" + i, formato), "123456789/0" + i), genero);
				cliente.getRgs().add(new RG(LocalDate.parse("18/0" + i + "/200" + i, formato), i + "0.123.456-78"));
				cliente.getTelefones().add(new Telefone ("12", "98765-432" + i));
				cliente.getTelefones().add(new Telefone ("11", "98123-456" + i));
				for (int j = 0; j < i; j++) {
					if (i % 2 == 0) {
						cliente.getServicosConsumidos().add(this.empresa.getServicos().get(i));
					} else {
						cliente.getProdutosConsumidos().add(this.empresa.getProdutos().get(i));	
					}
				}
				this.empresa.getClientes().add(cliente);
			} else {
				Cliente cliente = new Cliente("Gerson " + i, "Gers0" + i, 
						new CPF(LocalDate.parse(i + "/08/20" + i, formato), "123456789/" + i), genero);
				cliente.getRgs().add(new RG(LocalDate.parse(i + "/08/2010", formato), i + ".123.456-78"));
				cliente.getTelefones().add(new Telefone ("12", "98765-43" + i));
				if (i == 30) {
					cliente.getRgs().add(new RG(LocalDate.parse(i + "/10/2015", formato), i + ".987.654-32"));
					cliente.getServicosConsumidos().add(this.empresa.getServicos().get(i-15));
					cliente.getServicosConsumidos().add(this.empresa.getServicos().get(i-13));
					cliente.getProdutosConsumidos().add(this.empresa.getProdutos().get(i-15));
					cliente.getProdutosConsumidos().add(this.empresa.getProdutos().get(i-13));
					cliente.getProdutosConsumidos().add(this.empresa.getProdutos().get(i-12));
				} else {
					if (i % 2 == 0) {
						cliente.getServicosConsumidos().add(this.empresa.getServicos().get(i-10));
						cliente.getServicosConsumidos().add(this.empresa.getServicos().get(i-10));	
						cliente.getProdutosConsumidos().add(this.empresa.getProdutos().get(i-10));	
					} else {
						cliente.getProdutosConsumidos().add(this.empresa.getProdutos().get(i-10));	
						cliente.getProdutosConsumidos().add(this.empresa.getProdutos().get(i-10));
						cliente.getServicosConsumidos().add(this.empresa.getServicos().get(i-10));
					}
				}
				this.empresa.getClientes().add(cliente);
			}	
		}
	}
}