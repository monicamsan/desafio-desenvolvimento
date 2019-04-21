package br.com.cresol.desafio.cucumber;

import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
/**
 * @author Fernando Estrela
 *
 */
public class SampleSteps extends SpringStep {

    private String springJpaHibernateDdlAuto;

    @Dado("^que exista um env valido\\.$")
    public void validaEnv() {
        Assert.assertNotNull(environment);
    }

    @Quando("^quando consultar uma variavel\\.$")
    public void carregaVariaveis() {
    	springJpaHibernateDdlAuto = environment.getProperty("spring.jpa.hibernate.ddl-auto");
    }

    @Entao("^a mesma deve ter valor\\.$")
    public void validaValorVariavel() {
        Assert.assertEquals("update", springJpaHibernateDdlAuto);
    }
}
