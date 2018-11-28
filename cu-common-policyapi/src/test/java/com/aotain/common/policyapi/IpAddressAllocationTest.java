package com.aotain.common.policyapi;

import com.aotain.common.policyapi.mapper.IpAddressAllocationMapper;
import com.aotain.common.policyapi.model.IpAddressAllocation;
import com.aotain.common.policyapi.service.IpAddressAllocationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/12/25
 */
public class IpAddressAllocationTest extends BaseTest{

    @Autowired
    private IpAddressAllocationMapper ipAddressAllocationMapper;

    @Autowired
    private IpAddressAllocationService ipAddressAllocationService;

    @Test
    public void testAdd(){
        IpAddressAllocation ipAddressAllocation = new IpAddressAllocation();
        ipAddressAllocation.setDataId(3);
        ipAddressAllocation.setDataType((short)3);
        ipAddressAllocation.setServerIp("192.168.1.10");
        ipAddressAllocation.setServerPort(8088);
        ipAddressAllocation.setFileName("niamm.xsd");
        ipAddressAllocation.setUserName("admin");
        ipAddressAllocation.setPassword("123456");

        ipAddressAllocation.setMessageNo(100L);
        ipAddressAllocation.setMessageSequenceNo(100L);
        ipAddressAllocationMapper.insertData(ipAddressAllocation);

    }

    @Test
    public void testUpdate(){
        IpAddressAllocation ipAddressAllocation = new IpAddressAllocation();
        ipAddressAllocation.setDataId(3);
        ipAddressAllocation.setDataType((short)3);
        ipAddressAllocation.setServerIp("192.168.1.10");
        ipAddressAllocation.setServerPort(8088);
        ipAddressAllocation.setFileName("update_niamm.xsd");
        ipAddressAllocation.setUserName("update_admin");
        ipAddressAllocation.setPassword("update_123456");

        ipAddressAllocation.setMessageNo(101L);
        ipAddressAllocation.setMessageSequenceNo(101L);
        ipAddressAllocationMapper.updateData(ipAddressAllocation);

    }

    @Test
    public void testDelete(){
        IpAddressAllocation ipAddressAllocation = new IpAddressAllocation();
        ipAddressAllocation.setDataId(3);
        ipAddressAllocation.setDataType((short)3);

        ipAddressAllocation.setMessageNo(101L);
        ipAddressAllocation.setOperationType(3);
        ipAddressAllocation.setMessageSequenceNo(103L);
        ipAddressAllocationMapper.deleteData(ipAddressAllocation);

    }

    @Test
    public void testAddPolicy(){
        IpAddressAllocation ipAddressAllocation = new IpAddressAllocation();
        ipAddressAllocation.setDataId(3);
        ipAddressAllocation.setDataType((short)3);
        ipAddressAllocation.setServerIp("192.168.1.10");
        ipAddressAllocation.setServerPort(8088);
        ipAddressAllocation.setFileName("niamm.xsd");
        ipAddressAllocation.setUserName("admin");
        ipAddressAllocation.setPassword("123456");


        ipAddressAllocationService.addPolicy(ipAddressAllocation);
    }
}
