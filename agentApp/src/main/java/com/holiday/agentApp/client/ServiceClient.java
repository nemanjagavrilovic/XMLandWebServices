package com.holiday.agentApp.client;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.holiday.agentApp.requestAndResponse.ServiceAllRequest;
import com.holiday.agentApp.requestAndResponse.ServiceAllResponse;
import com.holiday.agentApp.requestAndResponse.ServiceByIdRequest;
import com.holiday.agentApp.requestAndResponse.ServiceByIdResponse;

public class ServiceClient extends WebServiceGatewaySupport {

	public JAXBElement<ServiceAllResponse> findAll() {

		ServiceAllRequest request = new ServiceAllRequest();
		@SuppressWarnings("unchecked")
		JAXBElement<ServiceAllResponse> response = (JAXBElement<ServiceAllResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/ServiceWebService?wsdl", request,
						new SoapActionCallback("http://webService.projekat.xml/findAll"));

		return response;

	}

	public JAXBElement<ServiceByIdResponse> findById(Long id) {

		ServiceByIdRequest request = new ServiceByIdRequest();
		request.setId(id);
		@SuppressWarnings("unchecked")
		JAXBElement<ServiceByIdResponse> response = (JAXBElement<ServiceByIdResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/ServiceWebService?wsdl", request,
						new SoapActionCallback("http://webService.projekat.xml/findById"));

		return response;

	}
}
