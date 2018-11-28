package com.aotain.cu.serviceapi.model.args;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 同步删除机房参数
 * 
 * @author liuz@aotian.com
 * @date 2018年9月29日 下午2:20:09
 */
@ApiModel(value="ReqSynDelHouseToPassport",description="权限系统删除机房请求对象")
public class ReqSynDelHouseToPassport implements Serializable {
	private static final long serialVersionUID = -309665825467775015L;
	
	@ApiModelProperty(value="应用ID",name="appId")
	private Long appId;			// appId
	@ApiModelProperty(value="权限系统同步删除api接口地址",name="synDelUrl")
	private String synDelUrl; 	// 同步删除URL
	@ApiModelProperty(value="权限系统全量查询api接口地址",name="synQueryUrl")
	private String synQueryUrl; // 同步查询URL
	@ApiModelProperty(value="目标机房ID",name="houseId")
	private Long houseId;		// 机房ID

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public String getSynDelUrl() {
		return synDelUrl;
	}

	public void setSynDelUrl(String synDelUrl) {
		this.synDelUrl = synDelUrl;
	}

	public String getSynQueryUrl() {
		return synQueryUrl;
	}

	public void setSynQueryUrl(String synQueryUrl) {
		this.synQueryUrl = synQueryUrl;
	}

	public Long getHouseId() {
		return houseId;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}

	@Override
	public String toString() {
		return "ReqSynDelHouseToPassport [appId=" + appId + ", synDelUrl=" + synDelUrl + ", synQueryUrl=" + synQueryUrl
				+ ", houseId=" + houseId + "]";
	}

}
