package com.holiday.agentApp.client;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.holiday.agentApp.requestAndResponse.LocationByIdResponse;
import com.holiday.agentApp.requestAndResponse.LocationRequest;
import com.holiday.agentApp.requestAndResponse.LocationResponse;


public class LocationClient extends WebServiceGatewaySupport {

	public JAXBElement<LocationResponse> getAllLocations(){
		
		LocationRequest request=new LocationRequest();
		@SuppressWarnings("unchecked")
		JAXBElement<LocationResponse> response = (JAXBElement<LocationResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/LocationWebService?wsdl",
						request,
						new SoapActionCallback("http://webService.projekat.xml/findAll"));

		return response;

	}
	
public JAXBElement<LocationByIdResponse> findByIdLocation(){
		
		LocationRequest request=new LocationRequest();
		@SuppressWarnings("unchecked")
		JAXBElement<LocationByIdResponse> response = (JAXBElement<LocationByIdResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/LocationWebService?wsdl",
						request,
						new SoapActionCallback("http://webService.projekat.xml/findById"));

		return response;

	}
}
