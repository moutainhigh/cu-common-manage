package com.aotain.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * 基础配置类，依赖spring-data.xml中配置的加载配置文件来读取配置
 * 
 * @author liuz@aotian.com
 * @date 2018年5月24日 下午12:25:30
 */
@Repository
public class EnvConfig {
	@Value("${webservice.url:#{null}}")  	
	private String webserviceUrl;
	@Value("${isms.driverClassName}")  
	private String driverClassName;
	@Value("${isms.url}")  
	private String url;
	@Value("${isms.username}")  
	private String username;
	@Value("${isms.password}")  
	private String password;
	@Value("${isms.validationQuery:#{null}}")  
	private String validationQuery;
	@Value("${isms.clusterId:#{null}}")  
	private String clusterId;
	
	private String validateValue(String value){
		if(null == value || "".equals(value) || "".equals(value.trim())){
			return null;
		}
		String t = value.trim();
		if(t.matches("^\\$\\{.*\\}$")){
			return null;
		}
		return value;
	}
	
	public String getWebserviceUrl() {
		return validateValue(webserviceUrl);
	}
	public void setWebserviceUrl(String webserviceUrl) {
		this.webserviceUrl = webserviceUrl;
	}
	public String getDriverClassName() {
		return validateValue(driverClassName);
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public String getUrl() {
		return validateValue(url);
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return validateValue(username);
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return validateValue(password);
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getValidationQuery() {
		return validateValue(validationQuery);
	}
	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}
	public String getClusterId() {
		return validateValue(clusterId);
	}
	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}

}
