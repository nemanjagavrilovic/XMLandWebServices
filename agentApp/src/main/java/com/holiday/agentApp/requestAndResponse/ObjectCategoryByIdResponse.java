//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.07 at 01:27:31 PM CEST 
//


package com.holiday.agentApp.requestAndResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.holiday.agentApp.model.ObjectCategory;


/**
 * <p>Java class for objectCategoryByIdResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="objectCategoryByIdResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="objectCategory" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0" form="qualified"/&gt;
 *                   &lt;element name="Category" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/&gt;
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
@XmlType(name = "objectCategoryByIdResponse", namespace = "http://webService.projekat.xml/", propOrder = {
    "objectCategory"
})
public class ObjectCategoryByIdResponse {

    @XmlElement(namespace = "")
    protected ObjectCategory objectCategory;

    /**
     * Gets the value of the objectCategory property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectCategoryByIdResponse.ObjectCategory }
     *     
     */
    public ObjectCategory getObjectCategory() {
        return objectCategory;
    }

    /**
     * Sets the value of the objectCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectCategoryByIdResponse.ObjectCategory }
     *     
     */
    public void setObjectCategory(ObjectCategory value) {
        this.objectCategory = value;
    }


    
}
