package com.aotain.cu.serviceapi.dto;

import java.io.Serializable;
import java.util.Date;

import com.aotain.cu.annotation.Export;

public class UserHHInformationDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = -691592493153973578L;
	
	private Long hhId;
	
	private Long houseId; //占用机房ID
	
	@Export(title="机房名称", id=1)
	private String houseName; //机房名称
	
	private Long userId; //用户ID
	
	@Export(title="单位名称（用户）", id=2)
	private String unitName; //单位名称
	
	private String houseNo; //占用机房编号
	
	private String frameIds; //机架ID
	
	private String frameNames; //机架名称
	
	private String frameNos; //机架编号
	
	@Export(title="资源分配日期", id=3)
	private String distributeTime; //资源分配时间，采用yyyy-MM-dd的格式
	
	@Export(title="网络带宽(Mbps)", id=4)
	private Long bandWidth; //网络带宽（单位：Mbps)
	
	private Integer operationType; //操作类型（0-完成记录、1-新增、2-修改(变更)，3-删除）
	
	private Integer dealFlag; //处理状态（0-未上报、1-提交上报、2-接口文件已经生成、3-文件生成失败，4-上报成功）
	
	private Date creationDate; //创建日期
	
	private Date updateDate; //更新日期
	
	private String infoComplete; //信息是否完整
	
	private String beginDistributeTime; //起始资源分配日期
	
	private String endDistributeTime; //终止资源分配日期
	
	private HouseInformationDTO houseInfo;
	public Long getHhId() {
		return hhId;
	}

	public Long getHouseId() {
		return houseId;
	}

	public String getHouseName() {
		return houseName;
	}

	public Long getUserId() {
		return userId;
	}

	public String getUnitName() {
		return unitName;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public String getFrameIds() {
		return frameIds;
	}

	public String getFrameNames() {
		return frameNames;
	}

	public String getFrameNos() {
		return frameNos;
	}

	public String getDistributeTime() {
		return distributeTime;
	}

	public Long getBandWidth() {
		return bandWidth;
	}

	public Integer getOperationType() {
		return operationType;
	}

	public Integer getDealFlag() {
		return dealFlag;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public String getInfoComplete() {
		return infoComplete;
	}

	public String getBeginDistributeTime() {
		return beginDistributeTime;
	}

	public String getEndDistributeTime() {
		return endDistributeTime;
	}

	public void setHhId(Long hhId) {
		this.hhId = hhId;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public void setFrameIds(String frameIds) {
		this.frameIds = frameIds;
	}

	public void setFrameNames(String frameNames) {
		this.frameNames = frameNames;
	}

	public void setFrameNos(String frameNos) {
		this.frameNos = frameNos;
	}

	public void setDistributeTime(String distributeTime) {
		this.distributeTime = distributeTime;
	}

	public void setBandWidth(Long bandWidth) {
		this.bandWidth = bandWidth;
	}

	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}

	public void setDealFlag(Integer dealFlag) {
		this.dealFlag = dealFlag;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public void setInfoComplete(String infoComplete) {
		this.infoComplete = infoComplete;
	}

	public void setBeginDistributeTime(String beginDistributeTime) {
		this.beginDistributeTime = beginDistributeTime;
	}

	public void setEndDistributeTime(String endDistributeTime) {
		this.endDistributeTime = endDistributeTime;
	}

	public HouseInformationDTO getHouseInfo() {
		return houseInfo;
	}

	public void setHouseInfo(HouseInformationDTO houseInfo) {
		this.houseInfo = houseInfo;
	}

	
}
