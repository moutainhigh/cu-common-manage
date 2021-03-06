package com.aotain.cu.serviceapi.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class UserBandwidthInformation extends BaseModel implements Serializable {
    
	private static final long serialVersionUID = 6812909883459906502L;

	private Long hhId; //占用机房ID
    
    private Long userId; // 用户ID

    private Long houseId; // 机房ID
    
    private String distributeTime; //资源分配时间，采用yyyy-MM-dd的格式
    
    private Long bandWidth; //网络带宽（单位：Mbps)
    
    private String unitName;//单位名称

	private List<HouseIPSegmentInformation> houseIPSegmentInformationList;

	public Long getHhId() {
		return hhId;
	}

	public Long getUserId() {
		return userId;
	}

	public Long getHouseId() {
		return houseId;
	}

	public String getDistributeTime() {
		return distributeTime;
	}

	public Long getBandWidth() {
		return bandWidth;
	}

	public void setHhId(Long hhId) {
		this.hhId = hhId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}

	public void setDistributeTime(String distributeTime) {
		this.distributeTime = distributeTime;
	}

	public void setBandWidth(Long bandWidth) {
		this.bandWidth = bandWidth;
	}
	
	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public List<HouseIPSegmentInformation> getHouseIPSegmentInformationList() {
		return houseIPSegmentInformationList;
	}

	public void setHouseIPSegmentInformationList(List<HouseIPSegmentInformation> houseIPSegmentInformationList) {
		this.houseIPSegmentInformationList = houseIPSegmentInformationList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserBandwidthInformation that = (UserBandwidthInformation) o;
		return Objects.equals(hhId, that.hhId) &&
				Objects.equals(userId, that.userId);
	}

	@Override
	public int hashCode() {

		return Objects.hash(hhId, userId);
	}
}
