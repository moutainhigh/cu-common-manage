package com.aotain.common.policyapi.mapper;

import com.aotain.common.config.annotation.MyBatisDao;
import com.aotain.common.policyapi.base.BaseMapper;
import com.aotain.common.policyapi.model.DPIFlowUpload;

/**
 * DPIFlowUploadMapper class
 *
 * @author daiyh@aotain.com
 * @date 2017/12/15
 */
@MyBatisDao("dpiFlowUploadMappers")
public interface DPIFlowUploadMapper extends BaseMapper{

    DPIFlowUpload selectByPrimaryKey(Long seqId);
}
