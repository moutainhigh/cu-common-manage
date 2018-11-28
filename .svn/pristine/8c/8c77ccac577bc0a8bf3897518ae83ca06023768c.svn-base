package com.aotain.common.policyapi.mapper;


import com.aotain.common.config.annotation.MyBatisDao;
import com.aotain.common.policyapi.base.BaseMapper;
import com.aotain.common.policyapi.model.UserPolicyBind;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/12/20
 */
@MyBatisDao("userPolicyBindMappers")
public interface UserPolicyBindMapper extends BaseMapper{

    UserPolicyBind selectByPrimaryKey(UserPolicyBind userPolicyBind);

    void updateDataByBindMessageNoAndType(UserPolicyBind userPolicyBind);

    int deleteDataByMessageNo(UserPolicyBind userPolicyBind);

}
