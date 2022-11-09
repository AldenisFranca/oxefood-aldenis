package br.com.ifpe.oxefoodaldenis.modelo.cliente;

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
@Table(name = "Cliente")
@Where(clause = "habilitado = true")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends EntidadeAuditavel{
	
	private static final long serialVersionUID = -5738325130977323124L;
	
	@NotNull
	@Column
	private String chaveEmpresa;
	
	@Column
	private String nome;
	
	@Column
	private String cpf;
	
	@Column
	private String fone;
	
	@Column
	private String foneAlternativo;
	
	public void updateFrom(Cliente param) {
    	this.setNome(param.getNome());
    }
    
}
