package br.com.ifpe.oxefoodaldenis.modelo.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.ifpe.oxefoodaldenis.modelo.produto.CategoriaProduto;

public interface ClienteRepository extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {
	
	List<Cliente> findByChaveEmpresaOrderByNomeAsc(String chaveEmpresa);
	
}
