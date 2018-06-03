//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.04 at 03:04:43 PM CEST 
//

package com.holiday.agentApp.requestAndResponse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.holiday.agentApp.model.Accomodation;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the xml.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Id_QNAME = new QName("http://www.holiday.com/system", "id");
    private final static QName _LocationRequest_QNAME = new QName("http://webService.projekat.xml/", "locationRequest");
    private final static QName _LocationResponse_QNAME = new QName("http://webService.projekat.xml/", "locationResponse");
    private final static QName _LocationByIdRequest_QNAME = new QName("http://webService.projekat.xml/", "locationByIdRequest");
    private final static QName _LocationByIdResponse_QNAME = new QName("http://webService.projekat.xml/", "locationByIdResponse");
    private final static QName _MessageSaveRequest_QNAME = new QName("http://webService.projekat.xml/", "messageSaveRequest");
    private final static QName _MessageSaveResponse_QNAME = new QName("http://webService.projekat.xml/", "messageSaveResponse");
    private final static QName _MessagesAllRequest_QNAME = new QName("http://webService.projekat.xml/", "messagesAllRequest");
    private final static QName _MessagesAllResponse_QNAME = new QName("http://webService.projekat.xml/", "messagesAllResponse");
    private final static QName _InboxAllRequest_QNAME = new QName("http://webService.projekat.xml/", "inboxAllRequest");
    private final static QName _InboxAllResponse_QNAME = new QName("http://webService.projekat.xml/", "inboxAllResponse");
    private final static QName _InboxByIdRequest_QNAME = new QName("http://webService.projekat.xml/", "inboxByIdRequest");
    private final static QName _InboxByIdResponse_QNAME = new QName("http://webService.projekat.xml/", "inboxByIdResponse");
    private final static QName _InboxReceiverRequest_QNAME = new QName("http://webService.projekat.xml/", "inboxReceiverRequest");
    private final static QName _InboxReceiverResponse_QNAME = new QName("http://webService.projekat.xml/", "inboxReceiverResponse");
    private final static QName _MessageByInboxRequest_QNAME = new QName("http://webService.projekat.xml/", "messageByInboxRequest");
    private final static QName _MessageByInboxResponse_QNAME = new QName("http://webService.projekat.xml/", "messageByInboxResponse");
    private final static QName _UserByIdRequest_QNAME = new QName("http://webService.projekat.xml/", "userByIdRequest");
    private final static QName _UserByIdResponse_QNAME = new QName("http://webService.projekat.xml/", "userByIdResponse");
   
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xml.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Accomodation }
     * 
     */
 
    public LocationResponse createLocationResponse() {
        return new LocationResponse();
    }
    /**
     * Create an instance of {@link MessageByInboxResponse }
     * 
     */
    public MessageByInboxResponse createMessageByInboxResponse() {
        return new MessageByInboxResponse();
    }
    /**
     * Create an instance of {@link MessageByInboxRequest }
     * 
     */
    public MessageByInboxRequest createMessageByInboxRequest() {
        return new MessageByInboxRequest();
    }
    public InboxReceiverResponse createInboxReceiverResponse() {
        return new InboxReceiverResponse();
    }
    /**
     * Create an instance of {@link InboxAllResponse }
     * 
     */
    public InboxAllResponse createInboxAllResponse() {
        return new InboxAllResponse();
    }
    /**
     * Create an instance of {@link InboxAllRequest }
     * 
     */
    public InboxAllRequest createInboxAllRequest() {
        return new InboxAllRequest();
    }

    /**
     * Create an instance of {@link InboxByIdRequest }
     * 
     */
    public InboxByIdRequest createInboxByIdRequest() {
        return new InboxByIdRequest();
    }
    
    /**
     * Create an instance of {@link InboxReceiverRequest }
     * 
     */
    public InboxReceiverRequest createInboxReceiverRequest() {
        return new InboxReceiverRequest();
    }

    /**
     * Create an instance of {@link InboxByIdResponse }
     * 
     */
    public InboxByIdResponse createInboxByIdResponse() {
        return new InboxByIdResponse();
    }
   
    /**
     * Create an instance of {@link MessagesAllResponse }
     * 
     */
    public MessagesAllResponse createMessagesAllResponse() {
        return new MessagesAllResponse();
    }

    /**
     * Create an instance of {@link MessageSaveResponse }
     * 
     */
    public MessageSaveResponse createMessageSaveResponse() {
        return new MessageSaveResponse();
    }

    /**
     * Create an instance of {@link MessageSaveRequest }
     * 
     */
    public MessageSaveRequest createMessageSaveRequest() {
        return new MessageSaveRequest();
    }
    /**
     * Create an instance of {@link LocationRequest }
     * 
     */
    public LocationRequest createLocationRequest() {
        return new LocationRequest();
    }

    /**
     * Create an instance of {@link LocationByIdResponse }
     *
     */
    public LocationByIdResponse createLocationByIdResponse() {
        return new LocationByIdResponse();
    }
    /**
     * Create an instance of {@link LocationByIdRequest }
     *
     */
    public LocationByIdRequest createLocationByIdRequest() {
        return new LocationByIdRequest();
    }
    /**
     * Create an instance of {@link MessagesAllRequest }
     * 
     */
    public MessagesAllRequest createMessagesAllRequest() {
        return new MessagesAllRequest();
    }

    /**
     * Create an instance of {@link UserByIdRequest }
     * 
     */
    public UserByIdRequest createUserByIdRequest() {
        return new UserByIdRequest();
    }

    /**
     * Create an instance of {@link UserByIdResponse }
     * 
     */
    public UserByIdResponse createUserByIdResponse() {
        return new UserByIdResponse();
    }
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.holiday.com/system", name = "id")
    public JAXBElement<Long> createId(Long value) {
        return new JAXBElement<Long>(_Id_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "locationRequest")
    public JAXBElement<LocationRequest> createLocationRequest(LocationRequest value) {
        return new JAXBElement<LocationRequest>(_LocationRequest_QNAME, LocationRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "locationResponse")
    public JAXBElement<LocationResponse> createLocationResponse(LocationResponse value) {
        return new JAXBElement<LocationResponse>(_LocationResponse_QNAME, LocationResponse.class, null, value);
    }
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationByIdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "locationByIdRequest")
    public JAXBElement<LocationByIdRequest> createLocationByIdRequest(LocationByIdRequest value) {
        return new JAXBElement<LocationByIdRequest>(_LocationByIdRequest_QNAME, LocationByIdRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "locationByIdResponse")
    public JAXBElement<LocationByIdResponse> createLocationByIdResponse(LocationByIdResponse value) {
        return new JAXBElement<LocationByIdResponse>(_LocationByIdResponse_QNAME, LocationByIdResponse.class, null, value);
    }
   
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageSaveRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "messageSaveRequest")
    public JAXBElement<MessageSaveRequest> createMessageSaveRequest(MessageSaveRequest value) {
        return new JAXBElement<MessageSaveRequest>(_MessageSaveRequest_QNAME, MessageSaveRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageSaveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "messageSaveResponse")
    public JAXBElement<MessageSaveResponse> createMessageSaveResponse(MessageSaveResponse value) {
        return new JAXBElement<MessageSaveResponse>(_MessageSaveResponse_QNAME, MessageSaveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessagesAllRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "messagesAllRequest")
    public JAXBElement<MessagesAllRequest> createMessagesAllRequest(MessagesAllRequest value) {
        return new JAXBElement<MessagesAllRequest>(_MessagesAllRequest_QNAME, MessagesAllRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessagesAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "messagesAllResponse")
    public JAXBElement<MessagesAllResponse> createMessagesAllResponse(MessagesAllResponse value) {
        return new JAXBElement<MessagesAllResponse>(_MessagesAllResponse_QNAME, MessagesAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InboxAllRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "inboxAllRequest")
    public JAXBElement<InboxAllRequest> createInboxAllRequest(InboxAllRequest value) {
        return new JAXBElement<InboxAllRequest>(_InboxAllRequest_QNAME, InboxAllRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InboxAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "inboxAllResponse")
    public JAXBElement<InboxAllResponse> createInboxAllResponse(InboxAllResponse value) {
        return new JAXBElement<InboxAllResponse>(_InboxAllResponse_QNAME, InboxAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InboxByIdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "inboxByIdRequest")
    public JAXBElement<InboxByIdRequest> createInboxByIdRequest(InboxByIdRequest value) {
        return new JAXBElement<InboxByIdRequest>(_InboxByIdRequest_QNAME, InboxByIdRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InboxByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "inboxByIdResponse")
    public JAXBElement<InboxByIdResponse> createInboxByIdResponse(InboxByIdResponse value) {
        return new JAXBElement<InboxByIdResponse>(_InboxByIdResponse_QNAME, InboxByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InboxReceiverRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "inboxReceiverRequest")
    public JAXBElement<InboxReceiverRequest> createInboxReceiverRequest(InboxReceiverRequest value) {
        return new JAXBElement<InboxReceiverRequest>(_InboxReceiverRequest_QNAME, InboxReceiverRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InboxReceiverResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "inboxReceiverResponse")
    public JAXBElement<InboxReceiverResponse> createInboxReceiverResponse(InboxReceiverResponse value) {
        return new JAXBElement<InboxReceiverResponse>(_InboxReceiverResponse_QNAME, InboxReceiverResponse.class, null, value);
    }
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageByInboxRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "messageByInboxRequest")
    public JAXBElement<MessageByInboxRequest> createMessageByInboxRequest(MessageByInboxRequest value) {
        return new JAXBElement<MessageByInboxRequest>(_MessageByInboxRequest_QNAME, MessageByInboxRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageByInboxResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "messageByInboxResponse")
    public JAXBElement<MessageByInboxResponse> createMessageByInboxResponse(MessageByInboxResponse value) {
        return new JAXBElement<MessageByInboxResponse>(_MessageByInboxResponse_QNAME, MessageByInboxResponse.class, null, value);
    }
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserByIdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "userByIdRequest")
    public JAXBElement<UserByIdRequest> createUserByIdRequest(UserByIdRequest value) {
        return new JAXBElement<UserByIdRequest>(_UserByIdRequest_QNAME, UserByIdRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "userByIdResponse")
    public JAXBElement<UserByIdResponse> createUserByIdResponse(UserByIdResponse value) {
        return new JAXBElement<UserByIdResponse>(_UserByIdResponse_QNAME, UserByIdResponse.class, null, value);
    }

}