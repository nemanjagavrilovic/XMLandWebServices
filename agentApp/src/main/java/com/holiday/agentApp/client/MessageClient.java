package com.holiday.agentApp.client;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.holiday.agentApp.model.Inbox;
import com.holiday.agentApp.model.Message;
import com.holiday.agentApp.requestAndResponse.MessageByInboxRequest;
import com.holiday.agentApp.requestAndResponse.MessageByInboxResponse;
import com.holiday.agentApp.requestAndResponse.MessageSaveRequest;
import com.holiday.agentApp.requestAndResponse.MessageSaveResponse;
import com.holiday.agentApp.requestAndResponse.MessageUpdateRequest;
import com.holiday.agentApp.requestAndResponse.MessageUpdateResponse;
import com.holiday.agentApp.requestAndResponse.MessagesAllRequest;
import com.holiday.agentApp.requestAndResponse.MessagesAllResponse;

public class MessageClient  extends WebServiceGatewaySupport{


	public JAXBElement<MessagesAllResponse> getAllMessages(){
		
		MessagesAllRequest request=new MessagesAllRequest();
		@SuppressWarnings("unchecked")
		JAXBElement<MessagesAllResponse> response = (JAXBElement<MessagesAllResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/MessageWebService?wsdl",
						request,
						new SoapActionCallback("http://webService.projekat.xml/findAll"));

		return response;

	}
	
		public JAXBElement<MessageSaveResponse> saveMessage(Message message){
		
	MessageSaveRequest request=new MessageSaveRequest();
	request.setMessage(message);
		@SuppressWarnings("unchecked")
		JAXBElement<MessageSaveResponse> response = (JAXBElement<MessageSaveResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:1111/Service/MessageWebService?wsdl",
						request,
						new SoapActionCallback("http://webService.projekat.xml/save"));

		return response;

	}
		public JAXBElement<MessageByInboxResponse> findByInbox(Inbox inbox){
			
			MessageByInboxRequest request=new MessageByInboxRequest();
			request.setInbox(inbox);
			@SuppressWarnings("unchecked")
				JAXBElement<MessageByInboxResponse> response = (JAXBElement<MessageByInboxResponse>) getWebServiceTemplate()
						.marshalSendAndReceive("http://localhost:1111/Service/MessageWebService?wsdl",
								request,
								new SoapActionCallback("http://webService.projekat.xml/findByInbox"));

				return response;

			}
		public JAXBElement<MessageUpdateResponse> update(Long inboxId,Long id){
			MessageUpdateRequest request=new MessageUpdateRequest();
			request.setInboxId(inboxId);
			request.setId(id);
			@SuppressWarnings("unchecked")
			JAXBElement<MessageUpdateResponse> response = (JAXBElement<MessageUpdateResponse>) getWebServiceTemplate()
					.marshalSendAndReceive("http://localhost:1111/Service/MessageWebService?wsdl",
							request,
							new SoapActionCallback("http://webService.projekat.xml/update"));

			return response;

		}
}
