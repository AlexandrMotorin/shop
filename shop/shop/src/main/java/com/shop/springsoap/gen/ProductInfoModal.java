//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.31 at 01:25:35 AM MSK 
//


package com.shop.springsoap.gen;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for productInfoModal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="productInfoModal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="averageEvaluation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;sequence>
 *           &lt;element name="distributions" type="{http://www.shop.com/springsoap/gen}distribution" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element name="clientEvaluation" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productInfoModal", propOrder = {
    "description",
    "averageEvaluation",
    "distributions",
    "clientEvaluation"
})
public class ProductInfoModal {

    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String averageEvaluation;
    protected List<Distribution> distributions;
    protected int clientEvaluation;

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
     * Gets the value of the averageEvaluation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAverageEvaluation() {
        return averageEvaluation;
    }

    /**
     * Sets the value of the averageEvaluation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAverageEvaluation(String value) {
        this.averageEvaluation = value;
    }

    /**
     * Gets the value of the distributions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the distributions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDistributions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Distribution }
     * 
     * 
     */
    public List<Distribution> getDistributions() {
        if (distributions == null) {
            distributions = new ArrayList<Distribution>();
        }
        return this.distributions;
    }

    /**
     * Gets the value of the clientEvaluation property.
     * 
     */
    public int getClientEvaluation() {
        return clientEvaluation;
    }

    /**
     * Sets the value of the clientEvaluation property.
     * 
     */
    public void setClientEvaluation(int value) {
        this.clientEvaluation = value;
    }

}
