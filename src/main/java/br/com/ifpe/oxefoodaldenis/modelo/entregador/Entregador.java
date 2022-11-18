package br.com.ifpe.oxefoodaldenis.modelo.entregador;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

import br.com.ifpe.oxefoodaldenis.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Entregador")
@Where(clause = "habilitado = true")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Entregador extends EntidadeAuditavel {

	private static final long serialVersionUID = -2212448270757863984L;
	
	@NotNull
	@Column
	private String chaveEmpresa;
	
	@Column
	private String nome;
	
	@NotNull
	@Column
	private String cpf;
	
	@Column
	private String rg;
	
	@Column
	private String endereco;
	
	@Column
	private int qtdEntregasRealizadas;
	
	@Column
	private double valorFrete;
	
	public void updateFrom(Entregador param) {
		this.setChaveEmpresa(param.getChaveEmpresa());
		this.setNome(param.getNome());
		this.setCpf(param.getCpf());
		this.setRg(param.getRg());
		this.setEndereco(param.getEndereco());
		this.setQtdEntregasRealizadas(param.qtdEntregasRealizadas);
		this.setValorFrete(param.valorFrete);
	}

}
