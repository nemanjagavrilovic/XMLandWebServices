package com.holiday.agentApp.client;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.holiday.agentApp.model.Accomodation;
import com.holiday.agentApp.requestAndResponse.CommentFindByAccRequest;
import com.holiday.agentApp.requestAndResponse.CommentFindByAccResponse;

public class CommentClient extends WebServiceGatewaySupport{

	public JAXBElement<CommentFindByAccResponse> getComments(Accomodation acc){
		CommentFindByAccRequest request=new CommentFindByAccRequest();
		request.setAcc(acc);
		JAXBElement<CommentFindByAccResponse> response=(JAXBElement<CommentFindByAccResponse>)getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/CommentWebService?wsdl",
						request,
						new SoapActionCallback("http://webService.projekat.xml/findByAcc"));
		return response;
	}
}
