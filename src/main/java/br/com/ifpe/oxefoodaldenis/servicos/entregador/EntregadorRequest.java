package br.com.ifpe.oxefoodaldenis.servicos.entregador;

import br.com.ifpe.oxefoodaldenis.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {
	
	private String chaveEmpresa;

	private String nome;

	private String cpf;

	private String rg;

	private String endereco;
	
	private int qtdEntregasRealizadas;
	
	private double valorFrete;

	public Entregador buildEntregador() {

		return Entregador.builder()
				.chaveEmpresa(chaveEmpresa)
				.nome(nome)
				.cpf(cpf)
				.rg(rg)
				.endereco(endereco)
				.qtdEntregasRealizadas(qtdEntregasRealizadas)
				.valorFrete(valorFrete)
				.build();
	}

}
