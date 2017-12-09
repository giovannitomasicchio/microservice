package it.giovannitomasicchio.microservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

	private String startupMessage;

	public String getStartupMessage() {
		return startupMessage;
	}

	public void setStartupMessage(String startupMessage) {
		this.startupMessage = startupMessage;
	}
}
