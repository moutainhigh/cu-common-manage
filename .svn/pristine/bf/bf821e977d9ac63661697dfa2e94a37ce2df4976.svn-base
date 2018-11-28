package com.aotain.common.policyapi;

import com.aotain.common.policyapi.mapper.DPIFlowUploadMapper;
import com.aotain.common.policyapi.model.DPIFlowUpload;
import com.aotain.common.policyapi.service.DPIFlowUploadService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/12/19
 */
public class DPIFlowUploadServiceTest extends BaseTest{

    @Autowired
    private DPIFlowUploadService dpiFlowUploadService;

    @Test
    public void testSave(){
        DPIFlowUpload dpiFlowUpload = new DPIFlowUpload();
        dpiFlowUpload.setPacketType(1);
        dpiFlowUpload.setPacketSubType(1);
        dpiFlowUpload.setRStartTime(152453465L);
        dpiFlowUpload.setREndTime(152453465L);
        dpiFlowUpload.setRFreqence(2);
        dpiFlowUpload.setRDestIp("192.168.0.1");
        dpiFlowUpload.setRDestPort(50001);
        dpiFlowUpload.setRMethod(2);
        dpiFlowUploadService.addPolicy(dpiFlowUpload);
    }

    @Test
    public void testUpdate(){
        DPIFlowUpload dpiFlowUpload = new DPIFlowUpload();
        dpiFlowUpload.setSeqId(851L);
//        dpiFlowUpload.setPacketType(1);
//        dpiFlowUpload.setPacketSubType(2);
//        dpiFlowUpload.setRStartTime(2L);
//        dpiFlowUpload.setREndTime(2L);
//        dpiFlowUpload.setRFreqence(2);
//        dpiFlowUpload.setRDestIp("192.168.0.1");
//        dpiFlowUpload.setRDestPort(50002);
//        dpiFlowUpload.setRMethod(2);
        dpiFlowUploadService.deletePolicy(dpiFlowUpload);
    }
}
