package br.com.cresol.desafio.cucumber.integracao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import br.com.cresol.desafio.cucumber.SpringStep;
import br.com.cresol.desafio.dto.SimulacaoEmprestimoResponse;
import br.com.cresol.desafio.dto.SimularEmprestimoPayload;

public class IntegracaoRest extends SpringStep{
	
	protected SimularEmprestimoPayload payload;
	protected SimulacaoEmprestimoResponse response;
	protected SimulacaoEmprestimoResponse responseEsperado;
	protected static final String PATH_SIMULACAO = "/api/emprestimo/simulacao";
	
	protected SimulacaoEmprestimoResponse simularEmprestimo(SimularEmprestimoPayload payload){
        Map<String, String> parameters = new HashMap<String, String>();
        HttpEntity<SimularEmprestimoPayload> entity = new HttpEntity<SimularEmprestimoPayload>(payload);
        String uri = buildURL(PATH_SIMULACAO);
        ResponseEntity<SimulacaoEmprestimoResponse> response = restTemplate.exchange(uri, HttpMethod.POST, entity, SimulacaoEmprestimoResponse.class, parameters);
        return response.getBody();
	 }
	
	protected ResponseEntity<Void> deletarSimulacaoEmprestimo(Long  id){
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("id", id.toString());
        String uri = buildURL(PATH_SIMULACAO,"/{id}");
        ResponseEntity<Void> response = restTemplate.exchange(uri, HttpMethod.DELETE,  null, Void.class,parameters);
        return response;
	 }
	
	protected SimulacaoEmprestimoResponse getSimulacaoEmprestimo(Long  id){
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("id", id.toString());
        String uri = buildURL(PATH_SIMULACAO,"/{id}");
        ResponseEntity<SimulacaoEmprestimoResponse> response = restTemplate.exchange(uri, HttpMethod.GET,  null, SimulacaoEmprestimoResponse.class,parameters);
        return response.getBody();
	 }

}
