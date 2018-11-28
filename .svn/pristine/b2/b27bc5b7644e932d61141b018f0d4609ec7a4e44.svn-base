package com.aotain.common.policyapi;

import com.aotain.common.policyapi.mapper.EuDeviceStatusMapper;
import com.aotain.common.policyapi.model.EuDeviceStatus;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/11/30
 */
public class EuDeviceMapperTest extends BaseTest{

    @Autowired
    private EuDeviceStatusMapper euDeviceStatusMapper;

    @Test
    public void test(){
        EuDeviceStatus euDeviceStatus = new EuDeviceStatus();
        euDeviceStatus.setRType(1);
        euDeviceStatus.setRFreq(3);
        euDeviceStatus.setMessageNo(110L);
        euDeviceStatus.setMessageSequenceNo(111L);
        int result = euDeviceStatusMapper.insertData(euDeviceStatus);
        System.out.println("result ===" +result);
    }

    @Test
    public void testSelect(){
        EuDeviceStatus euDeviceStatus = euDeviceStatusMapper.selectByRType(1);
        System.out.println(euDeviceStatus.getMessageNo()+"====");
    }
}
