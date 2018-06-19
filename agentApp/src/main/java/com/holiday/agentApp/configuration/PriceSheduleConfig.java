package com.holiday.agentApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.holiday.agentApp.client.PriceScheduleClient;

@Configuration
public class PriceSheduleConfig {

	@Bean
	public PriceScheduleClient priceScheduleClient(Jaxb2Marshaller marshaller){
		PriceScheduleClient client=new PriceScheduleClient();
		client.setDefaultUri("http://localhost:1111/Service/ServiceWebService");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
