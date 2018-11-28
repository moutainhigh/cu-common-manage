package com.aotain.common.policyapi.mapper;

import com.aotain.common.config.annotation.MyBatisDao;
import com.aotain.common.policyapi.base.BaseMapper;
import com.aotain.common.policyapi.model.IpAddressAllocation;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/12/25
 */
@MyBatisDao
public interface IpAddressAllocationMapper extends BaseMapper{

    /**
     * 插入数据
     * @param ipAddressAllocation
     * @return
     */
    int insert(IpAddressAllocation ipAddressAllocation);

    /**
     * 根据dataType查询记录
     * @param dataType
     * @return
     */
    IpAddressAllocation selectByDataType(int dataType);
}
