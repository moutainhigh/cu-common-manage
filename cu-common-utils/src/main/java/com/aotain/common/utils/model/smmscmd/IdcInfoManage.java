//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.14 at 02:35:40 下午 CST 
//


package com.aotain.common.utils.model.smmscmd;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="commandId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="commandInfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="idcId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="queryMonitorDayTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="queryMonitorDayFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="houseId" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "commandId",
    "type",
    "commandInfo",
    "timestamp"
})
@XmlRootElement(name = "idcInfoManage")
public class IdcInfoManage extends CommandBaseVo{
	private static final long serialVersionUID = -7014346621475702699L;
	protected long commandId;
    @XmlElement(required = true)
    protected BigInteger type;
    @XmlElement(required = true)
    protected IdcInfoManage.CommandInfo commandInfo;
    @XmlElement(required = true)
    protected String timestamp;

    /**
     * Gets the value of the commandId property.
     * 
     */
    public long getCommandId() {
        return commandId;
    }

    /**
     * Sets the value of the commandId property.
     * 
     */
    public void setCommandId(long value) {
        this.commandId = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setType(BigInteger value) {
        this.type = value;
    }

    /**
     * Gets the value of the commandInfo property.
     * 
     * @return
     *     possible object is
     *     {@link IdcInfoManage.CommandInfo }
     *     
     */
    public IdcInfoManage.CommandInfo getCommandInfo() {
        return commandInfo;
    }

    /**
     * Sets the value of the commandInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdcInfoManage.CommandInfo }
     *     
     */
    public void setCommandInfo(IdcInfoManage.CommandInfo value) {
        this.commandInfo = value;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimestamp(String value) {
        this.timestamp = value;
    }


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
     *         &lt;element name="idcId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="queryMonitorDayTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="queryMonitorDayFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="houseId" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
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
        "idcId",
        "queryMonitorDayTo",
        "queryMonitorDayFrom",
        "id",
        "houseId"
    })
    public static class CommandInfo {

        protected String idcId;
        protected String queryMonitorDayTo;
        protected String queryMonitorDayFrom;
        @XmlElement(type = Long.class)
        protected List<Long> id;
        @XmlElement(type = Long.class)
        protected List<Long> houseId;

        /**
         * Gets the value of the idcId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIdcId() {
            return idcId;
        }

        /**
         * Sets the value of the idcId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIdcId(String value) {
            this.idcId = value;
        }

        /**
         * Gets the value of the queryMonitorDayTo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getQueryMonitorDayTo() {
            return queryMonitorDayTo;
        }

        /**
         * Sets the value of the queryMonitorDayTo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setQueryMonitorDayTo(String value) {
            this.queryMonitorDayTo = value;
        }

        /**
         * Gets the value of the queryMonitorDayFrom property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getQueryMonitorDayFrom() {
            return queryMonitorDayFrom;
        }

        /**
         * Sets the value of the queryMonitorDayFrom property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setQueryMonitorDayFrom(String value) {
            this.queryMonitorDayFrom = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the id property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getId().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Long }
         * 
         * 
         */
        public List<Long> getId() {
            if (id == null) {
                id = new ArrayList<Long>();
            }
            return this.id;
        }

        /**
         * Gets the value of the houseId property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the houseId property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getHouseId().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Long }
         * 
         * 
         */
        public List<Long> getHouseId() {
            if (houseId == null) {
                houseId = new ArrayList<Long>();
            }
            return this.houseId;
        }

    }

}