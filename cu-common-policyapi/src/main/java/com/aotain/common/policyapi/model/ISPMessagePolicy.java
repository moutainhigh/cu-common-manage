package com.aotain.common.policyapi.model;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.aotain.common.policyapi.base.BaseVo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ISPMessagePolicy extends BaseVo{

    private Long commandId ;
	@JSONField(serializeUsing = ToStringSerializer.class)
    private Long smmsCommandId;
	/**
	 * 策略类型(1-违法信息监测指令，2-违法信息过滤指令 5-免过滤网站列表指令 6-违法网站列表)
	 */
    private Integer type;
	/**
	 * 是否过滤(0-不过滤，1-过滤)
	 */
    private Integer blockFlag;
	/**
	 * 日志记录(0-不记录，1-记录)
	 */
    private Integer logFlag ;
	/**
	 * level
	 */
	private Long level;
	/**
	 * 生效时间
	 */
    private Long effectTime;
	/**
	 * 过期时间
	 */
    private Long expiredTime;
	/**
	 * owner
	 */
	private String owner;
	/**
	 * 创建时间
	 */
	@JSONField(serialize = false)
    private Date createTime;
	@JSONField(serialize = false)
    private Long userId;
	@JSONField(serialize = false)
    private String userName;
	@JSONField(serialize = false)
    private Integer policyState ;
	@JSONField(serialize = false)
    private String idcID;
	@JSONField(serialize = false)
	private Long groupId;
	@JSONField(serialize = false)
	private Long ruleGroupId;
	@JSONField(serialize = false)
	private Integer monitorType = 0; /// 监测类别(0-系统自建监测，1-工信部下发监测，3-拨测指令，4-第三方指令)
	
    private List<ISPMessagePolicyRule> rules;


	@JSONField(serialize = false)
	private String actionReason;
	
	/**
	 * 批量操作标志位，0-单条操作、1-批量操作
	 */
	private int batchOperationFlag;

//	private Long topTaskId;

}
