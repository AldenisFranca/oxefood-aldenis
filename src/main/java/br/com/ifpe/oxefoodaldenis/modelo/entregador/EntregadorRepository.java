package br.com.ifpe.oxefoodaldenis.modelo.entregador;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface EntregadorRepository extends JpaRepository<Entregador, Long>, JpaSpecificationExecutor<Entregador> {
	
	List<Entregador> findByChaveEmpresaOrderByNomeAsc(String chaveEmpresa);
	
	@Query(value = "SELECT e FROM Entregador e")
	List<Entregador> findByEntregadores();

}
