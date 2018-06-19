package com.holiday.agentApp.client;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.holiday.agentApp.model.Accomodation;
import com.holiday.agentApp.model.TUser;
import com.holiday.agentApp.requestAndResponse.AccomodationDeleteRequest;
import com.holiday.agentApp.requestAndResponse.AccomodationFindByOwnerRequest;
import com.holiday.agentApp.requestAndResponse.AccomodationFindByOwnerResponse;
import com.holiday.agentApp.requestAndResponse.AccomodationFindRequest;
import com.holiday.agentApp.requestAndResponse.AccomodationFindResponse;
import com.holiday.agentApp.requestAndResponse.AccomodationSaveRequest;
import com.holiday.agentApp.requestAndResponse.AccomodationSaveResponse;
import com.holiday.agentApp.requestAndResponse.DeleteResponse;

public class AccomodationClient extends WebServiceGatewaySupport{

	public JAXBElement<AccomodationSaveResponse> save(Accomodation accomodation){
		AccomodationSaveRequest request = new AccomodationSaveRequest();
		request.setAccomodation(accomodation);
		@SuppressWarnings("unchecked")
		JAXBElement<AccomodationSaveResponse> response = (JAXBElement<AccomodationSaveResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/AccomodationWebService?wsdl", request,
						new SoapActionCallback("http://webService.projekat.xml/save"));

		return response;

	}
	
	public JAXBElement<AccomodationFindResponse> find(Accomodation accomodation){
		AccomodationFindRequest request = new AccomodationFindRequest();
		request.setLocation(accomodation.getLocation());
		request.setName(accomodation.getName());
		request.setDescription(accomodation.getDescription());
		request.setObjectType(accomodation.getType());
		request.setObjectCategory(accomodation.getCategory());
		request.setOwner(accomodation.getOwner());
		request.setMaxPerson(accomodation.getMaxPerson());
		request.setPriceShedule(accomodation.getPriceShedule());
		@SuppressWarnings("unchecked")
		JAXBElement<AccomodationFindResponse> response = (JAXBElement<AccomodationFindResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/AccomodationWebService?wsdl", request,
						new SoapActionCallback("http://webService.projekat.xml/find"));

		return response;

	}

	public JAXBElement<AccomodationFindByOwnerResponse> findByOwner(TUser user){
		AccomodationFindByOwnerRequest request = new AccomodationFindByOwnerRequest();
		request.setOwner(user);
		@SuppressWarnings("unchecked")
		JAXBElement<AccomodationFindByOwnerResponse> response = (JAXBElement<AccomodationFindByOwnerResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/AccomodationWebService?wsdl", request,
						new SoapActionCallback("http://webService.projekat.xml/findByOwner"));

		return response;

	}
	public JAXBElement<DeleteResponse> delete(Accomodation accomodation){
		AccomodationDeleteRequest request=new AccomodationDeleteRequest();
		request.setAccomodaiton(accomodation);
		JAXBElement<DeleteResponse> response=(JAXBElement<DeleteResponse>)getWebServiceTemplate()
		.marshalSendAndReceive("http://localhost:1111/Service/AccomodationWebService?wsdl", request,
				new SoapActionCallback("http://webService.projekat.xml/delete"));
		
		return response;
	}
}
