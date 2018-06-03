//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.05 at 01:02:21 AM CEST 
//


package com.holiday.agentApp.requestAndResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.holiday.agentApp.model.Inbox;


/**
 * <p>Java class for messageByInboxRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="messageByInboxRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="inbox" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0" form="qualified"/&gt;
 *                   &lt;element name="sender" type="{http://www.holiday.com/system}TUser" form="qualified"/&gt;
 *                   &lt;element name="receiver" type="{http://www.holiday.com/system}TUser" form="qualified"/&gt;
 *                   &lt;element ref="{http://www.holiday.com/inbox}Message" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "messageByInboxRequest", namespace = "http://webService.projekat.xml/", propOrder = {
    "inbox"
})
public class MessageByInboxRequest {

    @XmlElement(namespace = "")
    protected Inbox inbox;

    /**
     * Gets the value of the inbox property.
     * 
     * @return
     *     possible object is
     *     {@link MessageByInboxRequest.Inbox }
     *     
     */
    public Inbox getInbox() {
        return inbox;
    }

    /**
     * Sets the value of the inbox property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageByInboxRequest.Inbox }
     *     
     */
    public void setInbox(Inbox value) {
        this.inbox = value;
    }


    

}
