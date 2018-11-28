package com.aotain.common.policyapi;

import com.aotain.common.policyapi.base.BaseVo;
import com.aotain.common.policyapi.mapper.HouseIpMapper;
import com.aotain.common.policyapi.model.DpiV1CfgDpiinfo;
import com.aotain.common.policyapi.model.HouseIpIp;
import com.aotain.common.policyapi.service.EuDevicePolicyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.Arrays;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/11/17
 */
public class EuDevicePolicyServiceTest extends BaseTest{

    @Autowired
    private HouseIpMapper houseIpMapper;

    @Autowired
    private EuDevicePolicyService euDevicePolicyService;

    @Test
    @Rollback(false)
    public void testSave(){
        HouseIpIp houseIpIp = new HouseIpIp();
//        houseIpIp.setMessageSequenceNo(111L);
        houseIpIp.setHouseId("abcd");
        houseIpIp.setHouseIp("192.168.1.123");
        houseIpIp.setHouseIpPrefix(86);
        houseIpIp.setMessageSequenceNo(12345L);
        houseIpMapper.insertHouseIpIp(houseIpIp);
        System.out.println(houseIpMapper+"==========");
    }

    @Test
    @Rollback(false)
    public void testAddDb(){
        DpiV1CfgDpiinfo dpiV1CfgDpiinfo = new DpiV1CfgDpiinfo();
        dpiV1CfgDpiinfo.setDevName("EU_DEVICE_01_25");
        dpiV1CfgDpiinfo.setDeploySiteName("www.aotain.com");
        dpiV1CfgDpiinfo.setIp("192.168.1.155");
        dpiV1CfgDpiinfo.setPort(60000L);
        dpiV1CfgDpiinfo.setIdcHouseIds(Arrays.asList(new String[]{"192.168.1.110","192.168.1.111"}));
        euDevicePolicyService.addPolicy(dpiV1CfgDpiinfo);
    }

    @Test
    @Rollback(false)
    public void testModifyDb(){
        DpiV1CfgDpiinfo dpiV1CfgDpiinfo = new DpiV1CfgDpiinfo();
        dpiV1CfgDpiinfo.setDevName("EU_DEVICE_01_25_UIPDATE");
        dpiV1CfgDpiinfo.setDeploySiteName("www.aotain.com.cn");
        dpiV1CfgDpiinfo.setDevId(26L);
        dpiV1CfgDpiinfo.setIdcHouseIds(Arrays.asList(new String[]{"192.168.1.112","192.168.1.113"}));
        boolean result = euDevicePolicyService.modifyPolicy(dpiV1CfgDpiinfo);
        System.out.println(result+"--------");
    }

    @Test
    public void testDelete(){
        DpiV1CfgDpiinfo dpiV1CfgDpiinfo = new DpiV1CfgDpiinfo();
        dpiV1CfgDpiinfo.setDevId(23L);
        dpiV1CfgDpiinfo.setIp("192.168.1.155");
        boolean result = euDevicePolicyService.deletePolicy(dpiV1CfgDpiinfo);
        System.out.println(result+"--------");
    }
}
