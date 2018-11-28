package com.aotain.common.policyapi.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class HouseIpIp {

	/**
	 * 主键
	 */
	@JSONField(serialize = false)
	private Long seqId;
	/**
	 * 机房Id
	 */
	@JSONField(serialize = false)
	private String houseId;
	/**
	 * IP地址
	 */
	private String houseIp;
	/**
	 * IP地址前缀长度
	 */
	private Integer houseIpPrefix;
	@JSONField(serialize = false)
    private Long messageSequenceNo;
	@JSONField(serialize = false)
    private Date createTime;

	@Override
	public int hashCode(){
		return houseIp.hashCode()+houseIpPrefix.hashCode();
	}

	@Override
	public boolean equals(Object o){
		if ( !(o instanceof HouseIpIp) ){
			return false;
		}
		HouseIpIp houseIpIp = (HouseIpIp) o;
		return houseIpIp.getHouseIp().equals(this.getHouseIp())
				&&houseIpIp.getHouseIpPrefix().equals(this.getHouseIpPrefix());
	}
}
