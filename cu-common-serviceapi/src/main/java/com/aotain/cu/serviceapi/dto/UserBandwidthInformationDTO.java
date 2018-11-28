package com.aotain.cu.serviceapi.dto;

import java.io.Serializable;
import java.util.Objects;

import com.aotain.cu.serviceapi.model.UserBandwidthInformation;

public class UserBandwidthInformationDTO extends UserBandwidthInformation implements Serializable {

	private static final long serialVersionUID = -3167326800037683494L;

	private String houseName;//机房名称

	private String startDate;

	private String endDate;

	private Integer idType; // 证件类型

	private String idNumber; // 证件号码
	
	private Long rptHhId; 
    
    private Long rptUserId; 

    private Long rptHouseId; 
    
    private String rptDistributeTime; 
    
    private Long rptBandWidth; 
    
	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
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

	public int UserHashCode() {
		return Objects.hash(this.getUnitName(), idType, idNumber);
	}

	public Long getRptHhId() {
		return rptHhId;
	}

	public Long getRptUserId() {
		return rptUserId;
	}

	public Long getRptHouseId() {
		return rptHouseId;
	}

	public String getRptDistributeTime() {
		return rptDistributeTime;
	}

	public Long getRptBandWidth() {
		return rptBandWidth;
	}

	public void setRptHhId(Long rptHhId) {
		this.rptHhId = rptHhId;
	}

	public void setRptUserId(Long rptUserId) {
		this.rptUserId = rptUserId;
	}

	public void setRptHouseId(Long rptHouseId) {
		this.rptHouseId = rptHouseId;
	}

	public void setRptDistributeTime(String rptDistributeTime) {
		this.rptDistributeTime = rptDistributeTime;
	}

	public void setRptBandWidth(Long rptBandWidth) {
		this.rptBandWidth = rptBandWidth;
	}

}
