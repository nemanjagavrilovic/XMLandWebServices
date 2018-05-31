package com.holiday.agentApp.configuration;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.holiday.agentApp.repository.AccomodationRepository;
import com.holiday.agentApp.webService.AccomodationWebServiceImpl;
import com.holiday.agentApp.webService.SyncServiceImpl;



@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;
	
	@Autowired
	private AccomodationRepository accomodationRepository;
	@Bean
	public Endpoint accomodationService(){
	      EndpointImpl endpoint = new EndpointImpl(bus, new AccomodationWebServiceImpl(accomodationRepository));
	        endpoint.publish("/AccomodationWebService");
	        return endpoint;
	  
	}
	@Bean
	public Endpoint syncService(){
	      EndpointImpl endpoint = new EndpointImpl(bus, new SyncServiceImpl());
	        endpoint.publish("/SyncService");
	        return endpoint;
	  
	}
}
