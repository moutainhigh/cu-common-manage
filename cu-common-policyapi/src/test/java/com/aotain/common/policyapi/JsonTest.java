package com.aotain.common.policyapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.aotain.common.policyapi.model.*;
import com.aotain.common.utils.model.msg.StrategySendChannel;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/11/21
 */
public class JsonTest{

    @Test
    public void test(){
        ISPMessagePolicy ispMessagePolicy = new ISPMessagePolicy();
        ispMessagePolicy.setCommandId(12L);
        ispMessagePolicy.setMessageNo(1L);
        ispMessagePolicy.setType(1);
        ispMessagePolicy.setBlockFlag(1);
        ispMessagePolicy.setLogFlag(1);
        ispMessagePolicy.setEffectTime(1L);
        ispMessagePolicy.setExpiredTime(2L);
        ispMessagePolicy.setMessageSequenceNo(1L);
        ispMessagePolicy.setUserId(1L);
        ispMessagePolicy.setUserName("bang");
        ispMessagePolicy.setLevel(12L);
        ispMessagePolicy.setPolicyState(1);

        List<ISPMessagePolicyRule> list = Lists.newArrayList();
        ISPMessagePolicyRule ispMessagePolicyRule = new ISPMessagePolicyRule();
        ispMessagePolicyRule.setCommandId(11L);
        ispMessagePolicyRule.setRuleId(11L);
        ispMessagePolicyRule.setKeywordRange("abc");
        ispMessagePolicyRule.setSubType(1);
        ispMessagePolicyRule.setValueStart("111");
        ispMessagePolicyRule.setValueEnd("222");
        list.add(ispMessagePolicyRule);
        ISPMessagePolicyRule ispMessagePolicyRule2 = new ISPMessagePolicyRule();
        ispMessagePolicyRule2.setCommandId(11L);
        ispMessagePolicyRule2.setRuleId(11L);
        ispMessagePolicyRule2.setKeywordRange("abc");
        ispMessagePolicyRule2.setSubType(1);
        ispMessagePolicyRule2.setValueStart("111");
        ispMessagePolicyRule2.setValueEnd("222");
        list.add(ispMessagePolicyRule2);
        ispMessagePolicy.setRules(list);
        String result = JSON.toJSONString(ispMessagePolicy);
        System.out.println(result);
    }

    @Test
    public void testEUPolicy(){
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
        StrategySendChannel strategySendChannel = new StrategySendChannel();
        strategySendChannel.setMessageContent(JSON.toJSONString(dpiV1CfgDpiinfo));
        strategySendChannel.setProbeType(1);
        String result = JSON.toJSONString(strategySendChannel);
        System.out.println(result);
    }

    @Test
    public void testFlowUpload(){
        IdcIsmsCfgFlowupload idcIsmsCfgFlowupload = new IdcIsmsCfgFlowupload();
        idcIsmsCfgFlowupload.setSeqId(11L);
        idcIsmsCfgFlowupload.setMessageNo(1L);
        idcIsmsCfgFlowupload.setMessageSequenceNo(1L);
        idcIsmsCfgFlowupload.setCreateTime(new Date());
        idcIsmsCfgFlowupload.setMethod(1);
        idcIsmsCfgFlowupload.setOperationType(1);
        idcIsmsCfgFlowupload.setPacketType(1);
        idcIsmsCfgFlowupload.setPacketSubtype(1);

        List<IdcIsmsCfgFlowUploadServer> list = Lists.newArrayList();
        IdcIsmsCfgFlowUploadServer idcIsmsCfgFlowUploadServer = new IdcIsmsCfgFlowUploadServer();
        idcIsmsCfgFlowUploadServer.setSeqId(11L);
        idcIsmsCfgFlowUploadServer.setDestIp("192.168.1.110");
        idcIsmsCfgFlowUploadServer.setDestPort(80);
        idcIsmsCfgFlowUploadServer.setUserName("bang");
        idcIsmsCfgFlowUploadServer.setPassWord("abc");
        list.add(idcIsmsCfgFlowUploadServer);
        IdcIsmsCfgFlowUploadServer idcIsmsCfgFlowUploadServer2 = new IdcIsmsCfgFlowUploadServer();
        idcIsmsCfgFlowUploadServer2.setSeqId(11L);
        idcIsmsCfgFlowUploadServer2.setDestIp("192.168.1.112");
        idcIsmsCfgFlowUploadServer2.setDestPort(82);
        idcIsmsCfgFlowUploadServer2.setUserName("dai");
        idcIsmsCfgFlowUploadServer2.setPassWord("aaaaa");
        list.add(idcIsmsCfgFlowUploadServer2);
        idcIsmsCfgFlowupload.setIdcIsmsCfgFlowUploadServerList(list);
        String result = JSON.toJSONString(idcIsmsCfgFlowupload);
        System.out.println(result);
    }

    @Test
    public void testHouseBind(){
        HousePolicyBind housePolicyBind = new HousePolicyBind();
        housePolicyBind.setBindId(111L);
        housePolicyBind.setHouseType(1);
        housePolicyBind.setHouseId("11");
        housePolicyBind.setBindMessageType(12L);
        housePolicyBind.setBindMessageNo(12L);
        housePolicyBind.setMessageNo(111L);
        housePolicyBind.setMessageSequenceNo(1212L);
        List<BindMessage> list = Lists.newArrayList();
        BindMessage bindMessage = new BindMessage();
        bindMessage.setBindMessageNo(11L);
        bindMessage.setBindMessageType(12L);
//        map.put("bindMessageType",);
//        map.put("bindMessageNo",11L);
        list.add(bindMessage);
        BindMessage bindMessage2 = new BindMessage();
        bindMessage2.setBindMessageNo(13L);
        bindMessage2.setBindMessageType(14L);
        list.add(bindMessage2);
        housePolicyBind.setBindInfo(list);
        String result = JSON.toJSONString(housePolicyBind);
        System.out.println(result);
    }

    @Test
    public void testJson(){
        String s = "{\"bindAction\":2,\"houseId\":\"GD_ATKJ_IDC\",\"iPSegments\":[{\"houseIp\":\"192.168.10.1\"," +
                "\"houseIpPrefix\":5}],\"messageNo\":4,\"messageSequenceNo\":68,\"messageType\":130,\"operationType\":3," +
                "\"probeType\":1}";

        Map<String,Object> maps =  JSON.parseObject(s,new TypeReference<Map<String, Object>>(){});
        int obj = (Integer) maps.get("operationType");
        maps.put("operationType",1);
        System.out.println("======="+JSON.toJSONString(maps)+"====="+obj);

    }
}
