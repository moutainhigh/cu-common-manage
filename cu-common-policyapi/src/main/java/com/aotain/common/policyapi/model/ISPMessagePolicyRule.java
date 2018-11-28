package com.aotain.common.policyapi.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ISPMessagePolicyRule {

	/**
	 * 管理指令ID
	 */
	@JSONField(serialize = false)
    private Long commandId;

	/**
	 * 规则ID
	 */
	@JSONField(serialize = false)
    private Long ruleId ;

	/**
	 * 规则类别（1-域名，2-URL，3-关键字，4-源IP地址，5-目的IP地址,6-源端口,7-目的端口,8-传输层协议）
	 */
    private Integer subType ;

	/**
	 * 规则类型为IP类的情况下是规则内容的起始值，其他类型直接是规则内容
	 */
    private String valueStart;

	/**
	 * 规则内容的接受值，仅在规则类型为IP类的情况下有效
	 */
    private String valueEnd ;

	/**
	 * 关键词的匹配范围(0-正文标题及正文本身，1-附件文件题目，2-附件正文)， 多个用逗号隔开
	 */
    private String keywordRange;

}