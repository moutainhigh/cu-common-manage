package com.aotain.common.policyapi.mapper;

import com.aotain.common.config.annotation.MyBatisDao;
import com.aotain.common.policyapi.base.BaseMapper;
import com.aotain.common.policyapi.model.HouseIp;
import com.aotain.common.policyapi.model.HouseIpIp;

import java.util.List;

@MyBatisDao
public interface HouseIpMapper extends BaseMapper {
	
	void insertHouseIpIp(HouseIpIp domain);

	int findHouseIpIpCount(HouseIpIp domain);

	int deleteHouseIpIp(HouseIpIp domain);

	HouseIp selectByHouseId(String houseId);

	HouseIpIp selectHouseIpIpBySeqId(long seqId);

	/**
	 * 查询所有未删除的HouseIp
	 * @return
	 */
	List<HouseIp> selectAllHouseIp();

	/**
	 * 根据houseId查询与之关联的houseIpIp
	 * @return
	 */
	List<HouseIpIp> selectHouseIpIpByHouseId(String houseId);
}
