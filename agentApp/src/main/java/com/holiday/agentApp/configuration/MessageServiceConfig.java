package com.holiday.agentApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.holiday.agentApp.client.MessageClient;
@Configuration
public class MessageServiceConfig {

	@Bean
	public MessageClient messageClient(Jaxb2Marshaller marshaller) {
		MessageClient client = new MessageClient();
		client.setDefaultUri("http://localhost:1111/Service/MessageWebService");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
