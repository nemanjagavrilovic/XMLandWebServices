package com.holiday.agentApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.holiday.agentApp.client.ArrangmentClient;

@Configuration
public class ArrangmentConfig {


	@Bean
	public ArrangmentClient arrangmentClient(Jaxb2Marshaller marshaller) {
		ArrangmentClient client = new ArrangmentClient();
		client.setDefaultUri("http://localhost:1111/Service/ArrangmentsWebService");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
