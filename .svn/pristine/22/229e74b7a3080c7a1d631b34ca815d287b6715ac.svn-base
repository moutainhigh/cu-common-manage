package com.aotain.common.policyapi;

import com.aotain.common.policyapi.model.HouseIp;
import com.aotain.common.policyapi.model.HouseIpIp;
import com.aotain.common.policyapi.service.HouseIpPolicyService;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/11/23
 */
public class HouseIpPolicyServiceTest extends BaseTest{

    @Autowired
    private HouseIpPolicyService houseIpPolicyService;

    @Test
    public void testAdd(){
        HouseIp houseIp = new HouseIp();
        houseIp.setHouseId("AB-BM-21-AF");
        List<HouseIpIp> ipSegments = Lists.newArrayList();
        HouseIpIp houseIpIp = new HouseIpIp();
        houseIpIp.setHouseId("AB-BM-21-AF");
        houseIpIp.setHouseIp("192.168.110.1");
        houseIpIp.setHouseIpPrefix(12);
        ipSegments.add(houseIpIp);
        HouseIpIp houseIpIp2 = new HouseIpIp();
        houseIpIp2.setHouseId("AB-BM-21-AF");
        houseIpIp2.setHouseIp("192.168.110.10");
        houseIpIp2.setHouseIpPrefix(13);
        ipSegments.add(houseIpIp2);
        houseIp.setIPSegments(ipSegments);
        houseIpPolicyService.addPolicy(houseIp);
    }


    @Test
    public void testModify(){
        HouseIp houseIp = new HouseIp();
        houseIp.setHouseId("AB-BM-21-AF");
        List<HouseIpIp> ipSegments = Lists.newArrayList();
        HouseIpIp houseIpIp = new HouseIpIp();
        houseIpIp.setHouseId("AB-BM-21-AF");
        houseIpIp.setHouseIp("192.168.110.112");
        houseIpIp.setHouseIpPrefix(12);

        ipSegments.add(houseIpIp);
        HouseIpIp houseIpIp2 = new HouseIpIp();
        houseIpIp2.setHouseId("AB-BM-21-AF");
        houseIpIp2.setHouseIp("192.168.110.110");
        houseIpIp2.setHouseIpPrefix(13);

        ipSegments.add(houseIpIp2);
        houseIp.setIPSegments(ipSegments);
        houseIpPolicyService.addPolicy(houseIp);
    }

    @Test
    public void testDelte(){
        HouseIp houseIp = new HouseIp();
        houseIp.setHouseId("AB-BM-21-AF");
        List<HouseIpIp> ipSegments = Lists.newArrayList();
        HouseIpIp houseIpIp = new HouseIpIp();
//        houseIpIp.setHouseId("AB-BM-21-AF");
//        houseIpIp.setHouseIp("192.168.110.112");
//        houseIpIp.setHouseIpPrefix(12);
//        houseIpIp.setSeqId(350L);
        ipSegments.add(houseIpIp);
        HouseIpIp houseIpIp2 = new HouseIpIp();
//        houseIpIp2.setHouseId("AB-BM-21-AF");
//        houseIpIp2.setHouseIp("192.168.110.110");
//        houseIpIp2.setHouseIpPrefix(13);
//        houseIpIp2.setSeqId(351L);
        ipSegments.add(houseIpIp2);
        houseIp.setIPSegments(ipSegments);
        houseIpPolicyService.deletePolicy(houseIp);
    }
}
