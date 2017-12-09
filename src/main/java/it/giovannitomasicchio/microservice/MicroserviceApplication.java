package it.giovannitomasicchio.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@SpringBootApplication
public class MicroserviceApplication implements ApplicationListener<ApplicationReadyEvent> {
	
	@Autowired
	ApplicationProperties applicationProperties;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MicroserviceApplication.class, args);
	}
	
	@Bean
	public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
		Jackson2ObjectMapperBuilder omb = new Jackson2ObjectMapperBuilder();
		// Per evitare che jackson acceda agli oggetti lazy
		omb.modulesToInstall(new Hibernate5Module());
		omb.indentOutput(true);
		return omb;
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		System.out.println(applicationProperties.getStartupMessage());
	}
}
