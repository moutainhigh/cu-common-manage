package com.aotain.common.utils.model.msg;

/**
 * EU设备下发状态实体
 * 
 * @author liuz@aotian.com
 * @date 2017年12月22日 下午2:55:33
 */
public class EuSendStatus {
	private Integer probeType; // 0x00(0)：代表DPI设备,0x01(1)：代表EU设备
	private Integer messageType; 
	private Integer messageNo;
	private String ip; // EU IP
	private String policyIp; // 下发策略的policy IP地址
	private Integer status;// 0-正在发送、1-发送成功、2-发送失败

	public Integer getProbeType() {
		return probeType;
	}

	public void setProbeType(Integer probeType) {
		this.probeType = probeType;
	}

	public Integer getMessageType() {
		return messageType;
	}

	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}

	public Integer getMessageNo() {
		return messageNo;
	}

	public void setMessageNo(Integer messageNo) {
		this.messageNo = messageNo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPolicyIp() {
		return policyIp;
	}

	public void setPolicyIp(String policyIp) {
		this.policyIp = policyIp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EuSendStatus [probeType=" + probeType + ", messageType=" + messageType + ", messageNo=" + messageNo
				+ ", ip=" + ip + ", policyIp=" + policyIp + ", status=" + status + "]";
	}

}
