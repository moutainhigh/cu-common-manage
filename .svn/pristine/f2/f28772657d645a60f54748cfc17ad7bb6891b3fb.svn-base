package com.aotain.common.policyapi.mapper;

import com.aotain.common.config.annotation.MyBatisDao;
import com.aotain.common.policyapi.base.BaseMapper;
import com.aotain.common.policyapi.model.IdcIsmsCfgFlowUploadServer;

import java.util.List;

@MyBatisDao
public interface IdcIsmsCfgFlowuploadServerMapper extends BaseMapper{
    /**
     * 根据seqId destIp destPort查询是否存在相关服务器信息
     * @param idcIsmsCfgFlowUploadServer
     * @return
     */
    int selectServersCountBySeqIdAndDestIpAndDestPort(IdcIsmsCfgFlowUploadServer idcIsmsCfgFlowUploadServer);

    /**
     * 根据seqId查询记录
     * @param seqId
     * @return
     */
    List<IdcIsmsCfgFlowUploadServer> selectServerListBySeqId(long seqId);
}