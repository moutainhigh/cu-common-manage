package com.aotain.common.policyapi.mapper;

import com.aotain.common.config.annotation.MyBatisDao;
import com.aotain.common.policyapi.base.BaseMapper;
import com.aotain.common.policyapi.model.IdcIsmsCfgAccessLog;

import java.util.List;

@MyBatisDao
public interface IdcIsmsCfgAccesslogMapper extends BaseMapper{

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CU_V3.IDC_ISMS_CFG_ACCESSLOG
     *
     * @mbg.generated
     */
    int insertSelective(IdcIsmsCfgAccessLog record);

    /**
     * 根据accessLogFlag查询是否存在
     * @param accessLogFlag
     * @return
     */
    IdcIsmsCfgAccessLog selectByAccessFlag(int accessLogFlag);

    /**
     * 根据accessLogFlag进行新增，存在accessLogFlag相同的数据则修改，否则新增
     * @param idcIsmsCfgAccesslog
     * @return
     */
    int addByAccessLogFlag(IdcIsmsCfgAccessLog idcIsmsCfgAccesslog);

    /**
     * 根据accessLogFlag进行修改
     * @param idcIsmsCfgAccesslog
     * @return
     */
    int updateByAccessLogFlag(IdcIsmsCfgAccessLog idcIsmsCfgAccesslog);

    /**
     * 根据accessLogFlag进行删除
     * @param idcIsmsCfgAccesslog
     * @return
     */
    int deleteByAccessLogFlag(IdcIsmsCfgAccessLog idcIsmsCfgAccesslog);

    /**
     * 查询所有的IdcIsmsCfgAccessLog
     * @return
     */
    List<IdcIsmsCfgAccessLog> selectAllAccessFlag();
}