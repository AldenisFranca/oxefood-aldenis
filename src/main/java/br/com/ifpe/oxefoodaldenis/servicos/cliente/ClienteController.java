package br.com.ifpe.oxefoodaldenis.servicos.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.ifpe.oxefoodaldenis.modelo.cliente.Cliente;
import br.com.ifpe.oxefoodaldenis.modelo.cliente.ClienteService;
import br.com.ifpe.oxefoodaldenis.util.entity.GenericController;

public class ClienteController extends GenericController {
	
	@Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteRequest request) {
	
	Cliente clienteSalvo = clienteService.save(request.buildCliente());
	return new ResponseEntity<Cliente>(clienteSalvo, HttpStatus.CREATED);
    }
    
}
