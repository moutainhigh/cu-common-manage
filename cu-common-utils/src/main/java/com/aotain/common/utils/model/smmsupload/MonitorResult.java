//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.14 at 02:35:40 下午 CST 
//


package com.aotain.common.utils.model.smmsupload;

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
 *         &lt;element name="idcId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="log" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="logId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="commandId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="houseId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="srcIp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="destIp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="srcPort" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="destPort" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="domain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="view" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="proxyType" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                   &lt;element name="proxyIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="proxyPort" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="attachment" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="file" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="gatherTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="timeStamp" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "log",
    "timeStamp"
})
@XmlRootElement(name = "monitorResult")
public class MonitorResult {

    @XmlElement(required = true)
    protected String idcId;
    @XmlElement(required = true)
    protected List<MonitorResult.Log> log;
    @XmlElement(required = true)
    protected String timeStamp;

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
     * Gets the value of the log property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the log property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLog().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MonitorResult.Log }
     * 
     * 
     */
    public List<MonitorResult.Log> getLog() {
        if (log == null) {
            log = new ArrayList<MonitorResult.Log>();
        }
        return this.log;
    }

    /**
     * Gets the value of the timeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the value of the timeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeStamp(String value) {
        this.timeStamp = value;
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
     *         &lt;element name="logId" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *         &lt;element name="commandId" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *         &lt;element name="houseId" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *         &lt;element name="srcIp" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="destIp" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="srcPort" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *         &lt;element name="destPort" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *         &lt;element name="domain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="view" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="proxyType" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *         &lt;element name="proxyIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="proxyPort" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="attachment" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="file" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="gatherTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "logId",
        "commandId",
        "houseId",
        "srcIp",
        "destIp",
        "srcPort",
        "destPort",
        "domain",
        "view",
        "proxyType",
        "proxyIp",
        "proxyPort",
        "title",
        "content",
        "url",
        "attachment",
        "gatherTime"
    })
    public static class Log {

        protected long logId;
        protected long commandId;
        protected long houseId;
        @XmlElement(required = true)
        protected String srcIp;
        @XmlElement(required = true)
        protected String destIp;
        protected long srcPort;
        protected long destPort;
        protected String domain;
        protected Long view;
        protected BigInteger proxyType;
        protected String proxyIp;
        protected Long proxyPort;
        protected String title;
        protected String content;
        protected String url;
        protected List<MonitorResult.Log.Attachment> attachment;
        @XmlElement(required = true)
        protected String gatherTime;

        /**
         * Gets the value of the logId property.
         * 
         */
        public long getLogId() {
            return logId;
        }

        /**
         * Sets the value of the logId property.
         * 
         */
        public void setLogId(long value) {
            this.logId = value;
        }

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
         * Gets the value of the houseId property.
         * 
         */
        public long getHouseId() {
            return houseId;
        }

        /**
         * Sets the value of the houseId property.
         * 
         */
        public void setHouseId(long value) {
            this.houseId = value;
        }

        /**
         * Gets the value of the srcIp property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSrcIp() {
            return srcIp;
        }

        /**
         * Sets the value of the srcIp property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSrcIp(String value) {
            this.srcIp = value;
        }

        /**
         * Gets the value of the destIp property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDestIp() {
            return destIp;
        }

        /**
         * Sets the value of the destIp property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDestIp(String value) {
            this.destIp = value;
        }

        /**
         * Gets the value of the srcPort property.
         * 
         */
        public long getSrcPort() {
            return srcPort;
        }

        /**
         * Sets the value of the srcPort property.
         * 
         */
        public void setSrcPort(long value) {
            this.srcPort = value;
        }

        /**
         * Gets the value of the destPort property.
         * 
         */
        public long getDestPort() {
            return destPort;
        }

        /**
         * Sets the value of the destPort property.
         * 
         */
        public void setDestPort(long value) {
            this.destPort = value;
        }

        /**
         * Gets the value of the domain property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDomain() {
            return domain;
        }

        /**
         * Sets the value of the domain property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDomain(String value) {
            this.domain = value;
        }

        /**
         * Gets the value of the view property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getView() {
            return view;
        }

        /**
         * Sets the value of the view property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setView(Long value) {
            this.view = value;
        }

        /**
         * Gets the value of the proxyType property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getProxyType() {
            return proxyType;
        }

        /**
         * Sets the value of the proxyType property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setProxyType(BigInteger value) {
            this.proxyType = value;
        }

        /**
         * Gets the value of the proxyIp property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProxyIp() {
            return proxyIp;
        }

        /**
         * Sets the value of the proxyIp property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProxyIp(String value) {
            this.proxyIp = value;
        }

        /**
         * Gets the value of the proxyPort property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getProxyPort() {
            return proxyPort;
        }

        /**
         * Sets the value of the proxyPort property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setProxyPort(Long value) {
            this.proxyPort = value;
        }

        /**
         * Gets the value of the title property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTitle() {
            return title;
        }

        /**
         * Sets the value of the title property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTitle(String value) {
            this.title = value;
        }

        /**
         * Gets the value of the content property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContent() {
            return content;
        }

        /**
         * Sets the value of the content property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContent(String value) {
            this.content = value;
        }

        /**
         * Gets the value of the url property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUrl() {
            return url;
        }

        /**
         * Sets the value of the url property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUrl(String value) {
            this.url = value;
        }

        /**
         * Gets the value of the attachment property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the attachment property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAttachment().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MonitorResult.Log.Attachment }
         * 
         * 
         */
        public List<MonitorResult.Log.Attachment> getAttachment() {
            if (attachment == null) {
                attachment = new ArrayList<MonitorResult.Log.Attachment>();
            }
            return this.attachment;
        }

        /**
         * Gets the value of the gatherTime property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGatherTime() {
            return gatherTime;
        }

        /**
         * Sets the value of the gatherTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGatherTime(String value) {
            this.gatherTime = value;
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
         *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="file" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "title",
            "file"
        })
        public static class Attachment {

            @XmlElement(required = true)
            protected String title;
            @XmlElement(required = true)
            protected String file;

            /**
             * Gets the value of the title property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTitle() {
                return title;
            }

            /**
             * Sets the value of the title property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTitle(String value) {
                this.title = value;
            }

            /**
             * Gets the value of the file property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFile() {
                return file;
            }

            /**
             * Sets the value of the file property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFile(String value) {
                this.file = value;
            }

        }

    }

}