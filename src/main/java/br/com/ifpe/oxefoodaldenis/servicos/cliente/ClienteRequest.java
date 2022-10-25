package br.com.ifpe.oxefoodaldenis.servicos.cliente;

import br.com.ifpe.oxefoodaldenis.modelo.cliente.Cliente;

public class ClienteRequest {

	private String chaveEmpresa;

	private String nome;

	private String cpf;

	private String fone;

	private String foneAlternativo;

	public Cliente buildCliente() {

		return Cliente.builder()
				.chaveEmpresa(chaveEmpresa)
				.nome(nome)
				.cpf(cpf)
				.fone(fone)
				.foneAlternativo(foneAlternativo)
				.build();
	}

}
