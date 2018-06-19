package com.holiday.agentApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.holiday.agentApp.client.PriceClient;

@Configuration
public class PriceConfig {

	@Bean
	public PriceClient priceClient(Jaxb2Marshaller marshaller){
		PriceClient client=new PriceClient();
		client.setDefaultUri("http://localhost:1111/Service/PriceWebService");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
