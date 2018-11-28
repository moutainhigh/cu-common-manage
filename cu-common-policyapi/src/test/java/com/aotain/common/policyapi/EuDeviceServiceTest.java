package com.aotain.common.policyapi;

import com.aotain.common.policyapi.model.EuDeviceStatus;
import com.aotain.common.policyapi.service.EuStatusPolicyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/11/30
 */
public class EuDeviceServiceTest extends BaseTest{

    @Autowired
    private EuStatusPolicyService euStatusPolicyService;

    @Test
    public void test(){
        EuDeviceStatus euDeviceStatus = new EuDeviceStatus();
        euDeviceStatus.setRType(1);
        euDeviceStatus.setRFreq(3);
        boolean result = euStatusPolicyService.addPolicy(euDeviceStatus);
        System.out.println("result===="+result);
    }

    @Test
    public void testDb(){
        EuDeviceStatus euDeviceStatus = new EuDeviceStatus();
        euDeviceStatus.setRType(2);
        euDeviceStatus.setRFreq(10);
        boolean result = euStatusPolicyService.addPolicy(euDeviceStatus);
        System.out.println("result===="+result);
    }
}
