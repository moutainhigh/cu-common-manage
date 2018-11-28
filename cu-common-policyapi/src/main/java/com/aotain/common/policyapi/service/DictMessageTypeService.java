package com.aotain.common.policyapi.service;

import com.aotain.common.policyapi.mapper.DictMessageTypeMapper;
import com.aotain.common.policyapi.model.DictMessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2018/01/02
 */
@Service
public class DictMessageTypeService {

    @Autowired
    private DictMessageTypeMapper dictMessageTypeMapper;

    public List<DictMessageType> selectMaxMessageSeqNoByMessage(){
        return dictMessageTypeMapper.selectMaxMessageSeqNoByMessage();
    }
}
