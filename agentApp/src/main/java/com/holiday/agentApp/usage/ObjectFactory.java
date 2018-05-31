//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.30 at 05:21:41 PM CEST 
//


package com.holiday.agentApp.usage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


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
    private final static QName _FindAllRequest_QNAME = new QName("http://webService.projekat.xml/", "findAllRequest");
    private final static QName _FindAllResponse_QNAME = new QName("http://webService.projekat.xml/", "findAllResponse");
    private final static QName _FindByIdRequest_QNAME = new QName("http://webService.projekat.xml/", "findByIdRequest");
    private final static QName _FindByIdResponse_QNAME = new QName("http://webService.projekat.xml/", "findByIdResponse");
    private final static QName _AgentPMB_QNAME = new QName("http://www.holiday.com/system", "PMB");

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
    public Accomodation createAccomodation() {
        return new Accomodation();
    }

    /**
     * Create an instance of {@link PriceShedule }
     * 
     */
    public PriceShedule createPriceShedule() {
        return new PriceShedule();
    }

    /**
     * Create an instance of {@link FindByIdResponse }
     * 
     */
    public FindByIdResponse createFindByIdResponse() {
        return new FindByIdResponse();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link Agent }
     * 
     */
    public Agent createAgent() {
        return new Agent();
    }

    /**
     * Create an instance of {@link Accomodation.Type }
     * 
     */
    public Accomodation.Type createAccomodationType() {
        return new Accomodation.Type();
    }

    /**
     * Create an instance of {@link Accomodation.Category }
     * 
     */
    public Accomodation.Category createAccomodationCategory() {
        return new Accomodation.Category();
    }

    /**
     * Create an instance of {@link Picture }
     * 
     */
    public Picture createPicture() {
        return new Picture();
    }

    /**
     * Create an instance of {@link Comment }
     * 
     */
    public Comment createComment() {
        return new Comment();
    }

    /**
     * Create an instance of {@link xml.wsdl.Location }
     * 
     */
    public  com.holiday.agentApp.usage.Location createLocation() {
        return new com.holiday.agentApp.usage.Location();
    }

    /**
     * Create an instance of {@link Raiting }
     * 
     */
    public Raiting createRaiting() {
        return new Raiting();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link Accomodation.Services }
     * 
     */
    public Accomodation.Services createAccomodationServices() {
        return new Accomodation.Services();
    }

    /**
     * Create an instance of {@link PriceShedule.Price }
     * 
     */
    public PriceShedule.Price createPriceShedulePrice() {
        return new PriceShedule.Price();
    }

    /**
     * Create an instance of {@link ObjectCategory }
     * 
     */
    public ObjectCategory createObjectCategory() {
        return new ObjectCategory();
    }

    /**
     * Create an instance of {@link ObjectType }
     * 
     */
    public ObjectType createObjectType() {
        return new ObjectType();
    }

    /**
     * Create an instance of {@link xml.wsdl.Services }
     * 
     */
    public com.holiday.agentApp.usage.Services createServices() {
        return new com.holiday.agentApp.usage.Services();
    }

    /**
     * Create an instance of {@link Admin }
     * 
     */
    public Admin createAdmin() {
        return new Admin();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link FindAllRequest }
     * 
     */
    public FindAllRequest createFindAllRequest() {
        return new FindAllRequest();
    }

    /**
     * Create an instance of {@link FindByIdRequest }
     * 
     */
    public FindByIdRequest createFindByIdRequest() {
        return new FindByIdRequest();
    }

    /**
     * Create an instance of {@link FindByIdResponse.Location }
     * 
     */
    public FindByIdResponse.Location createFindByIdResponseLocation() {
        return new FindByIdResponse.Location();
    }

    /**
     * Create an instance of {@link FindAllResponse.Location }
     * 
     */
    public FindAllResponse.Location createFindAllResponseLocation() {
        return new FindAllResponse.Location();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "findAllRequest")
    public JAXBElement<FindAllRequest> createFindAllRequest(FindAllRequest value) {
        return new JAXBElement<FindAllRequest>(_FindAllRequest_QNAME, FindAllRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByIdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "findByIdRequest")
    public JAXBElement<FindByIdRequest> createFindByIdRequest(FindByIdRequest value) {
        return new JAXBElement<FindByIdRequest>(_FindByIdRequest_QNAME, FindByIdRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.projekat.xml/", name = "findByIdResponse")
    public JAXBElement<FindByIdResponse> createFindByIdResponse(FindByIdResponse value) {
        return new JAXBElement<FindByIdResponse>(_FindByIdResponse_QNAME, FindByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.holiday.com/system", name = "id", scope = Agent.class)
    public JAXBElement<Long> createAgentId(Long value) {
        return new JAXBElement<Long>(_Id_QNAME, Long.class, Agent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.holiday.com/system", name = "PMB", scope = Agent.class)
    public JAXBElement<String> createAgentPMB(String value) {
        return new JAXBElement<String>(_AgentPMB_QNAME, String.class, Agent.class, value);
    }

}