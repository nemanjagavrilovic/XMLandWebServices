package com.holiday.agentApp.client;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.holiday.agentApp.requestAndResponse.ObjectTypeAllRequest;
import com.holiday.agentApp.requestAndResponse.ObjectTypeAllResponse;
import com.holiday.agentApp.requestAndResponse.ObjectTypeByIdRequest;
import com.holiday.agentApp.requestAndResponse.ObjectTypeByIdResponse;

public class ObjectTypeClient extends WebServiceGatewaySupport{
	public JAXBElement<ObjectTypeAllResponse> findAll(){
		ObjectTypeAllRequest request=new ObjectTypeAllRequest();
		@SuppressWarnings("unchecked")
		JAXBElement<ObjectTypeAllResponse> response = (JAXBElement<ObjectTypeAllResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/ObjectTypeWebService?wsdl",
						request,
						new SoapActionCallback("http://webService.projekat.xml/findAll"));

		return response;
	}
	public JAXBElement<ObjectTypeByIdResponse> findById(Long id){
		ObjectTypeByIdRequest request=new ObjectTypeByIdRequest();
		request.setId(id);
		@SuppressWarnings("unchecked")
		JAXBElement<ObjectTypeByIdResponse> response = (JAXBElement<ObjectTypeByIdResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/ObjectTypeWebService?wsdl",
						request,
						new SoapActionCallback("http://webService.projekat.xml/findById"));

		return response;
	}
}
