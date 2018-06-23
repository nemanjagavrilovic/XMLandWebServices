package com.holiday.agentApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.holiday.agentApp.client.CommentClient;

@Configuration
public class CommentConfig {

	@Bean
	public CommentClient commentClient(Jaxb2Marshaller marshaller){
		CommentClient client=new CommentClient();
		client.setDefaultUri("http://localhost:1111/Service/CommentWebService");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
