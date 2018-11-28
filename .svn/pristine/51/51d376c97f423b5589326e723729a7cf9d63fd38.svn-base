package com.aotain.common.policyapi;

import com.aotain.common.policyapi.model.IdcIsmsCfgAccessLog;
import com.aotain.common.policyapi.service.AccessLogPolicyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.List;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/11/28
 */
public class AccessLogServiceTest extends BaseTest{

    @Autowired
    private AccessLogPolicyService accessLogPolicyService;

    @Test
    @Rollback(false)
    public void testAdd() {
        IdcIsmsCfgAccessLog idcIsmsCfgAccessLog = new IdcIsmsCfgAccessLog();
        idcIsmsCfgAccessLog.setAccessLogFlag((short)1);
        boolean result = accessLogPolicyService.addPolicy(idcIsmsCfgAccessLog);
        System.out.println("result==="+result);
    }

    @Test
    public void testUpdate() {
        IdcIsmsCfgAccessLog idcIsmsCfgAccessLog = new IdcIsmsCfgAccessLog();
        idcIsmsCfgAccessLog.setAccessLogFlag((short)1);
//        idcIsmsCfgAccessLog.setMessageNo(2L);
        boolean result = accessLogPolicyService.modifyPolicy(idcIsmsCfgAccessLog);
        System.out.println("result==="+result);
    }

    @Test
    public void testDelete(){
        IdcIsmsCfgAccessLog idcIsmsCfgAccessLog = new IdcIsmsCfgAccessLog();
        idcIsmsCfgAccessLog.setAccessLogFlag((short)1);
//        idcIsmsCfgAccessLog.setMessageNo(2L);
        boolean result = accessLogPolicyService.deletePolicy(idcIsmsCfgAccessLog);
        System.out.println("result==="+result);
    }

    @Test
    public void testSelect(){
        List<IdcIsmsCfgAccessLog> idcIsmsCfgAccessLogList = accessLogPolicyService.selectAllAccessFlag();
        System.out.println(idcIsmsCfgAccessLogList.size()+"=========");
    }

}
