package com.aotain.common.policyapi.service;

import com.aotain.common.policyapi.base.BaseService;
import com.aotain.common.policyapi.base.BaseVo;
import com.aotain.common.policyapi.constant.OperationConstants;
import com.aotain.common.policyapi.mapper.EuDeviceStatusMapper;
import com.aotain.common.policyapi.model.EuDeviceStatus;
import com.aotain.common.utils.monitorstatistics.ExceptionCollector;
import com.aotain.common.utils.monitorstatistics.ModuleConstant;
import com.aotain.common.utils.redis.MessageNoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * EU状态Policy服务类
 *
 * @author daiyh@aotain.com
 * @date 2017/11/30
 */
@Service
public class EuStatusPolicyService extends BaseService{

    private static Logger logger = LoggerFactory.getLogger(EuDevicePolicyService.class);

	@Autowired
    private EuDeviceStatusMapper euDeviceStatusMapper;

	@Autowired
    private MessageNameService messageNameService;

    @Autowired
    private ExceptionCollector exceptionCollector;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addDb(BaseVo policy) {
        try{
            setPropertiesBeforeSaveOrUpdate(policy);

            EuDeviceStatus euDeviceStatus = (EuDeviceStatus)policy;
            EuDeviceStatus result = euDeviceStatusMapper.selectByRType(euDeviceStatus.getRType());

            if ( result == null ) {
                //新增
                policy.setOperationType(OperationConstants.OPERATION_SAVE);
                euDeviceStatus.setMessageNo(MessageNoUtil.getInstance().getMessageNo(policy.getMessageType()));
                euDeviceStatusMapper.insertData(euDeviceStatus);
                //  添加相关信息到messageNo表中
                messageNameService.addMessageName(euDeviceStatus);
            } else {
                //修改
                policy.setOperationType(OperationConstants.OPERATION_UPDATE);
                euDeviceStatusMapper.updateData(euDeviceStatus);

                if ( euDeviceStatus.getMessageNo()==null || euDeviceStatus.getMessageNo()==0 ){
                    euDeviceStatus.setMessageNo(result.getMessageNo());
                }
                messageNameService.modifyMessageName(euDeviceStatus);
            }
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" addDb/modifyDb error,Param[policy=]"+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    @Override
    public boolean modifyDb(BaseVo policy) {
        try{
            setPropertiesBeforeSaveOrUpdate(policy);
        } catch (Exception e) {
            exceptionCollector.addEvent(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteDb(BaseVo policy) {
        try{
            setPropertiesBeforeSaveOrUpdate(policy);
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" deleteDb error,Param[policy=]"+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean addCustomLogic(BaseVo policy) {

        return addTaskAndChannelToRedis(policy);
    }

    @Override
    protected boolean modifyCustomLogic(BaseVo policy) {

        return addTaskAndChannelToRedis(policy);
    }

    @Override
    protected boolean deleteCustomLogic(BaseVo policy) {
        return true;
    }
}
