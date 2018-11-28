package com.aotain.common.policyapi;

import com.aotain.common.policyapi.base.BaseVo;
import com.aotain.common.policyapi.service.MessageNameService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/11/21
 */
public class MessageNameServiceTest extends BaseTest{

    @Autowired
    private MessageNameService messageNameService;

    @Test
    @Rollback(false)
    public void testSave(){
        BaseVo baseVo = new BaseVo();
        baseVo.setMessageNo(1L);
        baseVo.setMessageName("bang");
        baseVo.setMessageType(1);
        baseVo.setOperationType(1);
        int result = messageNameService.addMessageName(baseVo);
        System.out.println("result=="+result);
    }

    @Test
    @Rollback(false)
    public void testSave2(){
        BaseVo baseVo = new BaseVo();
        baseVo.setMessageNo(1L);
        baseVo.setMessageName("bang");
        baseVo.setMessageType(10);
        baseVo.setOperationType(1);
        int result = messageNameService.addMessageName(baseVo);
        System.out.println("result=="+result);
    }

    @Test
    @Rollback(false)
    public void testUpdate(){
        BaseVo baseVo = new BaseVo();
        baseVo.setMessageNo(1L);
        baseVo.setMessageName("abcd");
        baseVo.setMessageType(10);
        baseVo.setOperationType(1);
        int result = messageNameService.modifyMessageName(baseVo);
        System.out.println("result=="+result);
    }
}
