package com.holiday.agentApp.client;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.holiday.agentApp.model.Location;
import com.holiday.agentApp.requestAndResponse.LocationByIdRequest;
import com.holiday.agentApp.requestAndResponse.LocationByIdResponse;
import com.holiday.agentApp.requestAndResponse.LocationRequest;
import com.holiday.agentApp.requestAndResponse.LocationResponse;
import com.holiday.agentApp.requestAndResponse.LocationSaveRequest;
import com.holiday.agentApp.requestAndResponse.LocationSaveResponse;


public class LocationClient extends WebServiceGatewaySupport {

	public JAXBElement<LocationResponse> getAllLocations(){
		
		LocationRequest request=new LocationRequest();
		@SuppressWarnings("unchecked")
		JAXBElement<LocationResponse> response = (JAXBElement<LocationResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/LocationWebService?wsdl",
						request,
						new SoapActionCallback("http://webService.projekat.xml/findAll"));

		return response;

	}
	
public JAXBElement<LocationByIdResponse> findByIdLocation(Long id){
		
		LocationByIdRequest request=new LocationByIdRequest();
		request.setId(id);
		@SuppressWarnings("unchecked")
		JAXBElement<LocationByIdResponse> response = (JAXBElement<LocationByIdResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/LocationWebService?wsdl",
						request,
						new SoapActionCallback("http://webService.projekat.xml/findById"));

		return response;

	}
public JAXBElement<LocationSaveResponse> save(Location location){
	
	LocationSaveRequest request=new LocationSaveRequest();
	request.setLocation(location);
	@SuppressWarnings("unchecked")
	JAXBElement<LocationSaveResponse> response = (JAXBElement<LocationSaveResponse>) getWebServiceTemplate()
			.marshalSendAndReceive("http://localhost:1111/Service/LocationWebService?wsdl",
					request,
					new SoapActionCallback("http://webService.projekat.xml/save"));

	return response;

}
}
