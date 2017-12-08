package it.giovannitomasicchio.microservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@SpringBootApplication
public class MicroserviceApplication implements ApplicationListener<ContextRefreshedEvent> {
	
	@Bean
	public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
		Jackson2ObjectMapperBuilder omb = new Jackson2ObjectMapperBuilder();
		// Per evitare che jackson acceda agli oggetti lazy
		omb.modulesToInstall(new Hibernate5Module());
		omb.indentOutput(true);
		return omb;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// eventuale codice da eseguire dopo il refresh del context di Spring
	}
}
