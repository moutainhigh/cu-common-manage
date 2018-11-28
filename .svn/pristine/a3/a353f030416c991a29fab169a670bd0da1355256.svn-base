package com.aotain.common.policyapi.service;

import com.alibaba.fastjson.JSON;
import com.aotain.common.config.redis.BaseRedisService;
import com.aotain.common.policyapi.base.BaseService;
import com.aotain.common.policyapi.base.BaseVo;
import com.aotain.common.policyapi.mapper.DpiV1CfgDpiinfoHouseMapper;
import com.aotain.common.policyapi.mapper.DpiV1CfgDpiinfoMapper;
import com.aotain.common.policyapi.model.DpiV1CfgDpiinfo;
import com.aotain.common.policyapi.model.DpiV1CfgDpiinfoHouse;
import com.aotain.common.utils.monitorstatistics.ExceptionCollector;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * EU设备策略下发service
 *
 * @author daiyh@aotain.com
 * @date 2017/11/16
 */

@Service
public class EuDevicePolicyService extends BaseService {

    private static Logger logger = LoggerFactory.getLogger(EuDevicePolicyService.class);

    @Autowired
    private DpiV1CfgDpiinfoMapper mapper;

    @Autowired
    private DpiV1CfgDpiinfoHouseMapper dpiV1CfgDpiinfoHouseMapper;

    @Autowired
    private MessageNameService messageNameService;

    @Autowired
    private BaseRedisService<String,String,String> baseRedisService;

    @Autowired
    private ExceptionCollector exceptionCollector;

    @Override
    public boolean addDb(BaseVo policy) {
        try{
            setPropertiesBeforeSaveOrUpdate(policy);

            //添加DPI设备信息
            DpiV1CfgDpiinfo dpiV1CfgDpiinfo = (DpiV1CfgDpiinfo)policy;
            addEuDeviceInfo(dpiV1CfgDpiinfo);
        }  catch (Exception e) {
            logger.error(this.getClass().getName()+" addDb error,Param[policy=]"+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean modifyDb(BaseVo policy) {
        try{
            setPropertiesBeforeSaveOrUpdate(policy);

            //更新DPI设备信息
            DpiV1CfgDpiinfo dpiV1CfgDpiinfo = (DpiV1CfgDpiinfo)policy;
            modifyEuDeviceInfo(dpiV1CfgDpiinfo);
        }  catch (Exception e) {
            logger.error(this.getClass().getName()+" modifyDb error,Param[policy=]"+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteDb(BaseVo policy) {
        try{
            setPropertiesBeforeSaveOrUpdate(policy);

            //删除DPI设备信息
            DpiV1CfgDpiinfo dpiV1CfgDpiinfo = (DpiV1CfgDpiinfo)policy;
            int result = mapper.deleteData(dpiV1CfgDpiinfo);
            //删除数据到messageName表
            if ( result > 0) {
                setUnSetPropertiesForChannel(dpiV1CfgDpiinfo);
                messageNameService.deleteMessageName(dpiV1CfgDpiinfo);
            }
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" deleteDb error,Param[policy=]"+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }
        return true;
    }

    /**
     * 删除时给一些通道需要的参数赋值
     * @param dpiV1CfgDpiinfo
     * @return
     */
    private void setUnSetPropertiesForChannel(DpiV1CfgDpiinfo dpiV1CfgDpiinfo){
        DpiV1CfgDpiinfo searchResult = mapper.selectByPrimaryKey(dpiV1CfgDpiinfo.getDevId());
        dpiV1CfgDpiinfo.setMessageNo(searchResult.getMessageNo());
        dpiV1CfgDpiinfo.setIp(searchResult.getIp());
        dpiV1CfgDpiinfo.setPort(searchResult.getPort());
        dpiV1CfgDpiinfo.setIdcPort(searchResult.getIdcPort());
        dpiV1CfgDpiinfo.setDevName(searchResult.getDevName());
        dpiV1CfgDpiinfo.setDeploySiteName(searchResult.getDeploySiteName());
        List<String> dpiV1CfgDpiinfoHouses =
                dpiV1CfgDpiinfoHouseMapper.selectHouseIdListByDevId(dpiV1CfgDpiinfo.getDevId());
        dpiV1CfgDpiinfo.setIdcHouseIds(dpiV1CfgDpiinfoHouses);
    }

    /**
     * 添加Eu设备信息(包括Eu设备机房信息)
     * @param dpiV1CfgDpiinfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    private void addEuDeviceInfo(DpiV1CfgDpiinfo dpiV1CfgDpiinfo){
        try{
            //添加Eu设备信息
            mapper.insertData(dpiV1CfgDpiinfo);
            //获取eu设备关联的house_id
            List<String> houseIds = dpiV1CfgDpiinfo.getIdcHouseIds();
            addEuDeviceHouseInfo(dpiV1CfgDpiinfo.getDevId(),houseIds);
            //添加数据到messageName表
            messageNameService.addMessageName(dpiV1CfgDpiinfo);
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" addEuDeviceInfo error,Param[dpiV1CfgDpiinfo=]"+dpiV1CfgDpiinfo.objectToJson(),e);
            exceptionCollector.addEvent(e);
        }

    }

    @Transactional(rollbackFor = Exception.class)
    private void addEuDeviceHouseInfo(long devId,List<String> houseIdArr){
        try{
            DpiV1CfgDpiinfoHouse dpiV1CfgDpiinfoHouse = new DpiV1CfgDpiinfoHouse();
            if(null==houseIdArr||houseIdArr.size()==0){
                return;
            }
            // 添加Eu设备信息相关联的机房信息
            for(String houseId:houseIdArr){
                dpiV1CfgDpiinfoHouse.setDevId(devId);
                dpiV1CfgDpiinfoHouse.setHouseId(houseId);
                dpiV1CfgDpiinfoHouseMapper.insertData(dpiV1CfgDpiinfoHouse);
            }
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" addEuDeviceHouseInfo error,Param[devId=]"+devId+",[houseIdArr=]"+houseIdArr,e);
            exceptionCollector.addEvent(e);
        }

    }

    /**
     * 修改Eu设备信息
     * @param dpiV1CfgDpiinfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    private boolean modifyEuDeviceInfo(DpiV1CfgDpiinfo dpiV1CfgDpiinfo){
        try{
            mapper.updateData(dpiV1CfgDpiinfo);
            if (dpiV1CfgDpiinfo.getMessageNo()==null||dpiV1CfgDpiinfo.getMessageNo()==0) {
                DpiV1CfgDpiinfo result = mapper.selectByPrimaryKey(dpiV1CfgDpiinfo.getDevId());
                dpiV1CfgDpiinfo.setMessageNo(result.getMessageNo());
            }
            //删除dpi设备相关的house信息
            DpiV1CfgDpiinfoHouse dpiV1CfgDpiinfoHouse = new DpiV1CfgDpiinfoHouse();
            dpiV1CfgDpiinfoHouse.setDevId(dpiV1CfgDpiinfo.getDevId());
            dpiV1CfgDpiinfoHouseMapper.deleteData(dpiV1CfgDpiinfoHouse);
            addEuDeviceHouseInfo(dpiV1CfgDpiinfo.getDevId(),dpiV1CfgDpiinfo.getIdcHouseIds());
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" modifyEuDeviceInfo error,Param[dpiV1CfgDpiinfo=]"+dpiV1CfgDpiinfo.objectToJson(),e);
            exceptionCollector.addEvent(e);
        }

        return true;
    }


    @Override
    public boolean addCustomLogic(BaseVo policy) {
        boolean success = setPolicyToRedisTask(policy);
        if(!success) {
            logger.error("setPolicyToRedisTask failed..."+policy.objectToJson());
            return false;
        }
        return setServerStatusAndChannelToRedis(policy);

    }

    @Override
    protected boolean modifyCustomLogic(BaseVo policy) {

        // 是否成功标志
        boolean success = setPolicyToRedisTask(policy);
        if(!success) {
            logger.error("setPolicyToRedisTask failed..."+policy.objectToJson());
            return false;
        }

        success = modifyServerStatusToRedis(policy);
        if (!success){
            logger.error("modifyServerStatusToRedis failed..."+policy.objectToJson());
            return false;
        }

        success = publishRedisChannel(policy);
        if (!success) {
            logger.error("publishRedisChannel failed...");
            return false;
        }
        return success;
    }

    @Override
    protected boolean deleteCustomLogic(BaseVo policy) {
        boolean success = setPolicyToRedisTask(policy);
        if(!success) {
            logger.error("setPolicyToRedisTask failed..."+policy.objectToJson());
            return false;
        }
        success = deleteServerStatusToRedis(policy);
        if(!success) {
            logger.error("deleteServerStatusToRedis failed...");
            return false;
        }

        success = publishRedisChannel(policy);
        if(!success) {
            logger.error("publishRedisChannel failed...");
            return false;
        }
        return success;

    }

    private boolean addServerStatusToRedis(BaseVo policy) {
        try{
            DpiV1CfgDpiinfo dpiV1CfgDpiinfo = (DpiV1CfgDpiinfo)policy;
            Map<String,Long> info = Maps.newHashMap();

            info.put("status",0L);
            info.put("lastUpdateTime",System.currentTimeMillis()/1000);
            if (dpiV1CfgDpiinfo.getPort()!=null&&dpiV1CfgDpiinfo.getPort()!=0){
                baseRedisService.putHash("ServerStatus_0_193",dpiV1CfgDpiinfo.getIp(), JSON.toJSONString(info));
            }

            baseRedisService.putHash("ServerStatus_1_193",dpiV1CfgDpiinfo.getIp(), JSON.toJSONString(info));
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" addServerStatusToRedis error,Param[policy=]"+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    private boolean modifyServerStatusToRedis(BaseVo policy) {
        try{
            DpiV1CfgDpiinfo dpiV1CfgDpiinfo = (DpiV1CfgDpiinfo)policy;
            Map<String,Long> info = Maps.newHashMap();

            info.put("status",0L);
            info.put("lastUpdateTime",System.currentTimeMillis()/1000);
            if (dpiV1CfgDpiinfo.getPort()==null||dpiV1CfgDpiinfo.getPort()==0){
                baseRedisService.removeHash("ServerStatus_0_193",dpiV1CfgDpiinfo.getIp());
            } else {
                baseRedisService.putHash("ServerStatus_0_193",dpiV1CfgDpiinfo.getIp(),JSON.toJSONString(info));
            }

            baseRedisService.putHash("ServerStatus_1_193",dpiV1CfgDpiinfo.getIp(), JSON.toJSONString(info));
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" modifyServerStatusToRedis error,Param[policy=]"+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    private boolean deleteServerStatusToRedis(BaseVo policy) {
        try{
            DpiV1CfgDpiinfo dpiV1CfgDpiinfo = (DpiV1CfgDpiinfo)policy;
            baseRedisService.removeHash("ServerStatus_0_193",dpiV1CfgDpiinfo.getIp());
            baseRedisService.removeHash("ServerStatus_1_193",dpiV1CfgDpiinfo.getIp());
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" deleteServerStatusToRedis error,Param[policy=]"+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }

    private boolean setServerStatusAndChannelToRedis(BaseVo policy){
        try{
            boolean success = addServerStatusToRedis(policy);
            if (!success) {
                logger.error("addServerStatusToRedis failed...");
                return false;
            }
            success = publishRedisChannel(policy);
            if (!success) {
                logger.error("publishRedisChannel failed...");
                return false;
            }
        } catch (Exception e) {
            logger.error(this.getClass().getName()+" setServerStatusAndChannelToRedis error,Param[policy=]"+policy.objectToJson(),e);
            exceptionCollector.addEvent(e);
            return false;
        }

        return true;
    }
}
