package com.aotain.cu.serviceapi.dto;

import java.io.Serializable;

public class UserIpInformationDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = -3516958239601176601L;
	
	private Long providerId;
	
	private Long userId;
	
	private String userCode;
	
	private Long houseId; 
	
	private Long hhId;
	
	private Long ipsegId;
	
	private String unitName; 

	private Integer business; 
	
	private String houseName; 
	
	private String distributeTime;
	
	private Long bandWidth;
	
	private Long selIpTrans;
	
	private String startIP; 
	
	private String decimalStartIP;
	
	private String endIP;
	
	private String decimalEndIP;
	
	
	public UserIpInformationDTO() {
		super();
	}
	
	public UserIpInformationDTO(Integer isPaging, Integer isCount, String sortName) {
		super(isPaging, isCount, sortName);
	}

	public Long getProviderId() {
		return providerId;
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public Long getHouseId() {
		return houseId;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}

	public Long getHhId() {
		return hhId;
	}

	public void setHhId(Long hhId) {
		this.hhId = hhId;
	}

	public Long getIpsegId() {
		return ipsegId;
	}

	public void setIpsegId(Long ipsegId) {
		this.ipsegId = ipsegId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Integer getBusiness() {
		return business;
	}

	public void setBusiness(Integer business) {
		this.business = business;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getDistributeTime() {
		return distributeTime;
	}

	public void setDistributeTime(String distributeTime) {
		this.distributeTime = distributeTime;
	}

	public Long getBandWidth() {
		return bandWidth;
	}

	public void setBandWidth(Long bandWidth) {
		this.bandWidth = bandWidth;
	}

	public Long getSelIpTrans() {
		return selIpTrans;
	}

	public void setSelIpTrans(Long selIpTrans) {
		this.selIpTrans = selIpTrans;
	}

	public String getStartIP() {
		return startIP;
	}

	public void setStartIP(String startIP) {
		this.startIP = startIP;
	}

	public String getDecimalStartIP() {
		return decimalStartIP;
	}

	public void setDecimalStartIP(String decimalStartIP) {
		this.decimalStartIP = decimalStartIP;
	}

	public String getEndIP() {
		return endIP;
	}

	public void setEndIP(String endIP) {
		this.endIP = endIP;
	}

	public String getDecimalEndIP() {
		return decimalEndIP;
	}

	public void setDecimalEndIP(String decimalEndIP) {
		this.decimalEndIP = decimalEndIP;
	}
}
