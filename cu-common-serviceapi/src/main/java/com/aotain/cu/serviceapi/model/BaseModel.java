package com.aotain.cu.serviceapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.aotain.cu.serviceapi.model.permission.DataPermissionSetting;
import com.aotain.cu.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;


public class BaseModel {

    /** true-不需要根据权限过滤  false-需要根据权限过滤(默认为false，web可不赋值)*/
    @Transient
    private boolean authFilter;

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

    // 结果集合
    private List<?> resultList;

    // 查询条件
    private String otherConditions;

    // 统计sql
    private String countSql;

    // 成功标识
    private Integer successFlag = 0;

    // 上报类型（0-级联上报、1-单独上报，2-下级信息上报（用户、机房、服务，占用机房）
    private Integer reportType;

    // 操作者所属机房
    private String userHouseIDStrs;

    private List<Long> userHouseIDSList;

    // 导出所属机房
    private String houseIDs;

    // 账户携带地市码信息
    private String accountAreaCode;

    //	地市码信息
    private String areaCode;
    
    private String rptAreaCode;

    //	用户帐号的地市信息
    private List<String> cityCodeList = new ArrayList<String>();
    //用户账号携带的隶属码信息，逗号分隔的
    private String areaCodes;
    //	用户帐号的机房信息
    private List<String> userAuthHouseList = new ArrayList<String>();
    // 用户账号携带的机房信息，逗号分隔的
    private String authHouses;
    //	用户帐号的专线标识信息
    private List<String> userAuthIdentityList = new ArrayList<String>();
    // 用户账号携带的专线机标识信息，逗号分隔的
    private String authIdentities;

    //  用户账号等级
    private Integer userLevel;

    // 操作类型 1-新增|2-变更|3-删除
    private Integer operateType;

    // 操作类型 1-新增|2-变更|3-删除
    private Integer czlx;

    //删除标志（0-未删除、1-已删除）
    private Integer delFlag;

    // 处理标记
    private Integer dealFlag;

    // 创建人ID
    private Integer createUserId;

    // 更新人的ID
    private Integer updateUserId;

    // 创建时间
    private Date createTime;

    // 修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    // 信息是否完整
    private String infoComplete;

    // 存储核验错误信息 VERIFICATION_RESULT
    private String verificationResult;

    private Long submitId;

    private Long houseseqId;

    private Long userSeqId;

    // 专线标识，1-IDC、2-ISP、3-IDC/ISP、4-CDN、5-专线
    private Integer identity;

    //要绑定的策略类型
    private Integer messageType;
    //要绑定的策略号
    private Integer bindMessageNo;

    private Long clusterId;

    /**
     * 1-单独新增 2-联合新增 3-导入
     **/
    private Integer addType;

    /** 1-校验地市码  2-不校验地市码  */
    /**
     * 机房预审时，通用机房数据的校验，忽略地市码和账号携带地市码信息的校验
     */
    private Integer areaCodeValidateType = 1;

    /**
     * 页面新增修改提示用
     **/
    private Integer outIndex;

    private Integer innerIndex;
    /**
     * 判断是否回退 0:忽略回退操作,else:不能忽略回退操作
     */
    private Integer isRevoke;

    private String identify;

    private String clientId;

    //用户导入,只有用户名
    private String userName;

    /**
     * 记录在文件中的行号。
     */
    private String fileRowsNumber;

    /**
     * 文件名称
     */
    private String etlFileName;
    
    /**
	 * 机房的分权分域数据信息
	 */
	//分权分域数据ID
	private Integer dataPermissionId;
	//系统IP
    private Integer appId;
    //分权分域字段
    private String dataPermissionToken;
    //分权分域显示名称
    private String dataPermissionName;
    //分权分域显示备注
    private String dataPermissionDesc;
    
    private String permissionMethodUrl;
    
    private String userToken;
    
    private List<DataPermissionSetting> dataPermissionSettingList;

    public void setFileRowsNumber(String fileRowsNumber) {
        this.fileRowsNumber = fileRowsNumber;
    }

    public void setEtlFileName(String etlFileName) {
        this.etlFileName = etlFileName;
    }

    public String getFileRowsNumber() {
        return fileRowsNumber;
    }

    public String getEtlFileName() {
        return etlFileName;
    }

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

    public Integer getIsPaging() {
        return isPaging;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getIsCount() {
        return isCount;
    }

    public Integer getTotalCounts() {
        return totalCounts;
    }

    public String getSortName() {
        return sortName;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public List<?> getResultList() {
        return resultList;
    }

    public String getOtherConditions() {
        return otherConditions;
    }

    public String getCountSql() {
        return countSql;
    }

    public Integer getSuccessFlag() {
        return successFlag;
    }

    public Integer getReportType() {
        return reportType;
    }

    public String getUserHouseIDStrs() {
        return userHouseIDStrs;
    }

    public List<Long> getUserHouseIDSList() {
        return userHouseIDSList;
    }

    public String getHouseIDs() {
        return houseIDs;
    }

    public String getAccountAreaCode() {
        return accountAreaCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public List<String> getCityCodeList() {
        return cityCodeList;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public Integer getDealFlag() {
        return dealFlag;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setIsPaging(Integer isPaging) {
        this.isPaging = isPaging;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setIsCount(Integer isCount) {
        this.isCount = isCount;
    }

    public void setTotalCounts(Integer totalCounts) {
        this.totalCounts = totalCounts;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public void setResultList(List<?> resultList) {
        this.resultList = resultList;
    }

    public void setOtherConditions(String otherConditions) {
        this.otherConditions = otherConditions;
    }

    public void setCountSql(String countSql) {
        this.countSql = countSql;
    }

    public void setSuccessFlag(Integer successFlag) {
        this.successFlag = successFlag;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    public void setUserHouseIDStrs(String userHouseIDStrs) {
        this.userHouseIDStrs = userHouseIDStrs;
    }

    public void setUserHouseIDSList(List<Long> userHouseIDSList) {
        this.userHouseIDSList = userHouseIDSList;
    }

    public void setHouseIDs(String houseIDs) {
        this.houseIDs = houseIDs;
    }

    public void setAccountAreaCode(String accountAreaCode) {
        this.accountAreaCode = accountAreaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public void setCityCodeList(List<String> cityCodeList) {
        this.cityCodeList = cityCodeList;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    public void setDealFlag(Integer dealFlag) {
        this.dealFlag = dealFlag;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getInfoComplete() {
        return infoComplete;
    }

    public void setInfoComplete(String infoComplete) {
        this.infoComplete = infoComplete;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public Integer getBindMessageNo() {
        return bindMessageNo;
    }

    public Long getClusterId() {
        return clusterId;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public void setBindMessageNo(Integer bindMessageNo) {
        this.bindMessageNo = bindMessageNo;
    }

    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    public Integer getCzlx() {
        return czlx;
    }

    public void setCzlx(Integer czlx) {
        this.czlx = czlx;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getVerificationResult() {
        return verificationResult;
    }

    public void setVerificationResultWithTimestamp(String verificationResult) {
    	// 核验结果需要加上时间
		if (null == verificationResult || "".equals(verificationResult.trim())) {
			this.verificationResult = verificationResult;
			return;
		}
		String[] lines = verificationResult.split("\\r?\\n");
		if(lines == null || lines.length == 0){
			this.verificationResult = "";
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (String line : lines) {
			if (null == line || "".equals(line.trim())) {
				continue;
			}
			if (sb.length() > 0) {
				sb.append("\r\n");
			}
			line = line.trim();
			if (line.matches("^\\d{4}-\\d{2}-\\d{2}.*")) {
				sb.append(line);
			} else {
				sb.append(DateUtils.formatCurrDateyyyyMMddHHmmss() + " " + line);
			}
		}
		this.verificationResult = sb.toString();
    }
    
    public void setVerificationResult(String verificationResult) {
			this.verificationResult = verificationResult;
    }

    public Long getSubmitId() {
        return submitId;
    }

    public void setSubmitId(Long submitId) {
        this.submitId = submitId;
    }

    public Long getHouseseqId() {
        return houseseqId;
    }

    public void setHouseseqId(Long houseseqId) {
        this.houseseqId = houseseqId;
    }

    public Long getUserSeqId() {
        return userSeqId;
    }

    public void setUserSeqId(Long userSeqId) {
        this.userSeqId = userSeqId;
    }

    public Integer getAddType() {
        return addType;
    }

    public void setAddType(Integer addType) {
        this.addType = addType;
    }

    public Integer getIsRevoke() {
        return isRevoke;
    }

    public void setIsRevoke(Integer isRevoke) {
        this.isRevoke = isRevoke;
    }

    public Integer getAreaCodeValidateType() {
        return areaCodeValidateType;
    }

    public void setAreaCodeValidateType(Integer areaCodeValidateType) {
        this.areaCodeValidateType = areaCodeValidateType;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getUserAuthHouseList() {
        return userAuthHouseList;
    }

    public void setUserAuthHouseList(List<String> userAuthHouseList) {
        this.userAuthHouseList = userAuthHouseList;
    }

    public List<String> getUserAuthIdentityList() {
        return userAuthIdentityList;
    }

    public void setUserAuthIdentityList(List<String> userAuthIdentityList) {
        this.userAuthIdentityList = userAuthIdentityList;
    }

    public String getAreaCodes() {
        return areaCodes;
    }

    public String getAuthHouses() {
        return authHouses;
    }

    public String getAuthIdentities() {
        return authIdentities;
    }

    public void setAreaCodes(String areaCodes) {
		String str = StringUtils.join(this.cityCodeList, ",");
		if (areaCodes == null) {
			this.areaCodes = str;
		} else {
			this.areaCodes = areaCodes;
		}
	}

    public void setAuthHouses(String authHouses) {
		String str = StringUtils.join(this.userAuthHouseList, ",");
		if (authHouses == null) {
			this.authHouses = str;
		} else {
			this.authHouses = authHouses;
		}
	}

    public void setAuthIdentities(String authIdentities) {
		String str = StringUtils.join(this.userAuthIdentityList, ",");
		if (authIdentities == null) {
			this.authIdentities = str;
		} else {
			this.authIdentities = authIdentities;
		}
	}

	public Integer getDataPermissionId() {
		return dataPermissionId;
	}

	public Integer getAppId() {
		return appId;
	}

	public String getDataPermissionToken() {
		return dataPermissionToken;
	}

	public String getDataPermissionName() {
		return dataPermissionName;
	}

	public String getDataPermissionDesc() {
		return dataPermissionDesc;
	}

	public void setDataPermissionId(Integer dataPermissionId) {
		this.dataPermissionId = dataPermissionId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public void setDataPermissionToken(String dataPermissionToken) {
		this.dataPermissionToken = dataPermissionToken;
	}

	public void setDataPermissionName(String dataPermissionName) {
		this.dataPermissionName = dataPermissionName;
	}

	public void setDataPermissionDesc(String dataPermissionDesc) {
		this.dataPermissionDesc = dataPermissionDesc;
	}

	public String getPermissionMethodUrl() {
		return permissionMethodUrl;
	}

	public void setPermissionMethodUrl(String permissionMethodUrl) {
		this.permissionMethodUrl = permissionMethodUrl;
	}

    public boolean getAuthFilter() {
        return authFilter;
    }

    public void setAuthFilter(boolean authFilter) {
        this.authFilter = authFilter;
    }

	public List<DataPermissionSetting> getDataPermissionSettingList() {
		return dataPermissionSettingList;
	}

	public void setDataPermissionSettingList(List<DataPermissionSetting> dataPermissionSettingList) {
		this.dataPermissionSettingList = dataPermissionSettingList;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getRptAreaCode() {
		return rptAreaCode;
	}

	public void setRptAreaCode(String rptAreaCode) {
		this.rptAreaCode = rptAreaCode;
	}

}
