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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import commons.constants.ShortName;

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
 *     &lt;extension base="{http://www.onem2m.org/xml/protocols}announceableSubordinateResource">
 *       &lt;sequence>
 *         &lt;element name="privileges" type="{http://www.onem2m.org/xml/protocols}setOfAcrs"/>
 *         &lt;element name="selfPrivileges" type="{http://www.onem2m.org/xml/protocols}setOfAcrs"/>
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
@XmlType(name = "")
@XmlRootElement(name = ShortName.ACP)
public class AccessControlPolicy extends AnnounceableSubordinateResource {
	@XmlElement(name=ShortName.PRIVILEGES, required = true)
	protected SetOfAcrs privileges;
	@XmlElement(name=ShortName.SELF_PRIVILEGES, required = true)
	protected SetOfAcrs selfPrivileges;
	@XmlElement(name=ShortName.CHILD_RESOURCE)
	protected List<ChildResourceRef> childResource;
	@XmlElement(name=ShortName.SUB, namespace = "http://www.onem2m.org/xml/protocols")
	protected List<Subscription> subscription;

	/**
	 * Gets the value of the privileges property.
	 * 
	 * @return possible object is {@link SetOfAcrs }
	 * 
	 */
	public SetOfAcrs getPrivileges() {
		return privileges;
	}

	/**
	 * Sets the value of the privileges property.
	 * 
	 * @param value
	 *            allowed object is {@link SetOfAcrs }
	 * 
	 */
	public void setPrivileges(SetOfAcrs value) {
		this.privileges = value;
	}

	/**
	 * Gets the value of the selfPrivileges property.
	 * 
	 * @return possible object is {@link SetOfAcrs }
	 * 
	 */
	public SetOfAcrs getSelfPrivileges() {
		return selfPrivileges;
	}

	/**
	 * Sets the value of the selfPrivileges property.
	 * 
	 * @param value
	 *            allowed object is {@link SetOfAcrs }
	 * 
	 */
	public void setSelfPrivileges(SetOfAcrs value) {
		this.selfPrivileges = value;
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
