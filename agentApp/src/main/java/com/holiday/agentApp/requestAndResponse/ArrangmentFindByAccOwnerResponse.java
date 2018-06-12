//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.12 at 05:27:52 PM CEST 
//


package com.holiday.agentApp.requestAndResponse;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.holiday.agentApp.model.Arrangment;


/**
 * <p>Java class for arrangmentFindByAccOwnerResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="arrangmentFindByAccOwnerResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="arrangment" maxOccurs="unbounded" minOccurs="0"&gt;
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
@XmlType(name = "arrangmentFindByAccOwnerResponse", namespace = "http://webService.projekat.xml/", propOrder = {
    "arrangment"
})
public class ArrangmentFindByAccOwnerResponse {

    @XmlElement(namespace = "")
    protected List<Arrangment> arrangment;

    /**
     * Gets the value of the arrangment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arrangment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArrangment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrangmentFindByAccOwnerResponse.Arrangment }
     * 
     * 
     */
    public List<Arrangment> getArrangment() {
        if (arrangment == null) {
            arrangment = new ArrayList<Arrangment>();
        }
        return this.arrangment;
    }


   
}