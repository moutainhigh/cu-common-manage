package com.aotain.cu.serviceapi.model;

import org.apache.commons.lang3.StringUtils;

/**
 * 服务地址工具
 * 
 * @author liuz@aotian.com
 * @date 2018年8月19日 上午9:13:29
 */
public class ServiceAddress {
	private String ip;
	private int port;
	
	public ServiceAddress(int port, String ip){
		this.ip = ip;
		this.port = port;
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	@Override
	public String toString() {
		return "ServiceAddress [ip=" + ip + ", port=" + port + "]";
	}

	public String toHttpUrl(String path) {
		if (StringUtils.isBlank(path)) {
			path = "";
		} else {
			path = path.replaceAll("\\", "/");
			path = path.replaceAll("^/", "");
		}
		return String.format("http://%s:%d/%s", ip, port, path);
	}

	public String toHttpsUrl(String path) {
		return toHttpUrl(path).replaceAll("^http", "https");
	}
}
