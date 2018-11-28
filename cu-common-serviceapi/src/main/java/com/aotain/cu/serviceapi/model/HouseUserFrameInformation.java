package com.aotain.cu.serviceapi.model;

import java.util.Date;

public class HouseUserFrameInformation {

    //对应 IDC_ISMS_BASE_USER_FRAME ID
    private Long id;

    private Long houseseqId;

    private Long frameId;
    
    private Long houseId; //机房ID
    
    private String userName; //使用人(个人名字or单位名称）
    
    private Integer idType; //使用人的证件类型
    
    private String idNumber; //对应证件号码
    
    private Integer operationType; //操作类型（1-新增、2-修改(变更)，3-删除）

 // 创建人ID
 	private Integer createUserId;
 	
 	// 更新人的ID
 	private Integer updateUserId;
 	
 	// 创建时间
 	private Date createTime;
 	
 	// 修改时间
 	private Date updateTime;
 	
    public Long getFrameId() {
        return frameId;
    }

    public void setFrameId(Long frameId) {
        this.frameId = frameId;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Long getHouseseqId() {
        return houseseqId;
    }

    public void setHouseseqId( Long houseseqId ) {
        this.houseseqId = houseseqId;
    }
}
