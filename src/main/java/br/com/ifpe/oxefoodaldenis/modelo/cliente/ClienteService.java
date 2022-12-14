package br.com.ifpe.oxefoodaldenis.modelo.cliente;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefoodaldenis.modelo.acesso.UsuarioService;
import br.com.ifpe.oxefoodaldenis.util.entity.GenericService;

@Service
public class ClienteService extends GenericService {
	@Autowired
    private ClienteRepository repository;

	@Autowired
    private UsuarioService usuarioService;
	
    @Transactional
    public Cliente save(Cliente cliente) {
    	
    	usuarioService.save(cliente.getUsuario());
    	
    	super.preencherCamposAuditoria(cliente);
    	return repository.save(cliente);
    }
    
    @Transactional
    public Cliente obterClientePorID(Long id) {

    return repository.findById(id).get();
    }
    
    @Transactional
    public List<Cliente> consultarPorChaveEmpresa(String chaveEmpresa) {

	return repository.findByChaveEmpresaOrderByNomeAsc(chaveEmpresa);
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
