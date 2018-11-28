package com.aotain.common.policyapi.service;

import com.aotain.common.policyapi.base.BaseService;
import com.aotain.common.policyapi.base.BaseVo;
import com.aotain.common.policyapi.constant.OperationConstants;
import com.aotain.common.policyapi.mapper.IpAddressAllocationMapper;
import com.aotain.common.policyapi.model.IpAddressAllocation;
import com.aotain.common.utils.monitorstatistics.ExceptionCollector;
import com.aotain.common.utils.monitorstatistics.ModuleConstant;
import com.aotain.common.utils.redis.MessageNoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * IP地址库下发策略service类
 *
 * @author daiyh@aotain.com
 * @date 2017/12/25
 */
@Service
public class IpAddressAllocationService extends BaseService{

    private static Logger logger = LoggerFactory.getLogger(IpAddressAllocationService.class);

    @Autowired
    private IpAddressAllocationMapper ipAddressAllocationMapper;

    @Autowired
    private MessageNameService messageNameService;

    @Autowired
    private ExceptionCollector exceptionCollector;

    @Override
    @Transactional(rollbackFor = Exception.class)
    protected boolean addDb(BaseVo policy) {
        try{
            setPropertiesBeforeSaveOrUpdate(policy);

            IpAddressAllocation ipAddressAllocation = (IpAddressAllocation)policy;

            IpAddressAllocation result = ipAddressAllocationMapper.selectByDataType(ipAddressAllocation.getDataType());

            if (result !=null){
                logger.info("modify ipAddressAllocation to db start..."+policy.objectToJson());
                //修改
                ipAddressAllocation.setOperationType(OperationConstants.OPERATION_SAVE);
                ipAddressAllocationMapper.updateData(ipAddressAllocation);
                if(ipAddressAllocation.getMessageNo()==null||ipAddressAllocation.getMessageNo()==0){
                    ipAddressAllocation.setMessageNo(result.getMessageNo());
                }
                messageNameService.modifyMessageNameByIpAddressAllocation(ipAddressAllocation);
            } else {
                logger.info("add ipAddressAllocation to db start..."+policy.objectToJson());
                // 手动设置messageNo
                ipAddressAllocation.setMessageNo(MessageNoUtil.getInstance().getMessageNo(policy.getMessageType()));
                ipAddressAllocation.setOperationType(OperationConstants.OPERATION_SAVE);
                ipAddressAllocationMapper.insertData(ipAddressAllocation);
                //添加数据到messageNo表
                messageNameService.addMessageName(ipAddressAllocation);
            }

        } catch (Exception e) {
            logger.error(this.getClass().getName()+" addDb error,Param="+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    @Override
    protected boolean modifyDb(BaseVo policy) {
        try{
            setPropertiesBeforeSaveOrUpdate(policy);

            IpAddressAllocation ipAddressAllocation = (IpAddressAllocation)policy;
            ipAddressAllocationMapper.updateData(ipAddressAllocation);
        }catch (Exception e) {
            logger.error(this.getClass().getName()+" modifyDb error,Param="+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    protected boolean deleteDb(BaseVo policy) {
        try{
            setPropertiesBeforeSaveOrUpdate(policy);

            IpAddressAllocation ipAddressAllocation = (IpAddressAllocation)policy;
            ipAddressAllocationMapper.deleteData(ipAddressAllocation);
            if (ipAddressAllocation.getMessageNo()==null||ipAddressAllocation.getMessageNo()==0){
                IpAddressAllocation result = ipAddressAllocationMapper.selectByDataType(ipAddressAllocation.getDataType());
                ipAddressAllocation.setMessageNo(result.getMessageNo());
            }
            ipAddressAllocation.setOperationType(OperationConstants.OPERATION_DELETE);
            messageNameService.deleteMessageName(ipAddressAllocation);
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" deleteDb error,Param="+policy.objectToJson(),e);
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
        return true;
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
