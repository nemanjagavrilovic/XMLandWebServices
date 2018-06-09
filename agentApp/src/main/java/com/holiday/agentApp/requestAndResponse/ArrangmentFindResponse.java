//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.08 at 06:32:34 PM CEST 
//


package com.holiday.agentApp.requestAndResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.holiday.agentApp.model.Arrangment;


/**
 * <p>Java class for arrangmentFindResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="arrangmentFindResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="arrangment" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0" form="qualified"/&gt;
 *                   &lt;element name="dateStart" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="dateEnd" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element ref="{http://www.holiday.com/system}Accomodation"/&gt;
 *                   &lt;element name="numberOfPeople" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="Owner" type="{http://www.holiday.com/system}TUser"/&gt;
 *                   &lt;element name="realized" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "arrangmentFindResponse", namespace = "http://webService.projekat.xml/", propOrder = {
    "arrangment"
})
public class ArrangmentFindResponse {

    @XmlElement(namespace = "")
    protected Arrangment arrangment;

    /**
     * Gets the value of the arrangment property.
     * 
     * @return
     *     possible object is
     *     {@link ArrangmentFindResponse.Arrangment }
     *     
     */
    public Arrangment getArrangment() {
        return arrangment;
    }

    /**
     * Sets the value of the arrangment property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrangmentFindResponse.Arrangment }
     *     
     */
    public void setArrangment(Arrangment value) {
        this.arrangment = value;
    }

}
