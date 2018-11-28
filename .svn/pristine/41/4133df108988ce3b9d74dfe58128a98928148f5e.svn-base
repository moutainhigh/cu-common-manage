package com.aotain.common.utils.model.msg;

import com.aotain.common.utils.tools.Tools;

/**
 * 消息统计队列对象
 * @author Jason.CW.Cheung
 * @date 2018年3月5日 下午4:11:18
 * @version 1.0
 */
public class MessageStatQueue extends BaseVo {

	private static final long serialVersionUID = -5344170564231800864L;

	/**
	 * 1=指令和策略下发统计消息类型	2=日志上报统计信息类型
	 */
	private Integer type;
	
	/**
	 * 消息内容，json字符串
	 */
	private String message;
	
	/**
	 * 创建时间， UTC时间戳，精确到秒
	 */
	private Long createTime;
	
	/**
	 * 添加消息的IP地址
	 */
	private String createip = Tools.getHostAddressAndIp();

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getCreateip() {
		return createip;
	}

	public void setCreateip(String createip) {
		this.createip = createip;
	}
	
	@Override
	public String toString() {
		return "MessageStatQueue [type=" + type + ", message=" + message + ", createTime=" + createTime + ", createip=" + createip + "]";
	}

}
