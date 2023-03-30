//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.31 at 01:25:35 AM MSK 
//


package com.shop.springsoap.gen;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for statisticTypeModal.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="statisticTypeModal">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="client"/>
 *     &lt;enumeration value="product"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "statisticTypeModal")
@XmlEnum
public enum StatisticTypeModal {

    @XmlEnumValue("client")
    CLIENT("client"),
    @XmlEnumValue("product")
    PRODUCT("product");
    private final String value;

    StatisticTypeModal(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StatisticTypeModal fromValue(String v) {
        for (StatisticTypeModal c: StatisticTypeModal.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
