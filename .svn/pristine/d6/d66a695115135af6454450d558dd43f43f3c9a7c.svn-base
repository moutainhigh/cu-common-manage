package com.aotain.cu.serviceapi.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseDTO implements Serializable {

	private static final long serialVersionUID = -1000309400345512646L;

	// 是否分页(0-不分页，1-分页)，如果不分页则返回全部数据,默认是分页的
	private Integer isPaging = 1;
	// 页索引
	private Integer pageIndex = 1;
	// 页大小，即每页显示的记录数量
	private Integer pageSize = 10;
	// 是否需要统计记录数(0-不 统计，1-统计)，默认统计
	private Integer isCount = 1;
	// 统计记录数
	private Integer totalCounts;
	// 排序字段
	private String sortName;
	// 排序类型
	private String sortOrder;
	private List<?> resultList;
	
	private String otherConditions;
	
	private String countSql;
	
	private Integer successFlag = 0; 
	
	private Integer reportType; //上报类型（0-级联上报、1-单独上报，2-下级信息上报（用户、机房、服务，占用机房）
	
	private Integer delFlag = 0; //删除标志
	
	private String userHouseIDStrs;//操作者所属机房
	
	private List<Long> userHouseIDSList;
	
	private String houseIDs;//导出所属机房
	
	private String accountAreaCode;//账户携带地市码信息
	
	/**
	 * CU version 4.0
	 * 地市码信息
	 */
	private String areaCode;
	/**
	 * CU version 4.0
	 * 用户帐号的地市信息
	 */
	private List<Long> cityCodeList = new ArrayList<Long>();
	
	private Integer userLevel;
	
	private Integer operateType;//操作类型 1-新增|2-修改|3-删除
	
	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	public Integer getUserLevel() {
		//return SecurityUtils.getAuthenticatedUser().getAccount().getUserLevel(); 
		return userLevel; 
	} 
	
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public BaseDTO() {		
	}

	public BaseDTO(Integer isPaging, Integer isCount, String sortName) {
		super();
		this.isPaging = isPaging;
		this.isCount = isCount;
		this.sortName = sortName;
	}

	public Integer getIsPaging() {
		return isPaging;
	}

	public void setIsPaging(Integer isPaging) {
		this.isPaging = isPaging;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getIsCount() {
		return isCount;
	}

	public void setIsCount(Integer isCount) {
		this.isCount = isCount;
	}

	public Integer getTotalCounts() {
		return totalCounts;
	}

	public void setTotalCounts(Integer totalCounts) {
		this.totalCounts = totalCounts;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public List<?> getResultList() {
		return resultList;
	}

	public void setResultList(List<?> resultList) {
		this.resultList = resultList;
	}

	public String getOtherConditions() {
		return otherConditions;
	}

	public void setOtherConditions(String otherConditions) {
		this.otherConditions = otherConditions;
	}

	public Integer getSuccessFlag() {
		return successFlag;
	}

	public void setSuccessFlag(Integer successFlag) {
		this.successFlag = successFlag;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getReportType() {
		return reportType;
	}

	public void setReportType(Integer reportType) {
		this.reportType = reportType;
	}

	public String getCountSql() {
		return countSql;
	}

	public void setCountSql(String countSql) {
		this.countSql = countSql;
	}

	public String getUserHouseIDStrs() {
		return userHouseIDStrs;
	}

	public void setUserHouseIDStrs(String userHouseIDStrs) {
		this.userHouseIDStrs = userHouseIDStrs;
	}

	public List<Long> getUserHouseIDSList() {
		return userHouseIDSList;
	}

	public void setUserHouseIDSList(List<Long> userHouseIDSList) {
		this.userHouseIDSList = userHouseIDSList;
	}

	public String getHouseIDs() {
		return houseIDs;
	}

	public void setHouseIDs(String houseIDs) {
		this.houseIDs = houseIDs;
	}

	public List<Long> getCityCodeList() { 
		return cityCodeList;
	}

	public void setCityCodeList(List<Long> cityCodeList) {
		this.cityCodeList = cityCodeList;
	}

	public String getAccountAreaCode() {
		return accountAreaCode;
	}

	public void setAccountAreaCode(String accountAreaCode) {
		this.accountAreaCode = accountAreaCode;
	}

	public Integer getOperateType() {
		return operateType;
	}

	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}

	
}
