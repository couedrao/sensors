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
import javax.xml.bind.annotation.XmlRootElement;
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
 *     &lt;extension base="{http://www.onem2m.org/xml/protocols}announcedMgmtResource">
 *       &lt;sequence>
 *         &lt;element name="logTypeId" type="{http://www.onem2m.org/xml/protocols}logTypeId" minOccurs="0"/>
 *         &lt;element name="logData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="logStatus" type="{http://www.onem2m.org/xml/protocols}logStatus" minOccurs="0"/>
 *         &lt;element name="logStart" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="logStop" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="childResource" type="{http://www.onem2m.org/xml/protocols}childResourceRef" maxOccurs="unbounded"/>
 *           &lt;element ref="{http://www.onem2m.org/xml/protocols}subscription" maxOccurs="unbounded"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "logTypeId", "logData", "logStatus",
		"logStart", "logStop", "childResource", "subscription" })
@XmlRootElement(name = "eventLogAnnc")
public class EventLogAnnc extends AnnouncedMgmtResource {

	protected BigInteger logTypeId;
	protected String logData;
	protected BigInteger logStatus;
	protected Boolean logStart;
	protected Boolean logStop;
	protected List<ChildResourceRef> childResource;
	@XmlElement(namespace = "http://www.onem2m.org/xml/protocols")
	protected List<Subscription> subscription;

	/**
	 * Gets the value of the logTypeId property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getLogTypeId() {
		return logTypeId;
	}

	/**
	 * Sets the value of the logTypeId property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setLogTypeId(BigInteger value) {
		this.logTypeId = value;
	}

	/**
	 * Gets the value of the logData property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLogData() {
		return logData;
	}

	/**
	 * Sets the value of the logData property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLogData(String value) {
		this.logData = value;
	}

	/**
	 * Gets the value of the logStatus property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getLogStatus() {
		return logStatus;
	}

	/**
	 * Sets the value of the logStatus property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setLogStatus(BigInteger value) {
		this.logStatus = value;
	}

	/**
	 * Gets the value of the logStart property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isLogStart() {
		return logStart;
	}

	/**
	 * Sets the value of the logStart property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setLogStart(Boolean value) {
		this.logStart = value;
	}

	/**
	 * Gets the value of the logStop property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isLogStop() {
		return logStop;
	}

	/**
	 * Sets the value of the logStop property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setLogStop(Boolean value) {
		this.logStop = value;
	}

	/**
	 * Gets the value of the childResource property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the childResource property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getChildResource().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ChildResourceRef }
	 * 
	 * 
	 */
	public List<ChildResourceRef> getChildResource() {
		if (childResource == null) {
			childResource = new ArrayList<ChildResourceRef>();
		}
		return this.childResource;
	}

	/**
	 * Gets the value of the subscription property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the subscription property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSubscription().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link Subscription }
	 * 
	 * 
	 */
	public List<Subscription> getSubscription() {
		if (subscription == null) {
			subscription = new ArrayList<Subscription>();
		}
		return this.subscription;
	}

}
