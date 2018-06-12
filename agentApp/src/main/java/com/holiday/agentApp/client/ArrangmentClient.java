package com.holiday.agentApp.client;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.holiday.agentApp.model.Arrangment;
import com.holiday.agentApp.requestAndResponse.ArrangmentAllRequest;
import com.holiday.agentApp.requestAndResponse.ArrangmentAllResponse;
import com.holiday.agentApp.requestAndResponse.ArrangmentFindByAccOwnerRequest;
import com.holiday.agentApp.requestAndResponse.ArrangmentFindByAccOwnerResponse;
import com.holiday.agentApp.requestAndResponse.ArrangmentFindRequest;
import com.holiday.agentApp.requestAndResponse.ArrangmentFindResponse;
import com.holiday.agentApp.requestAndResponse.ArrangmentSaveRequest;
import com.holiday.agentApp.requestAndResponse.ArrangmentSaveResponse;
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
	public JAXBElement<ArrangmentSaveResponse> save(Arrangment arrangment){
		ArrangmentSaveRequest request = new ArrangmentSaveRequest();
		request.setArrangment(arrangment);
		@SuppressWarnings("unchecked")
		JAXBElement<ArrangmentSaveResponse> response = (JAXBElement<ArrangmentSaveResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/ArrangmentsWebService?wsdl", request,
						new SoapActionCallback("http://webService.projekat.xml/save"));

		return response;

	}
	public JAXBElement<ArrangmentFindResponse> find(Arrangment arrangment){
		ArrangmentFindRequest request = new ArrangmentFindRequest();
		request.setArrangment(arrangment);
		@SuppressWarnings("unchecked")
		JAXBElement<ArrangmentFindResponse> response = (JAXBElement<ArrangmentFindResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/ArrangmentsWebService?wsdl", request,
						new SoapActionCallback("http://webService.projekat.xml/find"));

		return response;

	}
	
	public JAXBElement<ArrangmentFindByAccOwnerResponse> findByAccOwner(Long id){
		ArrangmentFindByAccOwnerRequest request = new ArrangmentFindByAccOwnerRequest();
		request.setId(id);
		@SuppressWarnings("unchecked")
		JAXBElement<ArrangmentFindByAccOwnerResponse> response = (JAXBElement<ArrangmentFindByAccOwnerResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/ArrangmentsWebService?wsdl", request,
						new SoapActionCallback("http://webService.projekat.xml/findByAccOwner"));

		return response;

	}
}
