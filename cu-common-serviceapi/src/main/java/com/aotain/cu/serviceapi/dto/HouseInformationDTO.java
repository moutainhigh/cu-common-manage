package com.aotain.cu.serviceapi.dto;

import java.io.Serializable;

import com.aotain.cu.annotation.ExpSheet;
import com.aotain.cu.annotation.Export;
import com.aotain.cu.serviceapi.model.HouseInformation;

@ExpSheet(name="机房主体信息")
public class HouseInformationDTO extends HouseInformation implements Serializable {

	private static final long serialVersionUID = 3533267188941121349L;
	
	@Export(title="经营者名称", id=1)
	private String providerName; //经营者名称
	
	@Export(title="专线标识", id=4)
	private String identifyStr; //专线标识（1-专线、2-非专线）
	
	@Export(title="机房性质", id=5)
	private String houseTypeStr; //机房性质（1——租用、2——自建，999——其他）
	
	@Export(title="网络信息安全责任人证件类型", id=8)
	private String houseOfficerIdTypeStr; //机房负责人-人员的证件类型(有效类型只有：2-身份证、7-护照、8-军官证，9-台胞证）

	private String startDate;//查询开始时间

	private String endDate;//查询结束时间

	private String preHouseName;//变更之前机房名称

	private String provinceName;//省级名称

	private String cityName;//市级名称

	private String countyName;//县级名称

	private Integer outIndex;

	private Integer innerIndex;
	
	private Long rptHouseId;

	private String rptHouseIdStr;

	private String rptHouseName; 

	private Integer rptHouseType;

	private Integer rptHouseProvince; 

	private Integer rptHouseCity; 

	private Integer rptHouseCounty; 

	private String rptHouseAddress; 

	private String rptHouseZipCode; 

	private String rptHouseOfficerName;

	private Integer rptHouseOfficerIdType;

	private String rptHouseOfficerId; 

	private String rptHouseOfficerTelephone;

	private String rptHouseOfficerMobile; 

	private String rptHouseOfficerEmail; 
	
	private String rptIdentity;
	
	private String rptProvinceName; 

	private String rptCityName; 

	private String rptCountyName;
	
	public Integer getOutIndex() {
		return outIndex;
	}

	public void setOutIndex(Integer outIndex) {
		this.outIndex = outIndex;
	}

	public Integer getInnerIndex() {
		return innerIndex;
	}

	public void setInnerIndex(Integer innerIndex) {
		this.innerIndex = innerIndex;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getPreHouseName() {
		return preHouseName;
	}

	public void setPreHouseName(String preHouseName) {
		this.preHouseName = preHouseName;
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

	public String getProviderName() {
		return providerName;
	}

	public String getIdentifyStr() {
		return identifyStr;
	}

	public String getHouseTypeStr() {
		return houseTypeStr;
	}

	public String getHouseOfficerIdTypeStr() {
		return houseOfficerIdTypeStr;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public void setIdentifyStr(String identifyStr) {
		this.identifyStr = identifyStr;
	}

	public void setHouseTypeStr(String houseTypeStr) {
		this.houseTypeStr = houseTypeStr;
	}

	public void setHouseOfficerIdTypeStr(String houseOfficerIdTypeStr) {
		this.houseOfficerIdTypeStr = houseOfficerIdTypeStr;
	}

	public Long getRptHouseId() {
		return rptHouseId;
	}

	public String getRptHouseIdStr() {
		return rptHouseIdStr;
	}

	public String getRptHouseName() {
		return rptHouseName;
	}

	public Integer getRptHouseType() {
		return rptHouseType;
	}

	public Integer getRptHouseProvince() {
		return rptHouseProvince;
	}

	public Integer getRptHouseCity() {
		return rptHouseCity;
	}

	public Integer getRptHouseCounty() {
		return rptHouseCounty;
	}

	public String getRptHouseAddress() {
		return rptHouseAddress;
	}

	public String getRptHouseZipCode() {
		return rptHouseZipCode;
	}

	public String getRptHouseOfficerName() {
		return rptHouseOfficerName;
	}

	public Integer getRptHouseOfficerIdType() {
		return rptHouseOfficerIdType;
	}

	public String getRptHouseOfficerId() {
		return rptHouseOfficerId;
	}

	public String getRptHouseOfficerTelephone() {
		return rptHouseOfficerTelephone;
	}

	public String getRptHouseOfficerMobile() {
		return rptHouseOfficerMobile;
	}

	public String getRptHouseOfficerEmail() {
		return rptHouseOfficerEmail;
	}

	public String getRptIdentity() {
		return rptIdentity;
	}

	public void setRptHouseId(Long rptHouseId) {
		this.rptHouseId = rptHouseId;
	}

	public void setRptHouseIdStr(String rptHouseIdStr) {
		this.rptHouseIdStr = rptHouseIdStr;
	}

	public void setRptHouseName(String rptHouseName) {
		this.rptHouseName = rptHouseName;
	}

	public void setRptHouseType(Integer rptHouseType) {
		this.rptHouseType = rptHouseType;
	}

	public void setRptHouseProvince(Integer rptHouseProvince) {
		this.rptHouseProvince = rptHouseProvince;
	}

	public void setRptHouseCity(Integer rptHouseCity) {
		this.rptHouseCity = rptHouseCity;
	}

	public void setRptHouseCounty(Integer rptHouseCounty) {
		this.rptHouseCounty = rptHouseCounty;
	}

	public void setRptHouseAddress(String rptHouseAddress) {
		this.rptHouseAddress = rptHouseAddress;
	}

	public void setRptHouseZipCode(String rptHouseZipCode) {
		this.rptHouseZipCode = rptHouseZipCode;
	}

	public void setRptHouseOfficerName(String rptHouseOfficerName) {
		this.rptHouseOfficerName = rptHouseOfficerName;
	}

	public void setRptHouseOfficerIdType(Integer rptHouseOfficerIdType) {
		this.rptHouseOfficerIdType = rptHouseOfficerIdType;
	}

	public void setRptHouseOfficerId(String rptHouseOfficerId) {
		this.rptHouseOfficerId = rptHouseOfficerId;
	}

	public void setRptHouseOfficerTelephone(String rptHouseOfficerTelephone) {
		this.rptHouseOfficerTelephone = rptHouseOfficerTelephone;
	}

	public void setRptHouseOfficerMobile(String rptHouseOfficerMobile) {
		this.rptHouseOfficerMobile = rptHouseOfficerMobile;
	}

	public void setRptHouseOfficerEmail(String rptHouseOfficerEmail) {
		this.rptHouseOfficerEmail = rptHouseOfficerEmail;
	}

	public void setRptIdentity(String rptIdentity) {
		this.rptIdentity = rptIdentity;
	}

	public String getRptProvinceName() {
		return rptProvinceName;
	}

	public String getRptCityName() {
		return rptCityName;
	}

	public String getRptCountyName() {
		return rptCountyName;
	}

	public void setRptProvinceName(String rptProvinceName) {
		this.rptProvinceName = rptProvinceName;
	}

	public void setRptCityName(String rptCityName) {
		this.rptCityName = rptCityName;
	}

	public void setRptCountyName(String rptCountyName) {
		this.rptCountyName = rptCountyName;
	}
	
}
