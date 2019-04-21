package br.com.cresol.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cresol.desafio.converter.EntityDtoConverter;
import br.com.cresol.desafio.dto.SimulacaoEmprestimoResponse;
import br.com.cresol.desafio.dto.SimularEmprestimoPayload;
import br.com.cresol.desafio.service.SimularEmprestimoService;

/**
 * @author Fernando Estrela
 *
 */
@RestController
@RequestMapping("/api/emprestimo/simulacao")
public class EmprestimoResourceController {
	
	@Autowired
	private SimularEmprestimoService simularEmprestimoService;

	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SimulacaoEmprestimoResponse> simular(@RequestBody SimularEmprestimoPayload payload) {	
		return ResponseEntity.status(HttpStatus.OK).body(new EntityDtoConverter<SimulacaoEmprestimoResponse>().build(true).converterToDTO(new SimulacaoEmprestimoResponse() , this.simularEmprestimoService.simularEmprestimo(payload)));
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity<SimulacaoEmprestimoResponse> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(new EntityDtoConverter<SimulacaoEmprestimoResponse>().build(true).converterToDTO(new SimulacaoEmprestimoResponse(), this.simularEmprestimoService.findById(id)) );
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.simularEmprestimoService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping(path = "/contrato/{numeroContrato}")
	public ResponseEntity<SimulacaoEmprestimoResponse> findByContrato(@PathVariable String numeroContrato) {
		return ResponseEntity.status(HttpStatus.OK).body(new EntityDtoConverter<SimulacaoEmprestimoResponse>().build(true).converterToDTO(new SimulacaoEmprestimoResponse(), this.simularEmprestimoService.findByContrato(numeroContrato)) );
	}
    //EndPoint não especificado na documentação, emplementação da regra "As simulações de empréstimo possuem um período de validade de 30 dias. Após este período não será possível efetivar a contratação."
	@PutMapping(path = "/contrato/{numeroContrato}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SimulacaoEmprestimoResponse> efetivar(@PathVariable String numeroContrato) {
		return ResponseEntity.status(HttpStatus.OK).body(new EntityDtoConverter<SimulacaoEmprestimoResponse>().build(true).converterToDTO(new SimulacaoEmprestimoResponse() , this.simularEmprestimoService.efetivarEmprestimo(numeroContrato)));
	}

}
