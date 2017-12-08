package it.giovannitomasicchio.microservice.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.json.JsonContentAssert;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import it.giovannitomasicchio.microservice.jpa.etities.Post;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PostControlerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	 @Test
	 public void byjpanamedquery() throws Exception {
		 String post = restTemplate.getForObject("/posts/byjpanamedquery/1", String.class);
		 assertThat((new JsonContentAssert(Post.class, post)).extractingJsonPathNumberValue("$.id").isEqualTo(1));
	 }
}
