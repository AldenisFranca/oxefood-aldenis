package br.com.ifpe.oxefoodaldenis.modelo.entregador;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefoodaldenis.util.entity.GenericService;

@Service
public class EntregadorService extends GenericService {
	
	@Autowired
    private EntregadorRepository repository;

    @Transactional
    public Entregador save(Entregador entregador) {
    	
    	super.preencherCamposAuditoria(entregador);
    	return repository.save(entregador);
    }
    
    @Transactional
    public Entregador obterEntregadorPorID(Long id) {

    return repository.findById(id).get();
    }
    
    @Transactional
    public List<Entregador> consultarPorChaveEmpresa(String chaveEmpresa) {

	return repository.findByChaveEmpresaOrderByNomeAsc(chaveEmpresa);
    }
    
    @Transactional
    public List<Entregador> consultarEntregadores() {

    return repository.findByEntregadores();
    }
    
    @Transactional
    public void update(Long id, Entregador entregadorAlterado) {
	
     Entregador entregador = this.obterEntregadorPorID(id);
     entregador.updateFrom(entregadorAlterado);
	 super.preencherCamposAuditoria(entregador);

	 repository.save(entregador);
    }
    
    @Transactional
    public void delete(Long id) {

    Entregador entregador = this.obterEntregadorPorID(id);
    entregador.setHabilitado(Boolean.FALSE);
	super.preencherCamposAuditoria(entregador);

	repository.save(entregador);
    }

}
