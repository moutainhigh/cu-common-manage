package com.aotain.cu.serviceapi.model.permission;

import java.util.List;

public class DataPermission {

	private Integer dataPermissionId;

	private Integer appId;

	private String appName;

	private String deployName;

	private String dataPermissionToken;

	private String dataPermissionName;

	private String dataPermissionDesc;

	private List<DataPermissionSetting> settings;

	public Integer getDataPermissionId() {
		return dataPermissionId;
	}

	public Integer getAppId() {
		return appId;
	}

	public String getAppName() {
		return appName;
	}

	public String getDeployName() {
		return deployName;
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

	public List<DataPermissionSetting> getSettings() {
		return settings;
	}

	public void setDataPermissionId(Integer dataPermissionId) {
		this.dataPermissionId = dataPermissionId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public void setDeployName(String deployName) {
		this.deployName = deployName;
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

	public void setSettings(List<DataPermissionSetting> settings) {
		this.settings = settings;
	}
	
}
