package com.aotain.common.policyapi.mapper;

import com.aotain.common.config.annotation.MyBatisDao;
import com.aotain.common.policyapi.base.BaseVo;
import com.aotain.common.policyapi.model.MessageName;

import java.util.List;
import java.util.Map;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/11/21
 */
@MyBatisDao
public interface MessageNameMapper {
    /**
     * 添加messageName表
     * @param policy
     * @return
     */
    int addMessageName(BaseVo policy);

    /**
     * 修改messageName表
     * @param policy
     * @return
     */
    int modifyMessageName(BaseVo policy);

    /**
     * 根据AccessLog修改messageName表
     * @param policy
     * @return
     */
    int modifyMessageNameByAccessLog(BaseVo policy);

    /**
     * 根据IpAddressAllocation修改messageName表
     * @param policy
     * @return
     */
    int modifyMessageNameByIpAddressAllocation(BaseVo policy);

    /**
     * 删除messageName表
     * @param policy
     * @return
     */
    int deleteMessageName(BaseVo policy);

    /**
     * 根据MessageNo和MessageType查询书否存在此记录
     * @param policy
     * @return
     */
    int selectByMessageNoAndType(BaseVo policy);

    /**
     * 查询每种messageType对应的最大messageNo
     * @return
     */
    List<MessageName> selectAllTypeMaxMessageNo();
}
