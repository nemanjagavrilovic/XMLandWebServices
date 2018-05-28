package com.holiday.agentApp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateStart" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="dateEnd" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"id", "dateStart", "dateEnd", "value" })
@Entity
public class Price implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@XmlElement(required = true)
	@XmlSchemaType(name = "date")

	protected Date dateStart;
	@XmlElement(required = true)
	@XmlSchemaType(name = "date")
	protected Date dateEnd;
	@Column(nullable = false)
	protected float value;

	
	/**
	 * Gets the value of the dateStart property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public Date getDateStart() {
		return dateStart;
	}

	public Price() {
		super();
	}

	public Price(Long id, Date dateStart, Date dateEnd, float value) {
		super();
		this.id = id;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.value = value;
	}

	/**
	 * Sets the value of the dateStart property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDateStart(Date value) {
		this.dateStart = value;
	}

	/**
	 * Gets the value of the dateEnd property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public Date getDateEnd() {
		return dateEnd;
	}

	/**
	 * Sets the value of the dateEnd property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDateEnd(Date value) {
		this.dateEnd = value;
	}

	/**
	 * Gets the value of the value property.
	 * 
	 */
	public float getValue() {
		return value;
	}

	/**
	 * Sets the value of the value property.
	 * 
	 */
	public void setValue(float value) {
		this.value = value;
	}

}
