package com.aotain.common.policyapi.model;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.aotain.common.policyapi.base.BaseVo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseIp extends BaseVo{
	
	private String houseId ;
//	/**
//	 * 当前登录的用户
//	 */
//    private Long userId;

	private Integer bindAction;

	@JSONField(serialize = false)
    private Date createTime;
    private List<HouseIpIp> IPSegments;

}
