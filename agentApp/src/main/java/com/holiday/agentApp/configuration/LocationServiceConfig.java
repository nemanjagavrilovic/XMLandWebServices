package com.holiday.agentApp.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.holiday.agentApp.client.LocationClient;

@Configuration
public class LocationServiceConfig {

	@Bean
	public Jaxb2Marshaller locationMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.holiday.agentApp.requestAndResponse");
		
		return marshaller;
	}

	
	@Bean
	public LocationClient locationClient(Jaxb2Marshaller marshaller) {
		LocationClient client = new LocationClient();
		client.setDefaultUri("http://localhost:1111/Service/LocationWebService");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
