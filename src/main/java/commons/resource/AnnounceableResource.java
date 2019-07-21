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
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import commons.constants.ShortName;

/**
 * <p>
 * Java class for announceableResource complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="announceableResource">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.onem2m.org/xml/protocols}regularResource">
 *       &lt;sequence>
 *         &lt;element name="announceTo" type="{http://www.onem2m.org/xml/protocols}listOfURIs" minOccurs="0"/>
 *         &lt;element name="announcedAttribute" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;list itemType="{http://www.w3.org/2001/XMLSchema}token" />
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announceableResource")
@XmlSeeAlso({ LocationPolicy.class, RemoteCSE.class, Node.class, AE.class,
		NodeAnnc.class, MgmtResource.class, Group.class, Container.class })
public class AnnounceableResource extends RegularResource {

	@XmlList
	@XmlElement(name=ShortName.ANNOUNCE_TO)
	protected List<String> announceTo;
	@XmlList
	@XmlElement(name=ShortName.ANNOUNCED_ATTRIBUTE)
	protected List<String> announcedAttribute;

	/**
	 * Gets the value of the announceTo property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the announceTo property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAnnounceTo().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getAnnounceTo() {
		if (announceTo == null) {
			announceTo = new ArrayList<String>();
		}
		return this.announceTo;
	}

	/**
	 * Gets the value of the announcedAttribute property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the announcedAttribute property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAnnouncedAttribute().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getAnnouncedAttribute() {
		if (announcedAttribute == null) {
			announcedAttribute = new ArrayList<String>();
		}
		return this.announcedAttribute;
	}

}
