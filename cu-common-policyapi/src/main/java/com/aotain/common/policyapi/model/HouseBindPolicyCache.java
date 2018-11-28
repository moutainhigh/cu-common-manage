package com.aotain.common.policyapi.model;

import java.util.List;

public class HouseBindPolicyCache {
	private Long topTaskId;	// 主任务ID，可以为空
	/**
	 * 1=页面ISP信息安全策略下发 2=页面机房绑定策略下发 3=页面访问日志管理策略下发 4=页面ISMS流量结果上报策略下发
	 * 5=违法违规网站策略下发job 6=违法信息安全管理指令job 7=免过滤网站列表指令job 8=违法网站列表指令job
	 * 9=免过滤网站策略下发job 10=违法违规网站数据处置job 11=基础数据异常监测数据处置 12=阻断规则定时策略
	 */
	private int srcType;

	private List<HousePolicyBind> bindHouseList;

	public List<HousePolicyBind> getBindHouseList() {
		return bindHouseList;
	}

	public void setBindHouseList(List<HousePolicyBind> bindHouseList) {
		this.bindHouseList = bindHouseList;
	}

	// 创建时间， UTC时间戳，精确到秒
	private long createTime = System.currentTimeMillis()/1000;

	public Long getTopTaskId() {
		return topTaskId;
	}

	public void setTopTaskId(Long topTaskId) {
		this.topTaskId = topTaskId;
	}

	public int getSrcType() {
		return srcType;
	}

	public void setSrcType(int srcType) {
		this.srcType = srcType;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "HouseBindPolicyCache [topTaskId=" + topTaskId + ", srcType=" + srcType + ", bindHouseList="
				+ bindHouseList + ", createTime=" + createTime + "]";
	}

}
