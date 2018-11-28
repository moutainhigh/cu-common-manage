package com.aotain.common.policyapi.mapper;

import com.aotain.common.config.annotation.MyBatisDao;
import com.aotain.common.policyapi.base.BaseMapper;
import com.aotain.common.policyapi.model.EuDeviceStatus;

import java.util.List;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/11/30
 */
@MyBatisDao
public interface EuDeviceStatusMapper extends BaseMapper{

    /**
     * 根据rType查询相关记录是否存在
     * @param rType
     * @return
     */
    EuDeviceStatus selectByRType(Integer rType);

    /**
     * 查询所有未删除的EU状态信息
     * @return
     */
    List<EuDeviceStatus> selectAllEuDeviceStatus();
}
