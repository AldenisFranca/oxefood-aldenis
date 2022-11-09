package br.com.ifpe.oxefoodaldenis.modelo.cliente;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ifpe.oxefoodaldenis.util.entity.GenericService;

public class ClienteService extends GenericService {
	@Autowired
    private ClienteRepository repository;

    @Transactional
    public Cliente save(Cliente cliente) {
    	
    	super.preencherCamposAuditoria(cliente);
    	return repository.save(cliente);
    }
    
    @Transactional
    public Cliente obterClientePorID(Long id) {

    return repository.findById(id).get();
    }
    
    @Transactional
    public void update(Long id, Cliente clienteAlterado) {
	
	 Cliente cliente = this.obterClientePorID(id);
	 cliente.updateFrom(clienteAlterado);
	 super.preencherCamposAuditoria(cliente);

	 repository.save(cliente);
    }
    
    @Transactional
    public void delete(Long id) {

	Cliente cliente = this.obterClientePorID(id);
	cliente.setHabilitado(Boolean.FALSE);
	super.preencherCamposAuditoria(cliente);

	repository.save(cliente);
    }
    
}
