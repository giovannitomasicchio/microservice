package it.giovannitomasicchio.microservice.events;

import it.giovannitomasicchio.microservice.jpa.etities.Post;

public class PostCreatedEvent {

	private final Post post;
	
	public PostCreatedEvent(Post post) {
		this.post = post;
	}

	public Post getPost() {
		return post;
	}	
}
