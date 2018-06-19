package com.holiday.agentApp.client;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.holiday.agentApp.model.PriceShedule;
import com.holiday.agentApp.requestAndResponse.PriceSheduleSaveRequest;
import com.holiday.agentApp.requestAndResponse.PriceSheduleSaveResponse;

public class PriceScheduleClient extends WebServiceGatewaySupport{

	public JAXBElement<PriceSheduleSaveResponse> save(PriceShedule priceSchedule){
		PriceSheduleSaveRequest request=new PriceSheduleSaveRequest();
		request.setPriceShedule(priceSchedule);
		JAXBElement<PriceSheduleSaveResponse> response=(JAXBElement<PriceSheduleSaveResponse>)getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/PriceScheduleWebService?wsdl",request,
						new SoapActionCallback("http://webService.projekat.xml/save"));
		return response;
	}
}
