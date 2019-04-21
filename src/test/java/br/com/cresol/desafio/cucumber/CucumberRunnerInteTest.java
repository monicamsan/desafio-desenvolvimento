package br.com.cresol.desafio.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
/**
 * @author Fernando Estrela
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber", "json:target/cucumber/cucumber.json" }, snippets = SnippetType.CAMELCASE)
public class CucumberRunnerInteTest {

}

