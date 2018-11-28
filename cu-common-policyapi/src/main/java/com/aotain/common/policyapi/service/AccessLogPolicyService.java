package com.aotain.common.policyapi.service;

import com.aotain.common.policyapi.base.BaseService;
import com.aotain.common.policyapi.base.BaseVo;
import com.aotain.common.policyapi.constant.OperationConstants;
import com.aotain.common.policyapi.mapper.IdcIsmsCfgAccesslogMapper;
import com.aotain.common.policyapi.model.HousePolicyBind;
import com.aotain.common.policyapi.model.IdcIsmsCfgAccessLog;
import com.aotain.common.utils.monitorstatistics.ExceptionCollector;
import com.aotain.common.utils.monitorstatistics.ModuleConstant;
import com.aotain.common.utils.redis.MessageNoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 访问日志策略下发service
 *
 * @author daiyh@aotain.com
 * @date 2017/11/16
 */

@Service
public class AccessLogPolicyService extends BaseService {

    private static Logger logger = LoggerFactory.getLogger(AccessLogPolicyService.class);

    @Autowired
    private IdcIsmsCfgAccesslogMapper idcIsmsCfgAccesslogMapper;

    @Autowired
    private MessageNameService messageNameService;

    @Autowired
    private HousePolicyBindService housePolicyBindService;

    @Autowired
    private ExceptionCollector exceptionCollector;

    @Override
    public boolean addDb(BaseVo policy) {
        try {
            setPropertiesBeforeSaveOrUpdate(policy);
            IdcIsmsCfgAccessLog idcIsmsCfgAccesslog = (IdcIsmsCfgAccessLog) policy;

            IdcIsmsCfgAccessLog result = idcIsmsCfgAccesslogMapper.selectByAccessFlag(idcIsmsCfgAccesslog.getAccessLogFlag());

            if (result != null) {
                logger.info("modify accessLog to db start..." + policy.objectToJson());
                //修改
                idcIsmsCfgAccesslogMapper.addByAccessLogFlag(idcIsmsCfgAccesslog);
                idcIsmsCfgAccesslog.setMessageNo(result.getMessageNo());
                idcIsmsCfgAccesslog.setOperationType(OperationConstants.OPERATION_SAVE);
                messageNameService.modifyMessageNameByAccessLog(idcIsmsCfgAccesslog);
            } else {
                logger.info("add accessLog to db start..." + policy.objectToJson());
                // 手动设置messageNo
                idcIsmsCfgAccesslog.setMessageNo(MessageNoUtil.getInstance().getMessageNo(policy.getMessageType()));
                idcIsmsCfgAccesslog.setOperationType(OperationConstants.OPERATION_SAVE);
                idcIsmsCfgAccesslogMapper.insertData(idcIsmsCfgAccesslog);
                //添加数据到messageNo表
                messageNameService.addMessageName(idcIsmsCfgAccesslog);
            }
            logger.info("add accessLog to db success..." + policy.objectToJson());

        }catch (Exception e) {
            logger.error(this.getClass().getName()+" addDb error,Param="+policy.objectToJson() ,e);
            exceptionCollector.addEvent(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean modifyDb(BaseVo policy) {
        try{
            setPropertiesBeforeSaveOrUpdate(policy);

            IdcIsmsCfgAccessLog result = idcIsmsCfgAccesslogMapper.selectByAccessFlag(((IdcIsmsCfgAccessLog) policy).getAccessLogFlag());
            IdcIsmsCfgAccessLog idcIsmsCfgAccesslog = (IdcIsmsCfgAccessLog)policy;
            idcIsmsCfgAccesslogMapper.updateByAccessLogFlag(idcIsmsCfgAccesslog);
        }catch (Exception e){
            logger.error(this.getClass().getName()+" modifyDb error,Param="+policy.objectToJson() ,e);
            exceptionCollector.addEvent(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteDb(BaseVo policy) {
        try{
            setPropertiesBeforeSaveOrUpdate(policy);

            IdcIsmsCfgAccessLog idcIsmsCfgAccesslog = (IdcIsmsCfgAccessLog)policy;
            logger.info("delete accessLog from db begin..."+policy.objectToJson());
            int count = idcIsmsCfgAccesslogMapper.deleteByAccessLogFlag(idcIsmsCfgAccesslog);
            logger.info("deleteByAccessLogFlag had been successed..."+policy.objectToJson());
            if ( count > 0) {
                IdcIsmsCfgAccessLog result = idcIsmsCfgAccesslogMapper.selectByAccessFlag(
                        ((IdcIsmsCfgAccessLog) policy).getAccessLogFlag());
                idcIsmsCfgAccesslog.setMessageNo(result.getMessageNo());
                messageNameService.deleteMessageName(idcIsmsCfgAccesslog);
            } else {
                logger.error("deleteByAccessLogFlag had been failed,it is no record exist or delete failed"+policy.objectToJson());
            }

        } catch (Exception e){
            logger.error(this.getClass().getName()+" deleteDb error,Param="+policy.objectToJson() ,e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
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
        return true;
    }

    @Override
    protected boolean deleteCustomLogic(BaseVo policy) {
        // 是否成功标志
        boolean success = setPolicyOperateSequenceToRedis(policy);
        if (!success) {
            logger.error("setPolicyOperateSequenceToRedis failed..."+policy.objectToJson());
            return false;
        }
        success = deleteAccessLogBindPolicy(policy);
        if (!success ) {
            logger.error("deleteAccessLogBindPolicy failed..."+policy.objectToJson());
            return false;
        }
        success = setPolicyOperateSequenceToRedis(policy);
        if (!success) {
            logger.error("setPolicyOperateSequenceToRedis failed..."+policy.objectToJson());
            return false;
        }

        return true;
    }

    /**
     * 删除策略对应的绑定策略
     * @param policy
     * @return
     */
    private boolean deleteAccessLogBindPolicy(BaseVo policy){
        try{
            //获得已经绑定机房策略
            List<HousePolicyBind> bindList = getBindPolicy(policy);
            boolean result =  housePolicyBindService.deletePolicy(bindList);
            if(!result){
                logger.error("delete policy bind list error! msg=" + policy.objectToJson());
                return false;
            }
        } catch (Exception e){
            logger.error(this.getClass().getName()+" deleteAccessLogBindPolicy error,Param="+policy.objectToJson() ,e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    public List<IdcIsmsCfgAccessLog> selectAllAccessFlag(){
        return idcIsmsCfgAccesslogMapper.selectAllAccessFlag();
    }
}
