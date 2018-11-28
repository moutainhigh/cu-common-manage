package com.aotain.common.policyapi.mapper;

import com.aotain.common.config.annotation.MyBatisDao;
import com.aotain.common.policyapi.base.BaseMapper;
import com.aotain.common.policyapi.base.BaseVo;
import com.aotain.common.policyapi.model.HousePolicyBind;

import java.util.List;

@MyBatisDao
public interface HousePolicyBindMapper extends BaseMapper{

    List<HousePolicyBind> getBindPolicy(BaseVo policy);

    /**
     * 根据   删除
     * @param policy
     * @return
     */
    int deleteByMessageNo(Object policy);

    HousePolicyBind selectByPrimaryKey(Long bindId);

    /**
     * 查询所有未删除的机房绑定策略
     * @return
     */
    List<HousePolicyBind> selectAllHousePolicyBind();
}
