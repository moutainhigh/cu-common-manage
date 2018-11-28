package com.aotain.common.policyapi;

import com.aotain.common.policyapi.model.IdcIsmsCfgFlowUploadServer;
import com.aotain.common.policyapi.model.IdcIsmsCfgFlowupload;
import com.aotain.common.policyapi.service.FlowUploadPolicyService;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/11/20
 */
public class FlowUploadPolicyServiceTest extends BaseTest{

    @Autowired
    private FlowUploadPolicyService flowUploadPolicyService;

    @Test
    public void testAddDb(){
        IdcIsmsCfgFlowupload idcIsmsCfgFlowupload = new IdcIsmsCfgFlowupload();
        idcIsmsCfgFlowupload.setPacketType(1);
        idcIsmsCfgFlowupload.setPacketSubtype(1);
        idcIsmsCfgFlowupload.setMethod(2);
        List<IdcIsmsCfgFlowUploadServer> list = Lists.newArrayList();
        IdcIsmsCfgFlowUploadServer idcIsmsCfgFlowUploadServer = new IdcIsmsCfgFlowUploadServer();
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

        boolean result = flowUploadPolicyService.addPolicy(idcIsmsCfgFlowupload);
        System.out.println("======="+result);
    }


    @Test
    public void testUpdateDb(){
        IdcIsmsCfgFlowupload idcIsmsCfgFlowupload = new IdcIsmsCfgFlowupload();
        idcIsmsCfgFlowupload.setSeqId(786L);
        idcIsmsCfgFlowupload.setPacketType(10);
        idcIsmsCfgFlowupload.setPacketSubtype(10);
        idcIsmsCfgFlowupload.setMethod(20);
        List<IdcIsmsCfgFlowUploadServer> list = Lists.newArrayList();
        IdcIsmsCfgFlowUploadServer idcIsmsCfgFlowUploadServer = new IdcIsmsCfgFlowUploadServer();
        idcIsmsCfgFlowUploadServer.setDestIp("192.168.110.110");
        idcIsmsCfgFlowUploadServer.setDestPort(80);
        idcIsmsCfgFlowUploadServer.setUserName("update_bang");
        idcIsmsCfgFlowUploadServer.setPassWord("update_abc");
        list.add(idcIsmsCfgFlowUploadServer);
        IdcIsmsCfgFlowUploadServer idcIsmsCfgFlowUploadServer2 = new IdcIsmsCfgFlowUploadServer();
//        idcIsmsCfgFlowUploadServer2.setSeqId(11L);
        idcIsmsCfgFlowUploadServer2.setDestIp("192.168.110.112");
        idcIsmsCfgFlowUploadServer2.setDestPort(82);
        idcIsmsCfgFlowUploadServer2.setUserName("update_dai");
        idcIsmsCfgFlowUploadServer2.setPassWord("aaaaa");
        list.add(idcIsmsCfgFlowUploadServer2);
        idcIsmsCfgFlowupload.setIdcIsmsCfgFlowUploadServerList(list);

        boolean result = flowUploadPolicyService.modifyPolicy(idcIsmsCfgFlowupload);
        System.out.println("======="+result);
    }

    @Test
    public void testDeleteDb(){
        IdcIsmsCfgFlowupload idcIsmsCfgFlowupload = new IdcIsmsCfgFlowupload();
        idcIsmsCfgFlowupload.setSeqId(786L);
        boolean result = flowUploadPolicyService.deletePolicy(idcIsmsCfgFlowupload);
        System.out.println("======="+result);
    }

}
