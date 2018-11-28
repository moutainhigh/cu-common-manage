package com.aotain.common.policyapi.service;

import com.aotain.common.policyapi.base.BaseService;
import com.aotain.common.policyapi.base.BaseVo;
import com.aotain.common.policyapi.mapper.DPIFlowUploadMapper;
import com.aotain.common.policyapi.model.DPIFlowUpload;
import com.aotain.common.utils.monitorstatistics.ExceptionCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Date;

/**
 * 流量流向结果上报策略服务类
 *
 * @author daiyh@aotain.com
 * @date 2017/12/15
 */
@Service("dpiFlowUploadService")
public class DPIFlowUploadService extends BaseService{

    private static Logger logger = LoggerFactory.getLogger(DPIFlowUploadService.class);

    @Resource(name = "dpiFlowUploadMappers")
    private DPIFlowUploadMapper dpiFlowUploadMapper;

    @Autowired
    private MessageNameService messageNameService;

    @Autowired
    private ExceptionCollector exceptionCollector;

    @PostConstruct
    public void setMapper(){
        this.mapper = dpiFlowUploadMapper;
    }

    @Override
    protected boolean addDb(BaseVo policy) {
        try{
            setPropertiesBeforeSaveOrUpdate(policy);
            DPIFlowUpload dpiFlowUpload = (DPIFlowUpload) policy;
            dpiFlowUploadMapper.insertData(dpiFlowUpload);
            //添加数据到messageNo表
            messageNameService.addMessageName(dpiFlowUpload);
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" addDb error,Param[policy=]"+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    @Override
    protected boolean modifyDb(BaseVo policy) {
        try{
            setPropertiesBeforeSaveOrUpdate(policy);
            DPIFlowUpload dpiFlowUpload = (DPIFlowUpload) policy;
            if(dpiFlowUpload.getCreateTime()==null){
                dpiFlowUpload.setCreateTime(new Date());
            }
            dpiFlowUploadMapper.updateData(dpiFlowUpload);
            //如果messageNo不存在则查询
            if (dpiFlowUpload.getMessageNo()==null||dpiFlowUpload.getMessageNo()==0) {
                DPIFlowUpload result = dpiFlowUploadMapper.selectByPrimaryKey(dpiFlowUpload.getSeqId());
                dpiFlowUpload.setMessageNo(result.getMessageNo());
            }
            messageNameService.modifyMessageName(dpiFlowUpload);
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" modifyDb error,Param[policy=]"+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    @Override
    protected boolean deleteDb(BaseVo policy) {
        try{
            setPropertiesBeforeSaveOrUpdate(policy);
            DPIFlowUpload dpiFlowUpload = (DPIFlowUpload) policy;
            if(dpiFlowUpload.getCreateTime()==null){
                dpiFlowUpload.setCreateTime(new Date());
            }
            dpiFlowUploadMapper.deleteData(dpiFlowUpload);
            //如果messageNo不存在则查询
            if (dpiFlowUpload.getMessageNo()==null||dpiFlowUpload.getMessageNo()==0) {
                DPIFlowUpload result = dpiFlowUploadMapper.selectByPrimaryKey(dpiFlowUpload.getSeqId());
                dpiFlowUpload.setMessageNo(result.getMessageNo());
            }
            messageNameService.deleteMessageName(dpiFlowUpload);
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" deleteDb error,Param[policy=]"+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    @Override
    public boolean addCustomLogic(BaseVo policy) {
        return sendRedisMessage(policy);
    }

    @Override
    protected boolean modifyCustomLogic(BaseVo policy) {
        boolean result = false;
        result = setPolicyOperateSequenceToRedis(policy);
        if ( !result ) {
            logger.error("setPolicyOperateSequenceToRedis failed..."+policy.objectToJson());
            return false;
        }
        return result;
    }



    @Override
    protected boolean deleteCustomLogic(BaseVo policy) {
        boolean result = false;
        result = setPolicyOperateSequenceToRedis(policy);
        if ( !result ) {
            logger.error("setPolicyOperateSequenceToRedis failed..."+policy.objectToJson());
            return false;
        }
        return result;
    }
}
