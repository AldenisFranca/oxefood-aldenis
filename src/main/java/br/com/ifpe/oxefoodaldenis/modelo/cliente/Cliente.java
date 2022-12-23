package br.com.ifpe.oxefoodaldenis.modelo.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

import br.com.ifpe.oxefoodaldenis.modelo.acesso.Usuario;
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
	
//	public static final String LABEL = "Cliente";
	
	@ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;
	
//	@JsonIgnore
//    @Column(nullable = false)
//    private String chaveEmpresa;
	
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
		this.setUsuario(param.getUsuario());
		this.setChaveEmpresa(param.getChaveEmpresa());
		this.setNome(param.getNome());
		this.setCpf(param.getCpf());
		this.setFone(param.getFone());
		this.setFoneAlternativo(param.getFoneAlternativo());
	}
    
}
