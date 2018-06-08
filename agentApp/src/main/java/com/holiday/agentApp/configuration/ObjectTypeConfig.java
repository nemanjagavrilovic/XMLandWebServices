package com.holiday.agentApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.holiday.agentApp.client.ObjectTypeClient;

@Configuration
public class ObjectTypeConfig {

	@Bean
	public ObjectTypeClient objectTypeClient(Jaxb2Marshaller marshaller){
		ObjectTypeClient client=new ObjectTypeClient();
		client.setDefaultUri("http://localhost:1111/Service/ObjectTypeWebService");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		
		return client;
	}
}
