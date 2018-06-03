package com.holiday.agentApp.client;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.holiday.agentApp.requestAndResponse.UserByIdRequest;
import com.holiday.agentApp.requestAndResponse.UserByIdResponse;

public class UserClient extends WebServiceGatewaySupport {
	public JAXBElement<UserByIdResponse> userById(Long id) {

		UserByIdRequest request = new UserByIdRequest();
		request.setId(id);
		@SuppressWarnings("unchecked")
		JAXBElement<UserByIdResponse> response = (JAXBElement<UserByIdResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/UserWebService?wsdl", request,
						new SoapActionCallback("http://webService.projekat.xml/findById"));

		return response;

	}
}
