package com.aotain.common.policyapi.service;

import com.aotain.common.policyapi.base.BaseVo;
import com.aotain.common.policyapi.constant.MessageTypeConstants;
import com.aotain.common.policyapi.mapper.MessageNameMapper;
import com.aotain.common.policyapi.model.*;
import com.aotain.common.utils.monitorstatistics.ExceptionCollector;
import com.aotain.common.utils.monitorstatistics.ModuleConstant;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/11/21
 */
@Service
public class MessageNameService {

    private static Logger logger = LoggerFactory.getLogger(MessageNameService.class);

    @Autowired
    private MessageNameMapper messageNameMapper;

    @Autowired
    private ExceptionCollector exceptionCollector;

    public int addMessageName(BaseVo policy){
        int updateColumn = 0;
        try{
            logger.info("add messageNo to db start..."+policy.objectToJson());
            int result = messageNameMapper.selectByMessageNoAndType(policy);
            //不存在
            if(result<=0){
                // 添加messageName表时，若不存在messageName则设置当前时间戳为messageName
                if(StringUtils.isEmpty(policy.getMessageName())){
                    policy.setMessageName(String.valueOf(System.currentTimeMillis()));
                }
                updateColumn = messageNameMapper.addMessageName(policy);
            }
            logger.info("add messageNo to db success..."+policy.objectToJson());
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" addMessageName error,Param="+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
        }

        return updateColumn;
    }

    public int modifyMessageName(BaseVo policy){
        int result = 0;
        try{
            result =  messageNameMapper.modifyMessageName(policy);
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" modifyMessageName error,Param="+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
        }
        return result;
    }

    public int modifyMessageNameByAccessLog(BaseVo policy){
        int result = 0;
        try{
            result = messageNameMapper.modifyMessageNameByAccessLog(policy);
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" modifyMessageNameByAccessLog error,Param="+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
        }
        return result;
    }

    public int modifyMessageNameByIpAddressAllocation(BaseVo policy){
        int result = 0;
        try{
            result = messageNameMapper.modifyMessageNameByIpAddressAllocation(policy);
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" modifyMessageNameByIpAddressAllocation error,Param="+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
        }
        return result;
    }

    public int deleteMessageName(BaseVo policy){
        int result = 0;
        try{
            // 删除policy时同时删除关联的messageNo表(根据messageNo和messageType删除)
            // messageNo由前端传递，messageType已知直接在此处赋值
            if (policy instanceof DpiV1CfgDpiinfo) {
                DpiV1CfgDpiinfo dpiV1CfgDpiinfo = (DpiV1CfgDpiinfo)policy;
                dpiV1CfgDpiinfo.setMessageType(MessageTypeConstants.MESSAGE_TYPE_DPI_INFO);

            } else if (policy instanceof HouseIp) {
                HouseIp houseIp = ( HouseIp ) policy;
                houseIp.setMessageType(MessageTypeConstants.MESSAGE_TYPE_HOUSE_IP);

            } else if (policy instanceof HousePolicyBind) {
                HousePolicyBind housePolicyBind = ( HousePolicyBind ) policy;
                housePolicyBind.setMessageType(MessageTypeConstants.MESSAGE_TYPE_HOUSE_POLICY_BIND);

                housePolicyBind.setBindAction(2);

            } else if (policy instanceof IdcIsmsCfgAccessLog) {
                IdcIsmsCfgAccessLog idcIsmsCfgAccessLog = ( IdcIsmsCfgAccessLog ) policy;
                idcIsmsCfgAccessLog.setMessageType(MessageTypeConstants.MESSAGE_TYPE_ACCESS_LOG);

            } else if (policy instanceof IdcIsmsCfgFlowupload) {
                IdcIsmsCfgFlowupload idcIsmsCfgFlowupload = ( IdcIsmsCfgFlowupload ) policy;
                idcIsmsCfgFlowupload.setMessageType(MessageTypeConstants.MESSAGE_TYPE_FLOW_UPLOAD);

            } else if (policy instanceof ISPMessagePolicy) {
                ISPMessagePolicy ispMessagePolicy = ( ISPMessagePolicy ) policy;
                ispMessagePolicy.setMessageType(MessageTypeConstants.MESSAGE_TYPE_ISP_MESSAGE_POLICY);

            }
            result = messageNameMapper.deleteMessageName(policy);
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" deleteMessageName error,Param="+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
        }

        return result;
    }

    public List<MessageName> selectAllTypeMaxMessageNo(){
        return messageNameMapper.selectAllTypeMaxMessageNo();
    }
}
