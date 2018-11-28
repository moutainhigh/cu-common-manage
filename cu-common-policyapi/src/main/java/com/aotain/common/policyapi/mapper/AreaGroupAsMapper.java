package com.aotain.common.policyapi.mapper;

import com.aotain.common.config.annotation.MyBatisDao;
import com.aotain.common.policyapi.base.BaseMapper;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/12/20
 */
@MyBatisDao("areaGroupAsMappers")
public interface AreaGroupAsMapper extends BaseMapper{

    int deleteDataByAreaGroupId(long areaGroupId);
}
