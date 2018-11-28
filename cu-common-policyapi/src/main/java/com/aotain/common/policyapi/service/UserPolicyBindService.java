package com.aotain.common.policyapi.service;

import com.aotain.common.policyapi.base.BaseService;
import com.aotain.common.policyapi.base.BaseVo;
import com.aotain.common.policyapi.mapper.UserPolicyBindMapper;
import com.aotain.common.policyapi.model.BindMessage;
import com.aotain.common.policyapi.model.UserPolicyBind;
import com.aotain.common.utils.monitorstatistics.ExceptionCollector;
import com.aotain.common.utils.monitorstatistics.ModuleConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/12/20
 */
@Service("userPolicyBindServices")
public class UserPolicyBindService extends BaseService{

    private static Logger logger = LoggerFactory.getLogger(UserPolicyBindService.class);

    @Resource(name="userPolicyBindMappers")
    private UserPolicyBindMapper userPolicyBindMapper;

    @Autowired
    private MessageNameService messageNameService;

    @Autowired
    private ExceptionCollector exceptionCollector;

    @PostConstruct
    public void setMapper(){
        this.mapper = userPolicyBindMapper;
    }

    @Override
    protected boolean addDb(BaseVo policy) {
        setPropertiesBeforeSaveOrUpdate(policy);

        try{
            UserPolicyBind userPolicyBind = (UserPolicyBind)policy;
            List<BindMessage> bindInfo = userPolicyBind.getBindInfo();
            for (int i = 0; i < bindInfo.size(); i++) {
                userPolicyBind.setBindMessageNo(bindInfo.get(i).getBindMessageNo());
                userPolicyBind.setBindMessageType(bindInfo.get(i).getBindMessageType());
                userPolicyBindMapper.insertData(userPolicyBind);
            }
            messageNameService.addMessageName(policy);
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" addDb error,Param="+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    @Override
    protected boolean modifyDb(BaseVo policy) {
        setPropertiesBeforeSaveOrUpdate(policy);

        try{
            UserPolicyBind userPolicyBind = (UserPolicyBind)policy;
            List<BindMessage> bindInfo = userPolicyBind.getBindInfo();
            for (int i = 0; i < bindInfo.size(); i++) {
                userPolicyBind.setBindMessageNo(bindInfo.get(i).getBindMessageNo());
                userPolicyBind.setBindMessageType(bindInfo.get(i).getBindMessageType());
                userPolicyBindMapper.updateDataByBindMessageNoAndType(userPolicyBind);
            }
            if ( userPolicyBind.getMessageNo()==null|| userPolicyBind.getMessageNo()==0){
                UserPolicyBind result =userPolicyBindMapper.selectByPrimaryKey(userPolicyBind);
                userPolicyBind.setMessageNo(result.getMessageNo());
            }
            messageNameService.modifyMessageName(policy);
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" modifyDb error,Param="+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }
        return true;
    }

    @Override
    protected boolean deleteDb(BaseVo policy) {
        setPropertiesBeforeSaveOrUpdate(policy);

        try{
            UserPolicyBind userPolicyBind = (UserPolicyBind)policy;
            userPolicyBindMapper.deleteDataByMessageNo(userPolicyBind);
            if ( userPolicyBind.getMessageNo()==null||userPolicyBind.getMessageNo()==0 ){
                UserPolicyBind result =userPolicyBindMapper.selectByPrimaryKey(userPolicyBind);
                userPolicyBind.setMessageNo(result.getMessageNo());
            }
            messageNameService.deleteMessageName(policy);
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
        return sendRedisMessage(policy);
    }


}
