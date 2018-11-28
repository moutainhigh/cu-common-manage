package com.aotain.common.policyapi;

import com.aotain.common.policyapi.model.DictMessageType;
import com.aotain.common.policyapi.service.DictMessageTypeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2018/01/02
 */
public class DictMessageTypeServiceTest extends BaseTest{

    @Autowired
    private DictMessageTypeService dictMessageTypeService;

    @Test
    public void selectMessageSeqNo(){
        List<DictMessageType> dictMessageTypeList = dictMessageTypeService.selectMaxMessageSeqNoByMessage();

        for(DictMessageType dictMessageType:dictMessageTypeList){
            System.out.println(dictMessageType.getMessageType()+"====="+dictMessageType.getMessageSequenceNo());
        }

    }

}
