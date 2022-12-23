package br.com.ifpe.oxefoodaldenis.servicos.cliente;

import java.util.Arrays;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.ifpe.oxefoodaldenis.modelo.acesso.Usuario;
import br.com.ifpe.oxefoodaldenis.modelo.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {
	
	@NotBlank(message = "O e-mail é de preenchimento obrigatório")
    @Email
    private String email;

    @NotBlank(message = "A senha é de preenchimento obrigatório")
    private String password;

	private String chaveEmpresa;

	private String nome;

	private String cpf;

	private String fone;

	private String foneAlternativo;

	 public Usuario buildUsuario() {
			
		return Usuario.builder()
			.username(email)
			.password(password)
			.roles(Arrays.asList(Usuario.ROLE_CLIENTE))
			.build();
	 }
	
	public Cliente buildCliente() {

		return Cliente.builder()
				.chaveEmpresa(chaveEmpresa)
				.usuario(buildUsuario())
				.nome(nome)
				.cpf(cpf)
				.fone(fone)
				.foneAlternativo(foneAlternativo)
				.build();
	}

}
