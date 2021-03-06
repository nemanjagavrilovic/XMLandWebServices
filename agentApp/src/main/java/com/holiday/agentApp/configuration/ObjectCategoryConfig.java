package com.holiday.agentApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.holiday.agentApp.client.ObjectCategoryClient;

@Configuration
public class ObjectCategoryConfig {


	@Bean
	public ObjectCategoryClient objectCategoryClient(Jaxb2Marshaller marshaller) {
		ObjectCategoryClient client = new ObjectCategoryClient();
		client.setDefaultUri("http://localhost:1111/Service/ObjectCategoryWebService");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
