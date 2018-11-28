package com.aotain.common.policyapi.mapper;

import com.aotain.common.config.annotation.MyBatisDao;
import com.aotain.common.policyapi.base.BaseMapper;
import com.aotain.common.policyapi.model.IdcIsmsCfgFlowupload;

import java.util.List;

@MyBatisDao
public interface IdcIsmsCfgFlowuploadMapper extends BaseMapper{

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CU_V3.IDC_ISMS_CFG_FLOWUPLOAD
     *
     * @mbg.generated
     */
    int insertSelective(IdcIsmsCfgFlowupload record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CU_V3.IDC_ISMS_CFG_FLOWUPLOAD
     *
     * @mbg.generated
     */
    IdcIsmsCfgFlowupload selectByPrimaryKey(Long seqId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CU_V3.IDC_ISMS_CFG_FLOWUPLOAD
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(IdcIsmsCfgFlowupload record);

    /**
     * 查询所有未删除的记录
     * @return
     */
    List<IdcIsmsCfgFlowupload> selectAllIdcIsmsCfgFlowupload();

}