package com.holiday.agentApp.client;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.holiday.agentApp.requestAndResponse.ArrangmentAllRequest;
import com.holiday.agentApp.requestAndResponse.ArrangmentAllResponse;
import com.holiday.agentApp.requestAndResponse.ArrangmentUpdateRequest;
import com.holiday.agentApp.requestAndResponse.ArrangmentUpdateResponse;

public class ArrangmentClient extends WebServiceGatewaySupport {

	public JAXBElement<ArrangmentAllResponse> findAll(){
		ArrangmentAllRequest request = new ArrangmentAllRequest();
		@SuppressWarnings("unchecked")
		JAXBElement<ArrangmentAllResponse> response = (JAXBElement<ArrangmentAllResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/ArrangmentsWebService?wsdl", request,
						new SoapActionCallback("http://webService.projekat.xml/findAll"));

		return response;

	}
	

	public JAXBElement<ArrangmentUpdateResponse> update(boolean realized,Long id){
		ArrangmentUpdateRequest request = new ArrangmentUpdateRequest();
		request.setId(id);
		request.setRealized(realized);
		@SuppressWarnings("unchecked")
		JAXBElement<ArrangmentUpdateResponse> response = (JAXBElement<ArrangmentUpdateResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/ArrangmentsWebService?wsdl", request,
						new SoapActionCallback("http://webService.projekat.xml/update"));

		return response;

	}
}
