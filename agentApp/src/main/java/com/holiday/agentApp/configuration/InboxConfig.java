package com.holiday.agentApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.holiday.agentApp.client.InboxClient;

@Configuration
public class InboxConfig {

	@Bean
	public InboxClient inboxClient(Jaxb2Marshaller marshaller) {
		InboxClient client = new InboxClient();
		client.setDefaultUri("http://localhost:1111/Service/InboxWebService");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
