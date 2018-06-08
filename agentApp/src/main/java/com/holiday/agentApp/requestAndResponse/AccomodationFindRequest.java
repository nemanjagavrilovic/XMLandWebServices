//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.07 at 07:26:50 PM CEST 
//


package com.holiday.agentApp.requestAndResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.holiday.agentApp.model.Location;
import com.holiday.agentApp.model.ObjectCategory;
import com.holiday.agentApp.model.ObjectType;
import com.holiday.agentApp.model.PriceShedule;
import com.holiday.agentApp.model.TUser;


/**
 * <p>Java class for accomodationFindRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accomodationFindRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="location" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0" form="qualified"/&gt;
 *                   &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/&gt;
 *                   &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/&gt;
 *                   &lt;element name="Street" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="maxPerson" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
 *         &lt;element name="objectType" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0" form="qualified"/&gt;
 *                   &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="owner" type="{http://www.holiday.com/system}TUser" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="priceShedule" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0" form="qualified"/&gt;
 *                   &lt;element name="Price" maxOccurs="unbounded" minOccurs="0" form="qualified"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0" form="qualified"/&gt;
 *                             &lt;element name="dateStart" type="{http://www.w3.org/2001/XMLSchema}date" form="qualified"/&gt;
 *                             &lt;element name="dateEnd" type="{http://www.w3.org/2001/XMLSchema}date" form="qualified"/&gt;
 *                             &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}float" form="qualified"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
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
@XmlType(name = "accomodationFindRequest", namespace = "http://webService.projekat.xml/", propOrder = {
    "location",
    "maxPerson",
    "objectCategory",
    "objectType",
    "owner",
    "name",
    "description",
    "priceShedule"
})

@XmlRootElement
public class AccomodationFindRequest {

    @XmlElement(namespace = "")
    protected Location location;
    @XmlElement(namespace = "")
    protected int maxPerson;
    @XmlElement(namespace = "")
    protected ObjectCategory objectCategory;
    @XmlElement(namespace = "")
    protected ObjectType objectType;
    @XmlElement(namespace = "")
    protected TUser owner;
    @XmlElement(namespace = "")
    protected String name;
    @XmlElement(namespace = "")
    protected String description;
    @XmlElement(namespace = "")
    protected PriceShedule priceShedule;

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link AccomodationFindRequest.Location }
     *     
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccomodationFindRequest.Location }
     *     
     */
    public void setLocation(Location value) {
        this.location = value;
    }

    /**
     * Gets the value of the maxPerson property.
     * 
     */
    public int getMaxPerson() {
        return maxPerson;
    }

    /**
     * Sets the value of the maxPerson property.
     * 
     */
    public void setMaxPerson(int value) {
        this.maxPerson = value;
    }

    /**
     * Gets the value of the objectCategory property.
     * 
     * @return
     *     possible object is
     *     {@link AccomodationFindRequest.ObjectCategory }
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
     *     {@link AccomodationFindRequest.ObjectCategory }
     *     
     */
    public void setObjectCategory(ObjectCategory value) {
        this.objectCategory = value;
    }

    /**
     * Gets the value of the objectType property.
     * 
     * @return
     *     possible object is
     *     {@link AccomodationFindRequest.ObjectType }
     *     
     */
    public ObjectType getObjectType() {
        return objectType;
    }

    /**
     * Sets the value of the objectType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccomodationFindRequest.ObjectType }
     *     
     */
    public void setObjectType(ObjectType value) {
        this.objectType = value;
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link TUser }
     *     
     */
    public TUser getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUser }
     *     
     */
    public void setOwner(TUser value) {
        this.owner = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the priceShedule property.
     * 
     * @return
     *     possible object is
     *     {@link AccomodationFindRequest.PriceShedule }
     *     
     */
    public PriceShedule getPriceShedule() {
        return priceShedule;
    }

    /**
     * Sets the value of the priceShedule property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccomodationFindRequest.PriceShedule }
     *     
     */
    public void setPriceShedule(PriceShedule value) {
        this.priceShedule = value;
    }


    

}