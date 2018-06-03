package com.holiday.agentApp.client;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class ObjectCategoryClient extends WebServiceGatewaySupport {

/*	public JAXBElement<FindByIdResponse> findByIdObject(Long id) {

		FindByIdRequest request = new FindByIdRequest();
		request.setId(id);
		@SuppressWarnings("unchecked")
		JAXBElement<FindByIdResponse> response = (JAXBElement<FindByIdResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/ObjectCategoryWebService?wsdl", request,
						new SoapActionCallback("http://webService.projekat.xml/findById"));

		return response;

	}
	public JAXBElement<FindAllResponse> findAll() {

		FindByIdRequest request = new FindByIdRequest();
		@SuppressWarnings("unchecked")
		JAXBElement<FindAllResponse> response = (JAXBElement<FindAllResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/ObjectCategoryWebService?wsdl", request,
						new SoapActionCallback("http://webService.projekat.xml/findAll"));

		return response;

	}*/
}
