package com.aotain.cu.serviceapi.dto;

import io.swagger.annotations.ApiModelProperty;

public class DeleteUserDTO {
	
	@ApiModelProperty(value="电信管理部门颁发的IDC/ISP许可证号")
	private String idcId; 
	@ApiModelProperty(value="用户ID")
	private Long userId;
	@ApiModelProperty(value="删除的应用服务数据")
	private Service service;
	@ApiModelProperty(value="占用机房信息ID")
	private Long hhId;
	
	public String getIdcId() {
		return idcId;
	}

	public void setIdcId(String idcId) {
		this.idcId = idcId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Long getHhId() {
		return hhId;
	}

	public void setHhId(Long hhId) {
		this.hhId = hhId;
	}

	@Override
	public String toString() {
		return "DeleteUserDTO [idcId=" + idcId + ", userId=" + userId
				+ ", service=" + service + ", hhId=" + hhId + "]";
	}

	public static class Service{
		@ApiModelProperty(value="应用服务ID")
		private Long serviceId;
		@ApiModelProperty(value="应用服务的域名ID")
		private Long domainId;
		@ApiModelProperty(value="占用机房信息ID")
		private Long hhId;
		public Long getServiceId() {
			return serviceId;
		}
		public void setServiceId(Long serviceId) {
			this.serviceId = serviceId;
		}
		public Long getDomainId() {
			return domainId;
		}
		public void setDomainId(Long domainId) {
			this.domainId = domainId;
		}
		public Long getHhId() {
			return hhId;
		}
		public void setHhId(Long hhId) {
			this.hhId = hhId;
		}
		@Override
		public String toString() {
			return "Service [serviceId=" + serviceId + ", domainId=" + domainId
					+ ", hhId=" + hhId + "]";
		}
		
	}

}
