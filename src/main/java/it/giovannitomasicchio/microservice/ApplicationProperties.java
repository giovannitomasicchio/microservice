package it.giovannitomasicchio.microservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

	private String startupMessage;
	
	private int threadPoolSize;

	public String getStartupMessage() {
		return startupMessage;
	}

	public void setStartupMessage(String startupMessage) {
		this.startupMessage = startupMessage;
	}

	public int getThreadPoolSize() {
		return threadPoolSize;
	}

	public void setThreadPoolSize(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
	}
}
