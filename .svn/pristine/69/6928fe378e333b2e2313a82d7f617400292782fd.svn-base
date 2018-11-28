package com.aotain.common.policyapi.mapper;

import com.aotain.common.config.annotation.MyBatisDao;
import com.aotain.common.policyapi.base.BaseMapper;
import com.aotain.common.policyapi.model.ISPMessagePolicy;
import com.aotain.common.policyapi.model.ISPMessagePolicyRule;

import java.util.List;

@MyBatisDao
public interface ISPMessagePolicyMapper extends BaseMapper {
	
	public int deletePolicy(ISPMessagePolicy domain);
	public int insertPolicyRule(ISPMessagePolicyRule domain);
	public int updatePolicyRule(ISPMessagePolicyRule domain);
	public int deletePolicyRule(ISPMessagePolicy domain);
//	public int deleteBindPolicy(ISPMessagePolicy domain);

	List<ISPMessagePolicyRule> selectPolicyRuleListByCommandId(long commandId);

	ISPMessagePolicy selectByPrimaryKey(long commandId);

	/**
	 * 查询所有未删除的记录
	 * @return
	 */
	List<ISPMessagePolicy> selectAllISPMessagePolicy();

}
