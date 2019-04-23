package br.com.cresol.desafio.cucumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.client.TestRestTemplate.HttpClientOption;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

/**
 * @author Fernando Estrela
 *
 */
public class RestTemplateUtilTest {

	protected static final String HOST = "http://localhost:";

    @Autowired
    protected Environment environment;

    protected RestTemplate restTemplate = new TestRestTemplate("user", "password", HttpClientOption.ENABLE_COOKIES).getRestTemplate();

    protected String getMainURL() {
        String contextPath = "/desafio-desenvolvimento";
        Integer port = Integer.parseInt(environment.getProperty("local.server.port"));
        return new StringBuilder(HOST).append(port).append(contextPath).toString();
    }

    protected String buildURL(String... paths) {
        StringBuilder pathBuilder = new StringBuilder(getMainURL());
        for (String path : paths) {
            pathBuilder.append(path);
        }
        return pathBuilder.toString();
    }
    
  
}
