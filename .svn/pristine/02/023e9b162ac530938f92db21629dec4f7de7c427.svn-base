package com.aotain.common.policyapi;

import com.aotain.common.policyapi.model.BindMessage;
import com.aotain.common.policyapi.model.UserPolicyBind;
import com.aotain.common.policyapi.service.UserPolicyBindService;
import com.google.common.collect.Lists;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/12/20
 */
public class UserPolicyBindServiceTest extends BaseTest{

    @Resource(name="userPolicyBindServices")
    private UserPolicyBindService userPolicyBindService;

    @Test
    public void testSave() {
        UserPolicyBind userPolicyBind = new UserPolicyBind();
        userPolicyBind.setParentBindId(111L);
        userPolicyBind.setUserType(1);
        userPolicyBind.setUserName("bang");
        List<BindMessage> lists = Lists.newArrayList();
        BindMessage bindMessage = new BindMessage();
        bindMessage.setBindMessageNo(155L);
        bindMessage.setBindMessageType(1L);
        lists.add(bindMessage);
        userPolicyBind.setBindInfo(lists);
        userPolicyBindService.addPolicy(userPolicyBind);
    }

    @Test
    public void testModify() {
        UserPolicyBind userPolicyBind = new UserPolicyBind();
        userPolicyBind.setBindId(387L);
        userPolicyBind.setParentBindId(111L);
        userPolicyBind.setUserType(1);
        userPolicyBind.setUserName("bang");
        List<BindMessage> lists = Lists.newArrayList();
        BindMessage bindMessage = new BindMessage();
        bindMessage.setBindMessageNo(155L);
        bindMessage.setBindMessageType(1L);
        lists.add(bindMessage);
        userPolicyBind.setBindInfo(lists);
        userPolicyBindService.modifyPolicy(userPolicyBind);
    }

    @Test
    public void testDelete(){
        UserPolicyBind userPolicyBind = new UserPolicyBind();
        userPolicyBind.setBindId(387L);
        userPolicyBindService.deletePolicy(userPolicyBind);
    }

}
