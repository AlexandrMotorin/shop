//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.30 at 11:02:04 PM MSK 
//


package com.baeldung.springsoap.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="productInfoModal" type="{http://www.baeldung.com/springsoap/gen}productInfoModal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "productInfoModal"
})
@XmlRootElement(name = "getProductInfoResponse")
public class GetProductInfoResponse {

    @XmlElement(required = true)
    protected ProductInfoModal productInfoModal;

    /**
     * Gets the value of the productInfoModal property.
     * 
     * @return
     *     possible object is
     *     {@link ProductInfoModal }
     *     
     */
    public ProductInfoModal getProductInfoModal() {
        return productInfoModal;
    }

    /**
     * Sets the value of the productInfoModal property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductInfoModal }
     *     
     */
    public void setProductInfoModal(ProductInfoModal value) {
        this.productInfoModal = value;
    }

}
