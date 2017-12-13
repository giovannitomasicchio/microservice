package it.giovannitomasicchio.microservice.dto;

import lombok.Value;

@Value
public class AuthorStatsDTO {

	public Long id;
	
	public String name;
	
	public Long postCount;
}
