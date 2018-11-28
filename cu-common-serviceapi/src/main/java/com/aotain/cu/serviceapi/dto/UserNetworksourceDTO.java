package com.aotain.cu.serviceapi.dto;

import java.io.Serializable;

public class UserNetworksourceDTO  extends BaseDTO implements Serializable {

	private static final long serialVersionUID = -3516958239601176601L;
	
	String unitName;  		//单位名称
	String houseName;		//机房名称
	String frameName; 		//机架名称
	String distributeTime;	//资源分配日期
	String bandwidth;		//网络带宽
	String vitrualHostName; //虚拟主机名
	String vitrualHostIp;	//虚拟主机地
	public String getUnitName() {
		return unitName;
	}
	public String getHouseName() {
		return houseName;
	}
	public String getFrameName() {
		return frameName;
	}
	public String getDistributeTime() {
		return distributeTime;
	}
	public String getBandwidth() {
		return bandwidth;
	}
	public String getVitrualHostName() {
		return vitrualHostName;
	}
	public String getVitrualHostIp() {
		return vitrualHostIp;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public void setFrameName(String frameName) {
		this.frameName = frameName;
	}
	public void setDistributeTime(String distributeTime) {
		this.distributeTime = distributeTime;
	}
	public void setBandwidth(String bandwidth) {
		this.bandwidth = bandwidth;
	}
	public void setVitrualHostName(String vitrualHostName) {
		this.vitrualHostName = vitrualHostName;
	}
	public void setVitrualHostIp(String vitrualHostIp) {
		this.vitrualHostIp = vitrualHostIp;
	}
	
}
