package com.aotain.cu.serviceapi.dto;

import io.swagger.annotations.ApiModelProperty;

public class DeleteHouseDTO {
	@ApiModelProperty(value="电信管理部门颁发的IDC/ISP许可证号")
	private String idcId;
	@ApiModelProperty(value="机房ID")
	private Long houseId;
	@ApiModelProperty(value="链路ID")
	private Long gatewayId;
	@ApiModelProperty(value="IP段ID")
	private Long ipSegId;
	public String getIdcId() {
		return idcId;
	}
	public void setIdcId(String idcId) {
		this.idcId = idcId;
	}
	public Long getHouseId() {
		return houseId;
	}
	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}
	public Long getGatewayId() {
		return gatewayId;
	}
	public void setGatewayId(Long gatewayId) {
		this.gatewayId = gatewayId;
	}
	public Long getIpSegId() {
		return ipSegId;
	}
	public void setIpSegId(Long ipSegId) {
		this.ipSegId = ipSegId;
	}
	@Override
	public String toString() {
		return "DeleteHouseDTO [idcId=" + idcId + ", houseId=" + houseId
				+ ", gatewayId=" + gatewayId + ", ipSegId=" + ipSegId + "]";
	}
	
}
