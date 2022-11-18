package br.com.ifpe.oxefoodaldenis.servicos.entregador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefoodaldenis.modelo.entregador.Entregador;
import br.com.ifpe.oxefoodaldenis.modelo.entregador.EntregadorService;
import br.com.ifpe.oxefoodaldenis.util.entity.GenericController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/entregador")
public class EntregadorController extends GenericController {

	@Autowired
    private EntregadorService entregadorService;

	@ApiOperation(value = "Serviço responsável por cadastrar um novo entregador no sistema.")
    @PostMapping
    public ResponseEntity<Entregador> save(@RequestBody @Valid EntregadorRequest request) {
	
    Entregador entregadorSalvo = entregadorService.save(request.buildEntregador());
	return new ResponseEntity<Entregador>(entregadorSalvo, HttpStatus.CREATED);
    }
    
    @ApiOperation(value = "Serviço responsável por obter um entregador referente ao Id passado na URL.")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Retorna o entregador."),
			@ApiResponse(code = 401, message = "Acesso não autorizado."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
			@ApiResponse(code = 404, message = "Não foi encontrado um registro para o Id informado."),
			@ApiResponse(code = 500, message = "Foi gerado um erro no servidor."), })

	@GetMapping("/{id}")
	public Entregador obterEntregadorPorID(@PathVariable Long id) {

		return entregadorService.obterEntregadorPorID(id);
	}

	@ApiOperation(value = "Serviço responsável por obter uma lista de entregadores da empresa passado na URL.")
	@GetMapping("/porempresa/{chaveEmpresa}")
	public List<Entregador> consultarPorChaveEmpresa(@PathVariable String chaveEmpresa) {

		return entregadorService.consultarPorChaveEmpresa(chaveEmpresa);
	}
	
	@ApiOperation(value = "Serviço responsável por obter uma lista de todos os entregadores cadastrados.")
	@GetMapping("/entregadores")
	public List<Entregador> consultarEntregadores() {

		return entregadorService.consultarEntregadores();
	}
    
    @PutMapping("/{id}")
    @ApiOperation(value = "Serviço responsável por atualizar as informações do entregador no sistema.")
    public ResponseEntity<Entregador> update(@PathVariable("id") Long id, @RequestBody EntregadorRequest request) {

    	entregadorService.update(id, request.buildEntregador());
		return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Rota responsável por remover (exclusão lógica) um entregador do sistema.")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

    	 entregadorService.delete(id);
		 return ResponseEntity.noContent().build();
    }
	
}
