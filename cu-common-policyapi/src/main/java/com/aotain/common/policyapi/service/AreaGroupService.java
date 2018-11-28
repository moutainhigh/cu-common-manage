package com.aotain.common.policyapi.service;

import com.aotain.common.policyapi.base.BaseService;
import com.aotain.common.policyapi.base.BaseVo;
import com.aotain.common.policyapi.mapper.AreaGroupAsMapper;
import com.aotain.common.policyapi.mapper.AreaGroupMapper;
import com.aotain.common.policyapi.model.AreaGroup;
import com.aotain.common.policyapi.model.AreaGroupAs;
import com.aotain.common.policyapi.model.AreaGroupDTO;
import com.aotain.common.utils.monitorstatistics.ExceptionCollector;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 流量流向策略service
 *
 * @author daiyh@aotain.com
 * @date 2017/12/20
 */
@Service("areaGroupServices")
public class AreaGroupService extends BaseService{

    private static Logger logger = LoggerFactory.getLogger(AreaGroupService.class);

    @Resource(name="areaGroupMappers")
    private AreaGroupMapper areaGroupMapper;

    @Resource(name="areaGroupAsMappers")
    private AreaGroupAsMapper areaGroupAsMapper;

    @Autowired
    private MessageNameService messageNameService;

    @Autowired
    private ExceptionCollector exceptionCollector;

    @Override
    protected boolean addDb(BaseVo policy) {

        try{
            setPropertiesBeforeSaveOrUpdate(policy);
            AreaGroupDTO areaGroupDTO = (AreaGroupDTO)policy;

            addAreaGroupAndAreaGroupAsInfo(areaGroupDTO);

            messageNameService.addMessageName(areaGroupDTO);
        } catch (Exception e){
            logger.error(this.getClass().getName()+" addDb error,Param="+policy.objectToJson() ,e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    protected boolean modifyDb(BaseVo policy) {
        try{
            setPropertiesBeforeSaveOrUpdate(policy);
            AreaGroupDTO areaGroupDTO = (AreaGroupDTO)policy;
            // 删除
            deleteAreaGroupAndAreaGroupAsInfo(areaGroupDTO);
            // 新增
            addAreaGroupAndAreaGroupAsInfo(areaGroupDTO);
            messageNameService.modifyMessageName(areaGroupDTO);
        } catch (Exception e){
            logger.error(this.getClass().getName()+" modifyDb error,Param="+policy.objectToJson() ,e);
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
            AreaGroupDTO areaGroupDTO = (AreaGroupDTO)policy;
            deleteAreaGroupAndAreaGroupAsInfo(areaGroupDTO);
            messageNameService.deleteMessageName(areaGroupDTO);
        } catch (Exception e){
            logger.error(this.getClass().getName()+" deleteDb error,Param="+policy.objectToJson() ,e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    private boolean addAreaGroupAndAreaGroupAsInfo(AreaGroupDTO areaGroupDTO) {
        try{
            List<AreaGroup> internalAreaGroup = areaGroupDTO.getInternalAreaGroupInfo();
            addAreaGroupList(internalAreaGroup,areaGroupDTO);

            List<AreaGroup> externalAreaGroup = areaGroupDTO.getExternalAreaGroupInfo();
            addAreaGroupList(externalAreaGroup,areaGroupDTO);
        }  catch (Exception e){
            logger.error(this.getClass().getName()+" addAreaGroupAndAreaGroupAsInfo error,Param="+areaGroupDTO.objectToJson() ,e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    private boolean addAreaGroupList(List<AreaGroup> internalAreaGroup,AreaGroupDTO areaGroupDTO){
        try{
            if(internalAreaGroup==null){
                logger.error("areaGroupList cannot be null..."+internalAreaGroup.toString());
                return false;
            }
            for (AreaGroup areaGroup:internalAreaGroup){
                areaGroup.setMessageNo(areaGroupDTO.getMessageNo());
                areaGroup.setMessageType(areaGroupDTO.getMessageType());
                areaGroup.setProbeType(areaGroupDTO.getProbeType());
                areaGroup.setMessageSequenceNo(areaGroupDTO.getMessageSequenceNo());
                areaGroup.setOperationType(areaGroupDTO.getOperationType());
                areaGroup.setSeqOperType(areaGroupDTO.getOperationType());
                areaGroupMapper.insertData(areaGroup);


                List<AreaGroupAs> areaGroupAsList = areaGroup.getAreaGroupAsList();
                List<Long> ids = Lists.newArrayList();
                List<String> names = Lists.newArrayList();
                for(AreaGroupAs areaGroupAs:areaGroupAsList) {
                    areaGroupAs.setAreaGroupId(areaGroup.getAreaGroupId());

                    areaGroupAsMapper.insertData(areaGroupAs);
                    ids.add(areaGroupAs.getAsAreaId());
                    names.add(areaGroupAs.getAsAreaName());
                }
                areaGroup.setAsIds(ids);
                areaGroup.setAreaNames(names);

            }
        }  catch (Exception e){
            logger.error(this.getClass().getName()+" addAreaGroupList error,Param[policy=]"+areaGroupDTO.objectToJson() ,e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    /**
     * 删除AreaGroup以及相关的AreaGroupAs信息
     * @param areaGroupDTO
     * @return
     */
    private boolean deleteAreaGroupAndAreaGroupAsInfo(AreaGroupDTO areaGroupDTO){
        try{
            // 删除关联的areaGroupAs信息
            List<AreaGroup> sourAreaGroups = areaGroupMapper.selectSour(areaGroupDTO.getMessageNo());
            for (AreaGroup areaGroup1:sourAreaGroups) {
                areaGroupAsMapper.deleteDataByAreaGroupId(areaGroup1.getAreaGroupId());
            }
            List<AreaGroup> destAreaGroups = areaGroupMapper.selectDest(areaGroupDTO.getMessageNo());
            for (AreaGroup areaGroup1:destAreaGroups) {
                areaGroupAsMapper.deleteDataByAreaGroupId
                        (areaGroup1.getAreaGroupId());
            }
            // 根据messageNo删除areaGroup信息
            areaGroupMapper.deleteDataByMessageNo(areaGroupDTO.getMessageNo());
        }  catch (Exception e){
            logger.error(this.getClass().getName()+" deleteAreaGroupAndAreaGroupAsInfo error,Param[policy=]"+areaGroupDTO.objectToJson() ,e);
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

        return true;
    }
}
