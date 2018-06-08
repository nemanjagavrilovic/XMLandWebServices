package com.holiday.agentApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.holiday.agentApp.client.ServiceClient;
@Configuration
public class ServiceConfig {

	@Bean
	public ServiceClient serviceClient(Jaxb2Marshaller marshaller) {
		ServiceClient client = new ServiceClient();
		client.setDefaultUri("http://localhost:1111/Service/ServiceWebService");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
