/*******************************************************************************
 * Copyright (c) 2013-2016 LAAS-CNRS (www.laas.fr)
 * 7 Colonel Roche 31077 Toulouse - France
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial Contributors:
 *     Thierry Monteil : Project manager, technical co-manager
 *     Mahdi Ben Alaya : Technical co-manager
 *     Samir Medjiah : Technical co-manager
 *     Khalil Drira : Strategy expert
 *     Guillaume Garzone : Developer
 *     François Aïssaoui : Developer
 *
 * New contributors :
 *******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.15 at 03:56:27 PM CEST 
//

package commons.resource;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

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
 *     &lt;extension base="{http://www.onem2m.org/xml/protocols}mgmtResource">
 *       &lt;sequence>
 *         &lt;element name="order" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="defEcValue" type="{http://www.onem2m.org/xml/protocols}eventCat"/>
 *         &lt;element name="requestOrigin" type="{http://www.onem2m.org/xml/protocols}listOfM2MID"/>
 *         &lt;element name="requestContext" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="requestContextNotification" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="requestCharacteristics" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "order", "defEcValue", "requestOrigin",
		"requestContext", "requestContextNotification",
		"requestCharacteristics" })
@XmlRootElement(name = "cmdhDefEcValue")
public class CmdhDefEcValue extends MgmtResource {

	@XmlElement(required = true)
	@XmlSchemaType(name = "positiveInteger")
	protected BigInteger order;
	@XmlElement(required = true)
	protected String defEcValue;
	@XmlList
	@XmlElement(required = true)
	protected List<String> requestOrigin;
	protected Object requestContext;
	protected Boolean requestContextNotification;
	protected Object requestCharacteristics;

	/**
	 * Gets the value of the order property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getOrder() {
		return order;
	}

	/**
	 * Sets the value of the order property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setOrder(BigInteger value) {
		this.order = value;
	}

	/**
	 * Gets the value of the defEcValue property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDefEcValue() {
		return defEcValue;
	}

	/**
	 * Sets the value of the defEcValue property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDefEcValue(String value) {
		this.defEcValue = value;
	}

	/**
	 * Gets the value of the requestOrigin property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the requestOrigin property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRequestOrigin().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getRequestOrigin() {
		if (requestOrigin == null) {
			requestOrigin = new ArrayList<String>();
		}
		return this.requestOrigin;
	}

	/**
	 * Gets the value of the requestContext property.
	 * 
	 * @return possible object is {@link Object }
	 * 
	 */
	public Object getRequestContext() {
		return requestContext;
	}

	/**
	 * Sets the value of the requestContext property.
	 * 
	 * @param value
	 *            allowed object is {@link Object }
	 * 
	 */
	public void setRequestContext(Object value) {
		this.requestContext = value;
	}

	/**
	 * Gets the value of the requestContextNotification property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isRequestContextNotification() {
		return requestContextNotification;
	}

	/**
	 * Sets the value of the requestContextNotification property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setRequestContextNotification(Boolean value) {
		this.requestContextNotification = value;
	}

	/**
	 * Gets the value of the requestCharacteristics property.
	 * 
	 * @return possible object is {@link Object }
	 * 
	 */
	public Object getRequestCharacteristics() {
		return requestCharacteristics;
	}

	/**
	 * Sets the value of the requestCharacteristics property.
	 * 
	 * @param value
	 *            allowed object is {@link Object }
	 * 
	 */
	public void setRequestCharacteristics(Object value) {
		this.requestCharacteristics = value;
	}

}
