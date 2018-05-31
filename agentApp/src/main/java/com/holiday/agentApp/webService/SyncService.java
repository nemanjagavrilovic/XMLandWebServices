package com.holiday.agentApp.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.holiday.agentApp.model.Accomodation;


@WebService(targetNamespace="http://webService.agentApp.holiday.com",name="SyncService")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)

public interface SyncService {

	
	@RequestWrapper(localName="AccomodationRequest",
	targetNamespace="http://webService.agentApp.holiday.com/",
	className="com.holiday.agentApp.response.SyncRequest")
	@WebMethod(operationName="sync",action="http://com.holiday.agentApp/sync")
	@ResponseWrapper(localName="AccomodationResponse",
	targetNamespace="http://webService.agentApp.holiday.com/",
	className="com.holiday.agentApp.response.SyncResponse")
	
	public void sync(@WebParam(name="accomodation")Accomodation accomodation);
}
