package com.aotain.common.policyapi;

import com.aotain.common.policyapi.model.BindMessage;
import com.aotain.common.policyapi.model.HousePolicyBind;
import com.aotain.common.policyapi.service.HousePolicyBindService;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/11/29
 */
public class HousePolicyBindServiceTest extends BaseTest{

    @Autowired
    private HousePolicyBindService housePolicyBindService;

    @Test
    public void testAdd(){
        HousePolicyBind housePolicyBind = new HousePolicyBind();
        housePolicyBind.setHouseType(0);
        housePolicyBind.setHouseId("HP-TE-11-29");
        housePolicyBind.setMessageName("HousePolicyBind-11-29");
        List<BindMessage> bindInfo = Lists.newArrayList();
        BindMessage bindMessage = new BindMessage();
        bindMessage.setBindMessageNo(67L);
        bindMessage.setBindMessageType(130L);
        bindInfo.add(bindMessage);
        BindMessage bindMessage2 = new BindMessage();
        bindMessage2.setBindMessageNo(63L);
        bindMessage2.setBindMessageType(209L);
        bindInfo.add(bindMessage2);
        housePolicyBind.setBindInfo(bindInfo);
        housePolicyBindService.addPolicy(housePolicyBind);
    }


    @Test
    public void testDelete(){
        HousePolicyBind housePolicyBind = new HousePolicyBind();
        housePolicyBind.setBindId(83L);
//        housePolicyBind.setMessageNo(76L);
        housePolicyBindService.deletePolicy(housePolicyBind);
    }
}
