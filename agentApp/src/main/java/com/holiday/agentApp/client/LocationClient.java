package com.holiday.agentApp.client;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.holiday.agentApp.usage.FindAllRequest;
import com.holiday.agentApp.usage.FindAllResponse;
import com.holiday.agentApp.usage.FindByIdRequest;
import com.holiday.agentApp.usage.FindByIdResponse;


public class LocationClient extends WebServiceGatewaySupport {

	public JAXBElement<FindAllResponse> getAllLocations(){
		
		FindAllRequest request=new FindAllRequest();
		@SuppressWarnings("unchecked")
		JAXBElement<FindAllResponse> response = (JAXBElement<FindAllResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/LocationWebService?wsdl",
						request,
						new SoapActionCallback("http://webService.projekat.xml/findAll"));

		return response;

	}
	public JAXBElement<FindByIdResponse> findById(Long id){
		
		FindByIdRequest request=new FindByIdRequest();
		request.setId(id);
		@SuppressWarnings("unchecked")
		JAXBElement<FindByIdResponse> response = (JAXBElement<FindByIdResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/LocationWebService?wsdl",
						request,
						new SoapActionCallback("http://webService.projekat.xml/findById"));

		return response;

	}
	
}
