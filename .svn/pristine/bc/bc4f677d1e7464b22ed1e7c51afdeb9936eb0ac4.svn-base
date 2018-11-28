package com.aotain.cu.serviceapi.dto;

import java.io.Serializable;
import java.util.List;

import com.aotain.cu.annotation.ExpSheet;
import com.aotain.cu.annotation.Export;
import com.aotain.cu.serviceapi.model.HouseFrameInformation;

@ExpSheet(name = "机房机架信息")
public class HouseFrameInformationDTO extends HouseFrameInformation implements Serializable {

	private static final long serialVersionUID = 818097335398702362L;

	@Export(title = "机房名称", id = 1)
	private String houseName; // 机房名称

	@Export(title = "使用类型", id = 5)
	private String useTypeStr; // 使用类型(1-自用，2-租用)

	@Export(title = "分配状态", id = 3)
	private String distributionStr; // 分配状态(1-未分配 、2-已分配)

	@Export(title = "占用状态", id = 4)
	private String occupancyStr; // 占用状态(1-未占用 、2-已占用)\

	private String unitName;// 单位名称

	private String preUseType;// 变更前使用类型

	private Integer dealFlagHouse;// 机房主体处理状态

	private String startDate;// 查询开始时间

	private String endDate;// 查询结束时间

	private List<String> unitNameList;// 单位名称
	
	private Long rptFrameId;
	
	private Long rptHouseId;
	
	private String rptFrameName;
	
	private Integer rptUseType; 
	
	private Integer rptDistribution; 
	
	private Integer rptOccupancy; 
	
	private String rptFrameNo;
	
	private String rptUnitName;

	public List<String> getUnitNameList() {
		return unitNameList;
	}

	public void setUnitNameList(List<String> unitNameList) {
		this.unitNameList = unitNameList;
	}

	public String getPreUseType() {
		return preUseType;
	}

	public void setPreUseType(String preUseType) {
		this.preUseType = preUseType;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getHouseName() {
		return houseName;
	}

	public String getUseTypeStr() {
		return useTypeStr;
	}

	public String getDistributionStr() {
		return distributionStr;
	}

	public String getOccupancyStr() {
		return occupancyStr;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public void setUseTypeStr(String useTypeStr) {
		this.useTypeStr = useTypeStr;
	}

	public void setDistributionStr(String distributionStr) {
		this.distributionStr = distributionStr;
	}

	public void setOccupancyStr(String occupancyStr) {
		this.occupancyStr = occupancyStr;
	}

	public Integer getDealFlagHouse() {
		return dealFlagHouse;
	}

	public void setDealFlagHouse(Integer dealFlagHouse) {
		this.dealFlagHouse = dealFlagHouse;
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

	public Long getRptFrameId() {
		return rptFrameId;
	}

	public Long getRptHouseId() {
		return rptHouseId;
	}

	public String getRptFrameName() {
		return rptFrameName;
	}

	public Integer getRptUseType() {
		return rptUseType;
	}

	public Integer getRptDistribution() {
		return rptDistribution;
	}

	public Integer getRptOccupancy() {
		return rptOccupancy;
	}

	public String getRptFrameNo() {
		return rptFrameNo;
	}

	public void setRptFrameId(Long rptFrameId) {
		this.rptFrameId = rptFrameId;
	}

	public void setRptHouseId(Long rptHouseId) {
		this.rptHouseId = rptHouseId;
	}

	public void setRptFrameName(String rptFrameName) {
		this.rptFrameName = rptFrameName;
	}

	public void setRptUseType(Integer rptUseType) {
		this.rptUseType = rptUseType;
	}

	public void setRptDistribution(Integer rptDistribution) {
		this.rptDistribution = rptDistribution;
	}

	public void setRptOccupancy(Integer rptOccupancy) {
		this.rptOccupancy = rptOccupancy;
	}

	public void setRptFrameNo(String rptFrameNo) {
		this.rptFrameNo = rptFrameNo;
	}

	public String getRptUnitName() {
		return rptUnitName;
	}

	public void setRptUnitName(String rptUnitName) {
		this.rptUnitName = rptUnitName;
	}
	
}
