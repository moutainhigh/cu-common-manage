package com.aotain.common.policyapi;

import com.aotain.common.policyapi.base.BaseVo;
import com.aotain.common.policyapi.mapper.*;
import com.aotain.common.policyapi.model.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/11/17
 */
public class MapperTest extends BaseTest{

    @Autowired
    private DpiV1CfgDpiinfoMapper dpiV1CfgDpiinfoMapper;

    @Autowired
    private IdcIsmsCfgAccesslogMapper idcIsmsCfgAccesslogMapper;

    @Autowired
    private IdcIsmsCfgFlowuploadMapper idcIsmsCfgFlowuploadMapper;

    @Autowired
    private DpiV1CfgDpiinfoHouseMapper dpiV1CfgDpiinfoHouseMapper;

    @Autowired
    private IdcIsmsCfgFlowuploadServerMapper idcIsmsCfgFlowuploadServerMapper;

    @Autowired
    private ISPMessagePolicyMapper ispMessagePolicyMapper;

    @Autowired
    private HousePolicyBindMapper housePolicyBindMapper;

    @Autowired
    private HouseIpMapper houseIpMapper;

    @Autowired
    private MessageNameMapper messageNameMapper;

    @Autowired
    private UserPolicyBindMapper userPolicyBindMapper;

    @Autowired
    private EuDeviceStatusMapper euDeviceStatusMapper;

    @Test
    public void test(){
        System.out.println("======="+dpiV1CfgDpiinfoMapper);
        System.out.println("======="+idcIsmsCfgAccesslogMapper);
        System.out.println("======="+idcIsmsCfgFlowuploadMapper);
    }

    @Test
    @Rollback(false)
    public void testSaveDpiV1CfgDpiinfo(){
        DpiV1CfgDpiinfo dpiV1CfgDpiinfo = new DpiV1CfgDpiinfo();
        dpiV1CfgDpiinfo.setDevId(1221L);
        dpiV1CfgDpiinfo.setMessageNo(12L);
        dpiV1CfgDpiinfo.setIp("192.168.1.12");
        dpiV1CfgDpiinfo.setPort(80L);
        dpiV1CfgDpiinfo.setDevName("aha");
        dpiV1CfgDpiinfo.setDeploySiteName("haha");
        dpiV1CfgDpiinfo.setOperationType((short) 1);
        dpiV1CfgDpiinfo.setMessageSequenceNo(11L);
        dpiV1CfgDpiinfo.setAreaCode(65L);
        dpiV1CfgDpiinfo.setConnectFlag((short)2);
        dpiV1CfgDpiinfo.setIdcPort(8080L);
        dpiV1CfgDpiinfo.setDevFlag((short)2);
        dpiV1CfgDpiinfoMapper.insertData(dpiV1CfgDpiinfo);
    }

    @Test
    @Rollback(false)
    public void testUpdateDpiV1CfgDpiinfo(){
        DpiV1CfgDpiinfo dpiV1CfgDpiinfo = new DpiV1CfgDpiinfo();
        dpiV1CfgDpiinfo.setDevId(1221L);
        dpiV1CfgDpiinfo.setMessageNo(0012L);
        dpiV1CfgDpiinfo.setIp("192.168.1.12");
        dpiV1CfgDpiinfo.setPort(8088L);
        dpiV1CfgDpiinfo.setDevName("update_aha");
        dpiV1CfgDpiinfo.setDeploySiteName("update_haha");
        dpiV1CfgDpiinfo.setOperationType((short) 1);
        dpiV1CfgDpiinfo.setMessageSequenceNo(0011L);
        dpiV1CfgDpiinfo.setAreaCode(0065L);
        dpiV1CfgDpiinfo.setConnectFlag((short)2);
        dpiV1CfgDpiinfo.setIdcPort(80888L);
        dpiV1CfgDpiinfo.setDevFlag((short)2);
        dpiV1CfgDpiinfoMapper.updateData(dpiV1CfgDpiinfo);
    }

    @Test
    @Rollback(false)
    public void testSaveIdcIsmsCfgFlowupload(){
        IdcIsmsCfgFlowupload idcIsmsCfgFlowupload = new IdcIsmsCfgFlowupload();
        idcIsmsCfgFlowupload.setSeqId(1L);
        idcIsmsCfgFlowupload.setMessageNo(1L);
        idcIsmsCfgFlowupload.setMessageSequenceNo(1L);
        idcIsmsCfgFlowupload.setCreateTime(new Date());
        idcIsmsCfgFlowupload.setMethod(1);
        idcIsmsCfgFlowupload.setOperationType(1);
        idcIsmsCfgFlowupload.setPacketType(1);
        idcIsmsCfgFlowupload.setPacketSubtype(1);
        idcIsmsCfgFlowuploadMapper.insertData(idcIsmsCfgFlowupload);
    }

    @Test
    @Rollback(false)
    public void testUpdateIdcIsmsCfgFlowupload(){
        IdcIsmsCfgFlowupload idcIsmsCfgFlowupload = new IdcIsmsCfgFlowupload();
        idcIsmsCfgFlowupload.setSeqId(760L);
        idcIsmsCfgFlowupload.setMessageNo(2L);
        idcIsmsCfgFlowupload.setMessageSequenceNo(2L);
        idcIsmsCfgFlowupload.setCreateTime(new Date());
        idcIsmsCfgFlowupload.setMethod(2);
        idcIsmsCfgFlowupload.setOperationType(2);
        idcIsmsCfgFlowupload.setPacketType(2);
        idcIsmsCfgFlowupload.setPacketSubtype(2);
        idcIsmsCfgFlowuploadMapper.deleteData(idcIsmsCfgFlowupload);
    }

    @Test
    @Rollback(false)
    public void testSaveIdcIsmsCfgAccesslog(){
        IdcIsmsCfgAccessLog idcIsmsCfgAccesslog = new IdcIsmsCfgAccessLog();
//        idcIsmsCfgAccesslog.setCommonId(1L);
        idcIsmsCfgAccesslog.setMessageNo(10L);
        idcIsmsCfgAccesslog.setAccessLogFlag((short)1);
        idcIsmsCfgAccesslog.setOperationType(10);
        idcIsmsCfgAccesslog.setMessageSequenceNo(20L);
        idcIsmsCfgAccesslog.setModifyTime(new Date());
        idcIsmsCfgAccesslogMapper.insertData(idcIsmsCfgAccesslog);
    }


    @Test
    @Rollback(false)
    public void testUpdateIdcIsmsCfgAccesslog(){
        IdcIsmsCfgAccessLog idcIsmsCfgAccesslog = new IdcIsmsCfgAccessLog();
        idcIsmsCfgAccesslog.setCommonId(699L);
        idcIsmsCfgAccesslog.setMessageSequenceNo(30L);
        idcIsmsCfgAccesslog.setOperationType(2);
        idcIsmsCfgAccesslog.setModifyTime(new Date());
        idcIsmsCfgAccesslogMapper.updateData(idcIsmsCfgAccesslog);
    }

    @Test
    @Rollback(false)
    public void testSaveDpiV1CfgDpiinfoHouse(){
        DpiV1CfgDpiinfoHouse dpiV1CfgDpiinfoHouse = new DpiV1CfgDpiinfoHouse();
        dpiV1CfgDpiinfoHouse.setDevId(1221L);
        dpiV1CfgDpiinfoHouse.setHouseId("abc");
        dpiV1CfgDpiinfoHouseMapper.insertData(dpiV1CfgDpiinfoHouse);
    }

    @Test
    @Rollback(false)
    public void testDeleteDpiV1CfgDpiinfoHouse(){
        DpiV1CfgDpiinfoHouse dpiV1CfgDpiinfoHouse = new DpiV1CfgDpiinfoHouse();
        dpiV1CfgDpiinfoHouse.setDevId(1221L);
//        dpiV1CfgDpiinfoHouse.setHouseId("bca");
        int result = dpiV1CfgDpiinfoHouseMapper.deleteData(dpiV1CfgDpiinfoHouse);
        System.out.println(result+"=====");
    }

    @Test
    @Rollback(false)
    public void testSaveIdcIsmsCfgFlowUploadServer(){
        IdcIsmsCfgFlowUploadServer idcIsmsCfgFlowUploadServer = new IdcIsmsCfgFlowUploadServer();
        idcIsmsCfgFlowUploadServer.setSeqId(11L);
        idcIsmsCfgFlowUploadServer.setDestIp("192.168.1.110");
        idcIsmsCfgFlowUploadServer.setDestPort(80);
        idcIsmsCfgFlowUploadServer.setUserName("bang");
        idcIsmsCfgFlowUploadServer.setPassWord("abc");
        idcIsmsCfgFlowuploadServerMapper.insertData(idcIsmsCfgFlowUploadServer);
    }

    @Test
    @Rollback(false)
    public void testDeleteIdcIsmsCfgFlowUploadServer(){
        IdcIsmsCfgFlowUploadServer idcIsmsCfgFlowUploadServer = new IdcIsmsCfgFlowUploadServer();
        idcIsmsCfgFlowUploadServer.setSeqId(11L);
        idcIsmsCfgFlowuploadServerMapper.deleteData(idcIsmsCfgFlowUploadServer);
    }

    @Test
    @Rollback(false)
    public void testAddPolicy(){
        ISPMessagePolicy ispMessagePolicy = new ISPMessagePolicy();
//        ispMessagePolicy.setCommandId(12L);
        ispMessagePolicy.setMessageNo(1L);
        ispMessagePolicy.setType(1);
        ispMessagePolicy.setBlockFlag(1);
        ispMessagePolicy.setLogFlag(1);
        ispMessagePolicy.setEffectTime(1L);
        ispMessagePolicy.setExpiredTime(2L);
        ispMessagePolicy.setMessageSequenceNo(1L);
        ispMessagePolicy.setUserId(1L);
//        ispMessagePolicy.setUserName("bang");
        ispMessagePolicy.setLevel(12L);
        ispMessagePolicy.setPolicyState(1);
        ispMessagePolicy.setSmmsCommandId(88888L);
        ispMessagePolicy.setActionReason("guess");
        ispMessagePolicy.setIdcID("abcd");
        int result = ispMessagePolicyMapper.insertData(ispMessagePolicy);
        System.out.println(ispMessagePolicy.getCommandId()+"========");
        System.out.println(result+"=======");
    }

    @Test
    @Rollback(false)
    public void testUpdatePolicy(){
        //{type},{blockFlag},{logFlag},{effectTime},{expiredTime},2,{messageSequenceNo},{policyState}
        ISPMessagePolicy ispMessagePolicy = new ISPMessagePolicy();
        ispMessagePolicy.setCommandId(49L);
        ispMessagePolicy.setMessageNo(8L);
        ispMessagePolicy.setType(8);
        ispMessagePolicy.setBlockFlag(8);
        ispMessagePolicy.setLogFlag(8);
        ispMessagePolicy.setExpiredTime(11111L);
        ispMessagePolicy.setEffectTime(2222L);
        ispMessagePolicy.setMessageSequenceNo(8L);
        ispMessagePolicy.setPolicyState(8);
        ispMessagePolicy.setSmmsCommandId(12451L);
        ispMessagePolicy.setActionReason("guess");
        ispMessagePolicy.setIdcID("abcd");
        int result = ispMessagePolicyMapper.updateData(ispMessagePolicy);
        System.out.println(result+"=======");
    }

    @Test
    @Rollback(false)
    public void testAddPolicyRule(){
        // #{ruleId}, #{commandId}, #{subType}, #{valueStart}, #{valueEnd}, #{keywordRange}
        ISPMessagePolicyRule ispMessagePolicyRule = new ISPMessagePolicyRule();
        ispMessagePolicyRule.setCommandId(11L);
//        ispMessagePolicyRule.setRuleId(11L);
        ispMessagePolicyRule.setKeywordRange("abc");
        ispMessagePolicyRule.setSubType(1);
        ispMessagePolicyRule.setValueStart("111");
        ispMessagePolicyRule.setValueEnd("222");
        int result = ispMessagePolicyMapper.insertPolicyRule(ispMessagePolicyRule);
        System.out.println(result+"=======");
    }

    @Test
    public void testAddHousePolicyBind(){
        //{bindId},{houseType},{houseId},{bindMessageType},{bindmessageNo},{messageNo},1,{messageSequenceNo})
        HousePolicyBind housePolicyBind = new HousePolicyBind();
//        housePolicyBind.setBindId(111L);
        housePolicyBind.setHouseType(2);
        housePolicyBind.setHouseId("11");
        housePolicyBind.setBindMessageType(12L);
        housePolicyBind.setBindMessageNo(12L);
        housePolicyBind.setMessageNo(111L);
        housePolicyBind.setMessageSequenceNo(1212L);
        housePolicyBind.setMessageType(12);
        int result = housePolicyBindMapper.insertData(housePolicyBind);
        System.out.println(result+"=======");
    }

    @Test
    @Rollback(false)
    public void testAddHouseIp(){
        // (#{houseId}, #{MessageNo}, 1, #{messageSequenceNo}, sysdate)
        HouseIp houseIp = new HouseIp();
//        houseIp.setHouseId("123");
        houseIp.setMessageNo(111L);
        houseIp.setMessageSequenceNo(12L);
        int result = houseIpMapper.insertData(houseIp);
        System.out.println(result+"=======");
    }

    @Test
    @Rollback(false)
    public void testAddHouseIpIp(){
        // (#{seqId}, #{houseId}, #{houseIp}, #{houseIpPrefix}, 1, #{messageSequenceNo}, sysdate)
        HouseIpIp houseIpIp = new HouseIpIp();
        houseIpIp.setSeqId(12L);
        houseIpIp.setHouseIp("12453");
        houseIpIp.setHouseId("123");
        houseIpIp.setHouseIpPrefix(1245);
        houseIpIp.setMessageSequenceNo(12L);
        houseIpMapper.insertHouseIpIp(houseIpIp);
        System.out.println("=======ok");
    }

    @Test
    @Rollback(false)
    public void testSelectServersCountBySeqIdAndDestIpAndDestPort(){
        IdcIsmsCfgFlowUploadServer idcIsmsCfgFlowUploadServer = new IdcIsmsCfgFlowUploadServer();
        idcIsmsCfgFlowUploadServer.setSeqId(11L);
        idcIsmsCfgFlowUploadServer.setDestIp("192.168.1.110");
        idcIsmsCfgFlowUploadServer.setDestPort(80);

        int result = idcIsmsCfgFlowuploadServerMapper.selectServersCountBySeqIdAndDestIpAndDestPort(idcIsmsCfgFlowUploadServer);
        System.out.println("result===="+result);
    }

    @Test
    @Rollback(false)
    public void testSaveMessageName(){
        DpiV1CfgDpiinfo dpiV1CfgDpiinfo = new DpiV1CfgDpiinfo();
        dpiV1CfgDpiinfo.setDevId(1221L);
        dpiV1CfgDpiinfo.setMessageNo(12L);
        dpiV1CfgDpiinfo.setIp("192.168.1.12");
        dpiV1CfgDpiinfo.setPort(80L);
        dpiV1CfgDpiinfo.setDevName("aha");
        dpiV1CfgDpiinfo.setDeploySiteName("haha");
        dpiV1CfgDpiinfo.setOperationType((short) 1);
        dpiV1CfgDpiinfo.setMessageSequenceNo(11L);
        dpiV1CfgDpiinfo.setMessageType(1100);
        dpiV1CfgDpiinfo.setAreaCode(65L);
        dpiV1CfgDpiinfo.setConnectFlag((short)2);
        dpiV1CfgDpiinfo.setIdcPort(8080L);
        dpiV1CfgDpiinfo.setDevFlag((short)2);
        dpiV1CfgDpiinfo.setMessageName("ddddd");
        int result = messageNameMapper.addMessageName(dpiV1CfgDpiinfo);
        System.out.println("result======" + result);
    }

    @Test
    public void testModifyMessageName(){
        BaseVo baseVo = new BaseVo();
        baseVo.setMessageNo(12L);
        baseVo.setMessageType(209);
        baseVo.setMessageName("my bate");
        int result = messageNameMapper.modifyMessageName(baseVo);
        System.out.println("====result====");
    }

    @Test
    @Rollback(false)
    public void testBind(){
        BaseVo baseVo = new BaseVo();
        baseVo.setMessageType(16);
        baseVo.setMessageNo(290929L);
        baseVo.setTopTaskId(15);
        List<HousePolicyBind> result = housePolicyBindMapper.getBindPolicy(baseVo);
        System.out.println(result.size()+"=======");
    }

    @Test
    public void testaaa(){
//        HouseIp houseIp = new HouseIp();
//        houseIp.setHouseId("123");
        HouseIp houseIp1 = houseIpMapper.selectByHouseId("123");
        System.out.println(houseIp1);
    }

    @Test
    @Rollback(false)
    public void testDeleteBind(){
        HousePolicyBind housePolicyBind = new HousePolicyBind();
        housePolicyBind.setBindId(42L);
        housePolicyBind.setHouseType(2);
        housePolicyBind.setHouseId("11");
        housePolicyBind.setBindMessageType(12L);
        housePolicyBind.setBindMessageNo(12L);
        housePolicyBind.setMessageType(12);
        housePolicyBind.setMessageNo(111L);
        housePolicyBind.setMessageSequenceNo(1212L);
        int result = housePolicyBindMapper.deleteByMessageNo(housePolicyBind);
        System.out.println(result+"=====");
    }

    @Test
    @Rollback(false)
    public void testUpdateHousePolicyBind(){
        //{bindId},{houseType},{houseId},{bindMessageType},{bindmessageNo},{messageNo},1,{messageSequenceNo})
        HousePolicyBind housePolicyBind = new HousePolicyBind();
        housePolicyBind.setBindId(41L);
        housePolicyBind.setHouseType(2);
        housePolicyBind.setHouseId("what");
        housePolicyBind.setBindMessageType(12L);
        housePolicyBind.setBindMessageNo(12L);
        housePolicyBind.setMessageNo(111L);
        housePolicyBind.setMessageType(11);
        housePolicyBind.setMessageSequenceNo(1212L);
        int result = housePolicyBindMapper.updateData(housePolicyBind);
        System.out.println(result+"=======");
    }

    @Test
    @Rollback(false)
    public void testSelectAccessLog(){
        IdcIsmsCfgAccessLog result = idcIsmsCfgAccesslogMapper.selectByAccessFlag(1);
        System.out.println(result+"=======");
    }


    @Test
    public void testSelectHousePolicyBind(){
       HousePolicyBind housePolicyBind =  housePolicyBindMapper.selectByPrimaryKey(82L);
        System.out.println("===="+housePolicyBind.getMessageNo());
    }

    @Test
    public void testSelectUserPolicyBind(){
        UserPolicyBind userPolicyBind = new UserPolicyBind();
        userPolicyBind.setBindId(300L);
        UserPolicyBind result = userPolicyBindMapper.selectByPrimaryKey(userPolicyBind);
        System.out.println(result.getBindMessageNo());
    }

    @Test
    public void testSelect() {
        DpiV1CfgDpiinfo dpiV1CfgDpiinfo = dpiV1CfgDpiinfoMapper.selectDevIdByDevIpAndOperationType("192.168.100.100");
        System.out.println(dpiV1CfgDpiinfo.getDevId()+"=======");
    }

    @Test
    public void testSelectDeviceHouse(){
        List<String> houseIds = dpiV1CfgDpiinfoHouseMapper.selectHouseIdListByDevId(1145);
        System.out.println(houseIds+"=========");
    }

    @Test
    public void testSelectFlowUpload(){
        IdcIsmsCfgFlowupload idcIsmsCfgFlowupload = new IdcIsmsCfgFlowupload();
        idcIsmsCfgFlowupload.setSeqId(781L);
        List<IdcIsmsCfgFlowUploadServer> idcIsmsCfgFlowUploadServers =
                idcIsmsCfgFlowuploadServerMapper.selectServerListBySeqId(idcIsmsCfgFlowupload.getSeqId());
        System.out.println(idcIsmsCfgFlowUploadServers.size());
    }

    @Test
    public void testSelectIsp(){
        ISPMessagePolicy ispMessagePolicy = ispMessagePolicyMapper.selectByPrimaryKey(680360);
        List<ISPMessagePolicyRule> ispMessagePolicyRules = ispMessagePolicyMapper.selectPolicyRuleListByCommandId(680360);
        System.out.println(ispMessagePolicy+""+ispMessagePolicyRules);
    }

    @Test
    public void testSelectMaxMessageNoByType(){
        List<MessageName> messageNames = messageNameMapper.selectAllTypeMaxMessageNo();
        for(int i=0;i<messageNames.size();i++){
            System.out.println(messageNames.get(i).getMessageNo()+"========"+messageNames.get(i).getMessageType());
        }
    }

    @Test
    public void testSelectEuDevice(){
        List<DpiV1CfgDpiinfo> dpiV1CfgDpiinfos = dpiV1CfgDpiinfoMapper.selectAllEuDeviceInfo();
        System.out.println(dpiV1CfgDpiinfos.size()+"=====");
    }

    @Test
    public void testSelectIdcIsmsFlowUpload(){
        List<IdcIsmsCfgFlowupload> idcIsmsCfgFlowuploads = idcIsmsCfgFlowuploadMapper.selectAllIdcIsmsCfgFlowupload();
        System.out.println(idcIsmsCfgFlowuploads.size()+"====");
    }

    @Test
    public void testSelectAllHousePolicy(){
        List<HousePolicyBind> housePolicyBinds = housePolicyBindMapper.selectAllHousePolicyBind();
        System.out.println(housePolicyBinds.size()+"========");
    }

    @Test
    public void testSelectAllHouseIp(){
        List<HouseIp> houseIps = houseIpMapper.selectAllHouseIp();
        List<HouseIpIp> houseIpIps = houseIpMapper.selectHouseIpIpByHouseId("testHouse");
        System.out.println(houseIps.size()+"=======");
    }

    @Test
    public void testSelectAllEuDeviceStatus(){
        List<EuDeviceStatus> euDeviceStatuses = euDeviceStatusMapper.selectAllEuDeviceStatus();
        System.out.println(euDeviceStatuses.size()+"===========");
    }
}
