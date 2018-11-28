package com.aotain.cu.serviceapi.dto;

import java.io.Serializable;
import java.util.Date;

import com.aotain.cu.annotation.Export;

public class ServiceDomainInformationDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 4619097872144619160L;
	
	@Export(title="域名ID", id=1)
	private Long domainId;
	
	@Export(title="域名", id=3)
	private String domainName;
	
	@Export(title="服务ID", id=2)
	private Long serviceId;
	
	private Long userId;
	
	private Integer operationType;
	
	private Integer dealFlag;
	
	private Date creationDate;
	
	private Date updateDate;
	
	private Long createUserId; //创建人ID

	public Long getDomainId() {
		return domainId;
	}

	public String getDomainName() {
		return domainName;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public Long getUserId() {
		return userId;
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

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setDomainId(Long domainId) {
		this.domainId = domainId;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	
}
