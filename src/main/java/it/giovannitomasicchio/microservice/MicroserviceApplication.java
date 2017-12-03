package it.giovannitomasicchio.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@SpringBootApplication
public class MicroserviceApplication {

	@Autowired
	Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder;
	
	@Bean
	public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
		Jackson2ObjectMapperBuilder omb = new Jackson2ObjectMapperBuilder();
		// Per evitare che jackson acceda agli oggetti lazy
		omb.modulesToInstall(Hibernate5Module.class);
		omb.simpleDateFormat("yyyy-mm-dd").indentOutput(true);
		return omb;
	}
}
