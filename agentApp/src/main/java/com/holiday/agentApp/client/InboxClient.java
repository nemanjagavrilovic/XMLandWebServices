package com.holiday.agentApp.client;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.holiday.agentApp.model.TUser;
import com.holiday.agentApp.requestAndResponse.InboxAllRequest;
import com.holiday.agentApp.requestAndResponse.InboxAllResponse;
import com.holiday.agentApp.requestAndResponse.InboxByIdRequest;
import com.holiday.agentApp.requestAndResponse.InboxByIdResponse;
import com.holiday.agentApp.requestAndResponse.InboxReceiverRequest;
import com.holiday.agentApp.requestAndResponse.InboxReceiverResponse;

public class InboxClient extends WebServiceGatewaySupport {

	public JAXBElement<InboxAllResponse> getAllInboxes() {

		InboxAllRequest request = new InboxAllRequest();
		@SuppressWarnings("unchecked")
		JAXBElement<InboxAllResponse> response = (JAXBElement<InboxAllResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/InboxWebService?wsdl", request,
						new SoapActionCallback("http://webService.projekat.xml/findAll"));

		return response;

	}
	public JAXBElement<InboxByIdResponse> findById(Long id) {

		InboxByIdRequest request = new InboxByIdRequest();
		request.setId(id);
		@SuppressWarnings("unchecked")
		JAXBElement<InboxByIdResponse> response = (JAXBElement<InboxByIdResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/InboxWebService?wsdl", request,
						new SoapActionCallback("http://webService.projekat.xml/findById"));

		return response;

	}
	public JAXBElement<InboxReceiverResponse> findByReceiver(TUser user) {

		InboxReceiverRequest request = new InboxReceiverRequest();
		request.setReceiver(user);
		@SuppressWarnings("unchecked")
		JAXBElement<InboxReceiverResponse> response = (JAXBElement<InboxReceiverResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/InboxWebService?wsdl", request,
						new SoapActionCallback("http://webService.projekat.xml/findByReceiver"));

		return response;

	}
	
	
}
