package com.holiday.agentApp.client;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.holiday.agentApp.requestAndResponse.ObjectCategoryAllRequest;
import com.holiday.agentApp.requestAndResponse.ObjectCategoryAllResponse;
import com.holiday.agentApp.requestAndResponse.ObjectCategoryByIdRequest;
import com.holiday.agentApp.requestAndResponse.ObjectCategoryByIdResponse;


public class ObjectCategoryClient extends WebServiceGatewaySupport{

	public JAXBElement<ObjectCategoryAllResponse> findAll(){
		ObjectCategoryAllRequest request=new ObjectCategoryAllRequest();
		@SuppressWarnings("unchecked")
		JAXBElement<ObjectCategoryAllResponse> response = (JAXBElement<ObjectCategoryAllResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/ObjectCategoryWebService?wsdl",
						request,
						new SoapActionCallback("http://webService.projekat.xml/findAll"));

		return response;
	}
	
	public JAXBElement<ObjectCategoryByIdResponse> findById(Long id){
		ObjectCategoryByIdRequest request=new ObjectCategoryByIdRequest();
		request.setId(id);
		@SuppressWarnings("unchecked")
		JAXBElement<ObjectCategoryByIdResponse> response = (JAXBElement<ObjectCategoryByIdResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/ObjectCategoryWebService?wsdl",
						request,
						new SoapActionCallback("http://webService.projekat.xml/findById"));

		return response;
	}
}
