package it.giovannitomasicchio.microservice.events.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import it.giovannitomasicchio.microservice.events.PostCreatedEvent;

@Component
public class PostEventsListener {

	private static final Logger logger = LoggerFactory.getLogger(PostEventsListener.class);
	
	@TransactionalEventListener
	public void onCreateSync(PostCreatedEvent event) {
		logger.info("PostEventsListener.onCreateSync for post " + event.getPost().getId()); 
	}
	
	@Async
	@TransactionalEventListener
	public void onCreateAsync(PostCreatedEvent event) {
		logger.info("PostEventsListener.onCreateAsync for post " + event.getPost().getId());
	}
}
