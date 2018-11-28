package com.aotain.cu.serviceapi.dto;

import java.io.Serializable;
import java.util.Objects;

import com.aotain.cu.annotation.ExpSheet;
import com.aotain.cu.annotation.Export;
import com.aotain.cu.serviceapi.model.UserServiceInformation;

@ExpSheet(name="用户服务信息")
public class UserServiceInformationDTO extends UserServiceInformation implements Serializable {

	private static final long serialVersionUID = -1340024456694142454L;

	@Export(title="单位名称（用户）", id=2)
	private String unitName; //单位名称

	private String domainName;//服务域名

	private String startDate;

	private String endDate;

	private String clientId;//客户ID  网管接口字段 在用户表值唯一

	private String serviceIdStr;

	private Integer userDealFlag;//用户处理状态

	private Integer rptSetmode;//以前的接入方式

	private Integer idType; // 证件类型

	private String idNumber; // 证件号码

	private Integer unitNature; // 单位属性
	
	private Long rptServiceId;

    private Long rptUserId;

    private String rptServiceContent;

    private String rptRegisterId;

    private Integer rptBusiness;

    private Integer rptRegType;

	public Integer getUserDealFlag() {
		return userDealFlag;
	}

	public void setUserDealFlag(Integer userDealFlag) {
		this.userDealFlag = userDealFlag;
	}

	public Integer getRptSetmode() {
		return rptSetmode;
	}

	public void setRptSetmode(Integer rptSetmode) {
		this.rptSetmode = rptSetmode;
	}

	public String getServiceIdStr() {
		return serviceIdStr;
	}

	public void setServiceIdStr(String serviceIdStr) {
		this.serviceIdStr = serviceIdStr;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Integer getIdType() {
		return idType;
	}

	public void setIdType( Integer idType ) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber( String idNumber ) {
		this.idNumber = idNumber;
	}

	public Integer getUnitNature() {
		return unitNature;
	}

	public void setUnitNature( Integer unitNature ) {
		this.unitNature = unitNature;
	}

	public int UserHashCode() {
		return Objects.hash(unitName, idType, idNumber);
	}

	public Long getRptServiceId() {
		return rptServiceId;
	}

	public Long getRptUserId() {
		return rptUserId;
	}

	public String getRptServiceContent() {
		return rptServiceContent;
	}

	public String getRptRegisterId() {
		return rptRegisterId;
	}

	public Integer getRptBusiness() {
		return rptBusiness;
	}

	public Integer getRptRegType() {
		return rptRegType;
	}

	public void setRptServiceId(Long rptServiceId) {
		this.rptServiceId = rptServiceId;
	}

	public void setRptUserId(Long rptUserId) {
		this.rptUserId = rptUserId;
	}

	public void setRptServiceContent(String rptServiceContent) {
		this.rptServiceContent = rptServiceContent;
	}

	public void setRptRegisterId(String rptRegisterId) {
		this.rptRegisterId = rptRegisterId;
	}

	public void setRptBusiness(Integer rptBusiness) {
		this.rptBusiness = rptBusiness;
	}

	public void setRptRegType(Integer rptRegType) {
		this.rptRegType = rptRegType;
	}
	
}
