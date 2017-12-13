package it.giovannitomasicchio.microservice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PostControlerTest {
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	
	@Autowired
	private MockMvc mockMvc;
	
	 @Test
	 public void byjpanamedquery() throws Exception {
		 mockMvc.perform(get("/posts/byjpanamedquery/1001")).andExpect(status().isOk());
	 }
	 
	 @Test
	 public void createPost() throws Exception {
		String postJson = "{" + 
				"  \"data\" : [ 2017, 01, 01, 10, 1, 12 ]," + 
				"  \"author\" : {" + 
				"    \"id\" : 1001" +  
				"  }," + 
				"  \"postDetail\" : {" + 
				"    \"body\" : \"Testo del post\"," + 
				"    \"title\" : \"Titolo del post\"" + 
				"  }" + 
				"}";

		 mockMvc.perform(post("/posts/").contentType(contentType).content(postJson)).andExpect(status().isCreated());
	 }
}
