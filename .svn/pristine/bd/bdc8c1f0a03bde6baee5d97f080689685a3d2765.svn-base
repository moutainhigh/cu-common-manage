package com.aotain.common.policyapi;

import com.aotain.common.policyapi.model.ISPMessagePolicy;
import com.aotain.common.policyapi.model.ISPMessagePolicyRule;
import com.aotain.common.policyapi.service.ISPMessagePolicyService;
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
public class ISPMessagePolicyServiceTest extends BaseTest{

    @Autowired
    private ISPMessagePolicyService ispMessagePolicyService;

    @Test
    public void testAdd() {
        ISPMessagePolicy ispMessagePolicy = new ISPMessagePolicy();
        ispMessagePolicy.setSmmsCommandId(1111111L);
        ispMessagePolicy.setType(1);
        ispMessagePolicy.setBlockFlag(1);
        ispMessagePolicy.setLogFlag(1);
        ispMessagePolicy.setLevel(11L);
        ispMessagePolicy.setUserId(11L);
        ispMessagePolicy.setTopTaskId(12L);
        ispMessagePolicy.setGroupId(110L);
        ispMessagePolicy.setRuleGroupId(111L);

        List<ISPMessagePolicyRule> ispMessagePolicyRuleList = Lists.newArrayList();

        ISPMessagePolicyRule ispMessagePolicyRule = new ISPMessagePolicyRule();
        ispMessagePolicyRule.setSubType(1);
        ispMessagePolicyRule.setRuleId(1L);
        ispMessagePolicyRuleList.add(ispMessagePolicyRule);

        ISPMessagePolicyRule ispMessagePolicyRule2 = new ISPMessagePolicyRule();
        ispMessagePolicyRule2.setSubType(1);
        ispMessagePolicyRule2.setRuleId(1L);
        ispMessagePolicyRuleList.add(ispMessagePolicyRule2);

        ispMessagePolicy.setRules(ispMessagePolicyRuleList);
        ispMessagePolicyService.addPolicy(ispMessagePolicy);
    }

    @Test
    public void testModify() {
        ISPMessagePolicy ispMessagePolicy = new ISPMessagePolicy();
        ispMessagePolicy.setCommandId(680455L);
        ispMessagePolicy.setSmmsCommandId(22222L);
        ispMessagePolicy.setType(2);
        ispMessagePolicy.setBlockFlag(2);
        ispMessagePolicy.setLogFlag(2);
//        ispMessagePolicy.setLevel(22L);
        ispMessagePolicy.setUserId(22L);
        ispMessagePolicy.setMessageNo(91L);
        ispMessagePolicy.setGroupId(112L);
        ispMessagePolicy.setRuleGroupId(113L);

        List<ISPMessagePolicyRule> ispMessagePolicyRuleList = Lists.newArrayList();

        ISPMessagePolicyRule ispMessagePolicyRule = new ISPMessagePolicyRule();
        ispMessagePolicyRule.setSubType(2);
        ispMessagePolicyRule.setRuleId(2L);
        ispMessagePolicyRuleList.add(ispMessagePolicyRule);

        ISPMessagePolicyRule ispMessagePolicyRule2 = new ISPMessagePolicyRule();
        ispMessagePolicyRule2.setSubType(2);
        ispMessagePolicyRule2.setRuleId(2L);
        ispMessagePolicyRuleList.add(ispMessagePolicyRule2);

        ispMessagePolicy.setRules(ispMessagePolicyRuleList);
        ispMessagePolicyService.modifyPolicy(ispMessagePolicy);
    }

    @Test
    public void testDelete() {
        ISPMessagePolicy ispMessagePolicy = new ISPMessagePolicy();
        ispMessagePolicy.setCommandId(430529L);
        ispMessagePolicy.setMessageNo(82L);
        ispMessagePolicy.setTopTaskId(1111L);
        ispMessagePolicy.setType(1);
        ispMessagePolicyService.deletePolicy(ispMessagePolicy);
    }
}
