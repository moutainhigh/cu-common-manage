package com.aotain.common.policyapi.service;

import com.aotain.common.policyapi.base.BaseService;
import com.aotain.common.policyapi.base.BaseVo;
import com.aotain.common.policyapi.mapper.IdcIsmsCfgFlowuploadMapper;
import com.aotain.common.policyapi.mapper.IdcIsmsCfgFlowuploadServerMapper;
import com.aotain.common.policyapi.model.HousePolicyBind;
import com.aotain.common.policyapi.model.IdcIsmsCfgFlowUploadServer;
import com.aotain.common.policyapi.model.IdcIsmsCfgFlowupload;
import com.aotain.common.utils.monitorstatistics.ExceptionCollector;
import com.aotain.common.utils.monitorstatistics.ModuleConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 流量结果上报策略service
 *
 * @author daiyh@aotain.com
 * @date 2017/11/16
 */

@Service
public class FlowUploadPolicyService extends BaseService{


    private static Logger logger = LoggerFactory.getLogger(AccessLogPolicyService.class);

    @Autowired
    private IdcIsmsCfgFlowuploadMapper idcIsmsCfgFlowuploadMapper;

    @Autowired
    private IdcIsmsCfgFlowuploadServerMapper idcIsmsCfgFlowuploadServerMapper;

    @Autowired
    private MessageNameService messageNameService;

    @Autowired
    private HousePolicyBindService housePolicyBindService;

    @Autowired
    private ExceptionCollector exceptionCollector;

    @Override
    public boolean addDb(BaseVo policy) {
        try{
            setPropertiesBeforeSaveOrUpdate(policy);

            IdcIsmsCfgFlowupload idcIsmsCfgFlowupload = (IdcIsmsCfgFlowupload)policy;
            addFlowUpload(idcIsmsCfgFlowupload);
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" addDb error,Param[policy=]"+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean modifyDb(BaseVo policy) {
        try{
            setPropertiesBeforeSaveOrUpdate(policy);

            IdcIsmsCfgFlowupload idcIsmsCfgFlowupload = (IdcIsmsCfgFlowupload)policy;
            idcIsmsCfgFlowuploadMapper.updateData(idcIsmsCfgFlowupload);
            //删除原有关联表
            IdcIsmsCfgFlowUploadServer idcIsmsCfgFlowuploadServer = new IdcIsmsCfgFlowUploadServer();
            idcIsmsCfgFlowuploadServer.setSeqId(idcIsmsCfgFlowupload.getSeqId());
            idcIsmsCfgFlowuploadServerMapper.deleteData(idcIsmsCfgFlowuploadServer);
            //增加新的关联表
            addIdcIsmsCfgFlowUploadServers(idcIsmsCfgFlowupload);
            //修改messageNo表
            if (idcIsmsCfgFlowupload.getMessageNo()==null||idcIsmsCfgFlowupload.getMessageNo()==0) {
                IdcIsmsCfgFlowupload result = idcIsmsCfgFlowuploadMapper.selectByPrimaryKey(idcIsmsCfgFlowupload.getSeqId());
                idcIsmsCfgFlowupload.setMessageNo(result.getMessageNo());
            }

            messageNameService.modifyMessageName(idcIsmsCfgFlowupload);
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" modifyDb error,Param[policy=]"+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteDb(BaseVo policy) {
        try{
            setPropertiesBeforeSaveOrUpdate(policy);

            //删除flowUpload
            IdcIsmsCfgFlowupload idcIsmsCfgFlowupload = (IdcIsmsCfgFlowupload)policy;
            idcIsmsCfgFlowuploadMapper.deleteData(idcIsmsCfgFlowupload);
            //删除folwUploadServer相关信息
            IdcIsmsCfgFlowUploadServer idcIsmsCfgFlowuploadServer = new IdcIsmsCfgFlowUploadServer();
            idcIsmsCfgFlowuploadServer.setSeqId(idcIsmsCfgFlowupload.getSeqId());

            setUnSetPropertiesForChannel(idcIsmsCfgFlowupload);

            idcIsmsCfgFlowuploadServerMapper.deleteData(idcIsmsCfgFlowuploadServer);

            messageNameService.deleteMessageName(idcIsmsCfgFlowupload);
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" deleteDb error,Param[policy=]"+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    /**
     * 删除时给一些通道需要的参数赋值
     * @param idcIsmsCfgFlowupload
     * @return
     */
    private void setUnSetPropertiesForChannel(IdcIsmsCfgFlowupload idcIsmsCfgFlowupload){
        IdcIsmsCfgFlowupload result = idcIsmsCfgFlowuploadMapper.selectByPrimaryKey(idcIsmsCfgFlowupload.getSeqId());
        //如果messageNo不存在则查询
        if (idcIsmsCfgFlowupload.getMessageNo()==null||idcIsmsCfgFlowupload.getMessageNo()==0) {
            idcIsmsCfgFlowupload.setMessageNo(result.getMessageNo());
        }
        idcIsmsCfgFlowupload.setPacketType(result.getPacketType());
        idcIsmsCfgFlowupload.setPacketSubtype(result.getPacketSubtype());
        idcIsmsCfgFlowupload.setMethod(result.getMethod());
        List<IdcIsmsCfgFlowUploadServer> idcIsmsCfgFlowUploadServers =
                idcIsmsCfgFlowuploadServerMapper.selectServerListBySeqId(idcIsmsCfgFlowupload.getSeqId());
        idcIsmsCfgFlowupload.setIdcIsmsCfgFlowUploadServerList(idcIsmsCfgFlowUploadServers);
    }

    @Transactional(rollbackFor = Exception.class)
    private boolean addFlowUpload(IdcIsmsCfgFlowupload idcIsmsCfgFlowupload){
        try{
            idcIsmsCfgFlowuploadMapper.insertData(idcIsmsCfgFlowupload);
            addIdcIsmsCfgFlowUploadServers(idcIsmsCfgFlowupload);
            //添加数据到messageNo表
            messageNameService.addMessageName(idcIsmsCfgFlowupload);
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" addFlowUpload error,Param="+idcIsmsCfgFlowupload.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    private void addIdcIsmsCfgFlowUploadServers(IdcIsmsCfgFlowupload idcIsmsCfgFlowUpload){
        try{
            List<IdcIsmsCfgFlowUploadServer> idcIsmsCfgFlowuploadServers = idcIsmsCfgFlowUpload.getIdcIsmsCfgFlowUploadServerList();
            if(null==idcIsmsCfgFlowuploadServers||idcIsmsCfgFlowuploadServers.size()==0){
                return;
            }
            for(IdcIsmsCfgFlowUploadServer idcIsmsCfgFlowuploadServer:idcIsmsCfgFlowuploadServers){
                idcIsmsCfgFlowuploadServer.setSeqId(idcIsmsCfgFlowUpload.getSeqId());
                int result = idcIsmsCfgFlowuploadServerMapper.selectServersCountBySeqIdAndDestIpAndDestPort(idcIsmsCfgFlowuploadServer);
                // 插入之前检查是否存在此seqId相关的相同ip和port的服务器信息
                if(result>0){
                    logger.info("Method:selectServersCountBySeqIdAndDestIpAndDestPort(),Parameter:idcIsmsCfgFlowuploadServer,此seqId已经存在相同ip和port的服务器信息...");
                    continue;
                }
                idcIsmsCfgFlowuploadServerMapper.insertData(idcIsmsCfgFlowuploadServer);
            }
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" addIdcIsmsCfgFlowUploadServers error,Param="+idcIsmsCfgFlowUpload.objectToJson(),e);
            exceptionCollector.addEvent(e);

        }

    }


    @Override
    public boolean addCustomLogic(BaseVo policy) {
        boolean success = setPolicyToRedisTask(policy);
        if(!success) {
            logger.error("setPolicyToRedisTask failed...");
            return false;
        }

        return strategySortAndChannelToRedis(policy);
    }

    @Override
    protected boolean modifyCustomLogic(BaseVo policy) {
        boolean success = setPolicyOperateSequenceToRedis(policy);
        if (!success) {
            logger.error("setPolicyOperateSequenceToRedis failed...");
            return false;
        }

        return true;
    }

    @Override
    protected boolean deleteCustomLogic(BaseVo policy) {
        boolean success = setPolicyOperateSequenceToRedis(policy);
        if ( !success ) {
            logger.error("setPolicyOperateSequenceToRedis failed...");
            return false;
        }

        success = deleteFlowUploadBindPolicy(policy);
        if( !success ) {
            logger.error("deleteFlowUploadBindPolicy failed...");
            return false;
        }
        return true;
    }

    /**
     * 删除策略对应的绑定策略
     * @param policy
     * @return
     */
    private boolean deleteFlowUploadBindPolicy(BaseVo policy){
        try{
            //获得已经绑定机房策略
            List<HousePolicyBind> bindList = getBindPolicy(policy);
            boolean result =  housePolicyBindService.deletePolicy(bindList);
            if(!result){
                logger.error("delete policy bind list error! msg=" + policy.objectToJson());
                return false;
            }
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" deleteFlowUploadBindPolicy error,Param="+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

}
