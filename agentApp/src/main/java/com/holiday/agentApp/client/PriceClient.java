package com.holiday.agentApp.client;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.holiday.agentApp.model.Price;
import com.holiday.agentApp.requestAndResponse.PriceSaveRequest;
import com.holiday.agentApp.requestAndResponse.PriceSaveResponse;

public class PriceClient extends WebServiceGatewaySupport{

	public JAXBElement<PriceSaveResponse> save(Price price){
		PriceSaveRequest request=new PriceSaveRequest();
		request.setPrice(price);
		JAXBElement<PriceSaveResponse> response=(JAXBElement<PriceSaveResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/PriceWebService?wsdl",request
						,new SoapActionCallback("http://webService.projekat.xml/save"));
		return response;
	}
}
