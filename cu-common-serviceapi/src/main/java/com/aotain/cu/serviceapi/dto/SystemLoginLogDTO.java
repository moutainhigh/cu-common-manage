package com.aotain.cu.serviceapi.dto;

import java.io.Serializable;
import java.util.Date;

public class SystemLoginLogDTO extends BaseDTO implements Serializable{
	private static final long serialVersionUID = -3550390173899616865L;
	private Long logId;
	private String user;
	private String userName;
	private Date loginDate;
	private String loginIp;
	private String hostName;
	private Integer type;
	private String typeName;
	private String loginSDate;
	private String loginEDate;
	private String p_msg;
	/**
	 * CU v4.0
	 *用户ID
	 */
	private Long userId;
	/**
	 * CU v4.0
	 * 用户级别：1=root,2=省管理员,3=地市管理员
	 */
	private Integer userLevel;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}
	public Long getLogId() {
		return logId;
	}
	public String getUser() {
		return user;
	}
	public String getUserName() {
		return userName;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public String getHostName() {
		return hostName;
	}
	public Integer getType() {
		return type;
	}
	public String getTypeName() {
		return typeName;
	}
	public String getLoginSDate() {
		return loginSDate;
	}
	public String getLoginEDate() {
		return loginEDate;
	}
	public String getP_msg() {
		return p_msg;
	}
	public void setLogId(Long logId) {
		this.logId = logId;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public void setLoginSDate(String loginSDate) {
		this.loginSDate = loginSDate;
	}
	public void setLoginEDate(String loginEDate) {
		this.loginEDate = loginEDate;
	}
	public void setP_msg(String p_msg) {
		this.p_msg = p_msg;
	}
	
	
}
