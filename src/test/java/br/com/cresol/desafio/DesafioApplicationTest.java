package br.com.cresol.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import ch.qos.logback.core.util.SystemInfo;
/**
 * @author Fernando Estrela
 *
 */
@SpringBootApplication
@Profile("test")
@Import({SystemInfo.class})
public class DesafioApplicationTest extends SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DesafioApplicationTest.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DesafioApplicationTest.class, args);
    }

}
