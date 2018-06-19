package com.holiday.agentApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.holiday.agentApp.client.RatingClient;

@Configuration
public class RatingConfig {

	@Bean
	public RatingClient ratingClient(Jaxb2Marshaller marshaller) {
		RatingClient client = new RatingClient();
		client.setDefaultUri("http://localhost:1111/Service/RatingWebService");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
