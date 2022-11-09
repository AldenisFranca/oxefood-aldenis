package br.com.ifpe.oxefoodaldenis.servicos.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefoodaldenis.modelo.cliente.Cliente;
import br.com.ifpe.oxefoodaldenis.modelo.cliente.ClienteService;
import br.com.ifpe.oxefoodaldenis.util.entity.GenericController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController extends GenericController {
	
	@Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteRequest request) {
	
	Cliente clienteSalvo = clienteService.save(request.buildCliente());
	return new ResponseEntity<Cliente>(clienteSalvo, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    @ApiOperation(value = "Serviço responsável por atualizar as informações do cliente no sistema.")
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody ClienteRequest request) {

	clienteService.update(id, request.buildCliente());
	return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Rota responsável por remover(exclusão lógica) um cliente do sistema.")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

	 clienteService.delete(id);
	 return ResponseEntity.noContent().build();
    }
    
}