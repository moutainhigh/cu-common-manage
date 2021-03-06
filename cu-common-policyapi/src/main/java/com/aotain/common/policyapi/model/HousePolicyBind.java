package com.aotain.common.policyapi.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.annotation.JSONField;
import com.aotain.common.policyapi.base.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 机房策略绑定
 * @author yinzf 
 * @createtime 2014年11月5日 上午9:51:46
 */
@Getter
@Setter
public class HousePolicyBind extends BaseVo{

	@JSONField(serialize = false)
	private Long bindId;

	/**
	 * 是否指定机房（2-指定、0-不指定）
	 */
	private Integer houseType;

	/**
	 * 机房id
	 */
	private String houseId;
	
	/**
	 * BindMessage包含2个属性 BindMessageType：待绑定的策略类型，BindMessageNo：待绑定的策略MessageNo
	 */
	private List<BindMessage> bindInfo;

	@JSONField(serialize = false)
	private Long bindMessageType;
	@JSONField(serialize = false)
	private Long bindMessageNo;

	@JSONField(serialize = false)
	private Date createTime;

	//TODO
	private Integer bindAction;
	
	private Long topTaskId;
	@JSONField(serialize = false)
	private Long userId;

}
