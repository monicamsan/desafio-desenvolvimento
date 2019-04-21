package br.com.cresol.desafio.cucumber;

import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.cresol.desafio.DesafioApplicationTest;
import br.com.cresol.desafio.converter.EntityDtoConverter;
import br.com.cresol.desafio.dto.ClienteDTO;
import br.com.cresol.desafio.dto.ContratarEmprestimoDTO;
import br.com.cresol.desafio.dto.ParcelaEmprestimoDTO;
import br.com.cresol.desafio.dto.SimulacaoEmprestimoDTO;
import br.com.cresol.desafio.entity.Cliente;
import br.com.cresol.desafio.entity.ContratarEmprestimo;
import br.com.cresol.desafio.entity.ParcelaEmprestimo;
import br.com.cresol.desafio.entity.SimularEmprestimo;
import br.com.cresol.desafio.service.ClienteService;
import br.com.cresol.desafio.service.ContratarEmprestimoService;
import br.com.cresol.desafio.service.ParcelaEmprestimoService;
import br.com.cresol.desafio.service.SimularEmprestimoService;
/**
 * @author Fernando Estrela
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = DesafioApplicationTest.class)
public abstract class SpringStep extends RestTemplateUtilTest {

	@Autowired
	protected ClienteService clienteService;
	@Autowired
	private SimularEmprestimoService simularEmprestimoService;
	@Autowired
	protected ContratarEmprestimoService contratarEmprestimoService;
	@Autowired
	protected ParcelaEmprestimoService parcelaEmprestimoService;
	
	protected SimularEmprestimo simularEmprestimo;
	protected Cliente cliente;
	protected ContratarEmprestimo contratarEmprestimo;
	protected ParcelaEmprestimo parcelaEmprestimo;
	
	

	protected void saveClientes(List<ClienteDTO> clientes) {
		clientes.stream().forEach(clienteDto -> this.clienteService.save(new EntityDtoConverter<Cliente>().converterToEntity(new Cliente(), clienteDto)));
	}

	protected void findCliente(Long id) {
		this.cliente = this.clienteService.findById(id);
	}
	
	protected void validaClienteExistente() {
		Assert.assertNotNull(this.cliente);
	}
	
	protected void saveSimularEmprestimo(List<SimulacaoEmprestimoDTO> simulacaoEmprestimoDTOs) {
		simulacaoEmprestimoDTOs.stream().forEach(simu -> this.simularEmprestimoService.save(new EntityDtoConverter<SimularEmprestimo>().converterToEntity(new SimularEmprestimo(), simu)));
	}

	protected void findSimularEmprestimo(Long id) {
		this.simularEmprestimo = this.simularEmprestimoService.findById(id);
	}
	
	protected void validaSimularEmprestimoExistente() {
		Assert.assertNotNull(this.simularEmprestimo);
	}
	
	protected void saveContratarEmprestimo(List<ContratarEmprestimoDTO> contratarEmprestimoDTOs) {
		contratarEmprestimoDTOs.stream().forEach(cont -> this.contratarEmprestimoService.save(new EntityDtoConverter<ContratarEmprestimo>().converterToEntity(new ContratarEmprestimo(), cont)));
	}

	protected void findContratarEmprestimo(Long id) {
		this.contratarEmprestimo = this.contratarEmprestimoService.findById(id);
	}
	
	protected void validaContratarEmprestimo() {
		Assert.assertNotNull(this.contratarEmprestimo);
	}
	
	protected void saveParcelaEmprestimo(List<ParcelaEmprestimoDTO> parcelaEmprestimoDTOs) {
		parcelaEmprestimoDTOs.stream().forEach(par -> this.parcelaEmprestimoService.save(new EntityDtoConverter<ParcelaEmprestimo>().converterToEntity(new ParcelaEmprestimo(), par)));
	}

	protected void findParcelaEmprestimo(Long id) {
		this.parcelaEmprestimo = this.parcelaEmprestimoService.findById(id);
	}
	
	protected void validaParcelaEmprestimo() {
		Assert.assertNotNull(this.parcelaEmprestimo);
	}
}
