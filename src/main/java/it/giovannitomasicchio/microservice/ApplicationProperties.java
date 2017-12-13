package it.giovannitomasicchio.microservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "application")
@Getter @Setter
public class ApplicationProperties {

	private String startupMessage;
	
	private int threadPoolSize;
}
