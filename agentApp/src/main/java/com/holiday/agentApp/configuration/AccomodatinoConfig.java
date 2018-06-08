package com.holiday.agentApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.holiday.agentApp.client.AccomodationClient;

@Configuration
public class AccomodatinoConfig {


	@Bean
	public AccomodationClient accomodationClient(Jaxb2Marshaller marshaller) {
		AccomodationClient client = new AccomodationClient();
		client.setDefaultUri("http://localhost:1111/Service/AccomodationWebService");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
