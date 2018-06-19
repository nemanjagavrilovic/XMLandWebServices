package com.holiday.agentApp.client;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.holiday.agentApp.model.Rating;
import com.holiday.agentApp.requestAndResponse.RatingFindByIdRequest;
import com.holiday.agentApp.requestAndResponse.RatingFindByIdResponse;
import com.holiday.agentApp.requestAndResponse.RatingSaveRequest;
import com.holiday.agentApp.requestAndResponse.RatingSaveResponse;

public class RatingClient extends WebServiceGatewaySupport{

	public JAXBElement<RatingFindByIdResponse> findById(Long id){
		RatingFindByIdRequest request=new RatingFindByIdRequest();
		request.setId(id);
		JAXBElement<RatingFindByIdResponse> response=(JAXBElement<RatingFindByIdResponse>)getWebServiceTemplate().
				marshalSendAndReceive("http://localhost:1111/Service/RatingWebService?wsdl",request,
						new SoapActionCallback("http://webService.projekat.xml/findById"));
		return response;
	}
	public JAXBElement<RatingSaveResponse> save(Rating rating){
		RatingSaveRequest request=new RatingSaveRequest();
		request.setRating(rating);
		JAXBElement<RatingSaveResponse> response=(JAXBElement<RatingSaveResponse>)getWebServiceTemplate().
				marshalSendAndReceive("http://localhost:1111/Service/RatingWebService?wsdl",request,
						new SoapActionCallback("http://webService.projekat.xml/save"));
		return response;
	}
}
