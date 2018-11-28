package com.aotain.common.utils.model.msg;

import com.alibaba.fastjson.annotation.JSONField;
import com.aotain.common.utils.tools.Tools;

/**
 * 通知消息队列对象
 * 
 * @author liuz@aotian.com
 * @date 2017年11月30日 下午4:24:42
 */
public class NoticeQueueMessage extends BaseVo {
	private static final long serialVersionUID = 7549984222755603207L;

	private Integer type; // 任务类型:1-任务状态消息，2-EU策略发送状态
	@JSONField(jsonDirect = true)
	private String message; // 消息内容，json字符串
	private Long createTime; // 创建时间， UTC时间戳，精确到秒
	private String createip = Tools.getHostAddressAndIp();

	public String getCreateip() {
		return createip;
	}

	public void setCreateip(String createip) {
		this.createip = createip;
	}

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

	@Override
	public String toString() {
		return "NoticeQueueMessage [type=" + type + ", message=" + message + ", createTime=" + createTime
				+ ", createip=" + createip + "]";
	}

}
