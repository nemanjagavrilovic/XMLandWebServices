//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.16 at 01:19:44 PM CEST 
//


package com.holiday.agentApp.requestAndResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.holiday.agentApp.model.Rating;


/**
 * <p>Java class for ratingSaveRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ratingSaveRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rating" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0" form="qualified"/&gt;
 *                   &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}int" form="qualified"/&gt;
 *                   &lt;element name="Owner" type="{http://www.holiday.com/system}TUser" form="qualified"/&gt;
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
@XmlType(name = "ratingSaveRequest", namespace = "http://webService.projekat.xml/", propOrder = {
    "rating"
})
@XmlRootElement
public class RatingSaveRequest {

    @XmlElement(namespace = "")
    protected Rating rating;

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link RatingSaveRequest.Rating }
     *     
     */
    public Rating getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link RatingSaveRequest.Rating }
     *     
     */
    public void setRating(Rating value) {
        this.rating = value;
    }



}