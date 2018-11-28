package com.aotain.common.utils.model.msg;

/**
 * 策略下发EU ip ACK状态
 * 
 * @author Administrator
 *
 */
public class RedisPolicyAck extends BaseVo {
	private static final long serialVersionUID = -1323227362611286469L;

	/**
	 * 0-初始化、1-成功、2-失败
	 */
	private int status;

	// 下发策略的policy IP地址
	private String policyIp;

	/**
	 * 重发次数，默认值0（此字段已废弃）
	 */
	private int retransmissionTimes;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getRetransmissionTimes() {
		return retransmissionTimes;
	}

	public void setRetransmissionTimes(int retransmissionTimes) {
		this.retransmissionTimes = retransmissionTimes;
	}

	public String getPolicyIp() {
		return policyIp;
	}

	public void setPolicyIp(String policyIp) {
		this.policyIp = policyIp;
	}

	@Override
	public String toString() {
		return "RedisPolicyAck [status=" + status + ", policyIp=" + policyIp + ", retransmissionTimes="
				+ retransmissionTimes + "]";
	}

}
