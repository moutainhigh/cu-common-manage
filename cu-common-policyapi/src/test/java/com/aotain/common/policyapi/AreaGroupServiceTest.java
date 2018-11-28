package com.aotain.common.policyapi;

import com.aotain.common.policyapi.mapper.AreaGroupAsMapper;
import com.aotain.common.policyapi.mapper.AreaGroupMapper;
import com.aotain.common.policyapi.model.AreaGroup;
import com.aotain.common.policyapi.model.AreaGroupAs;
import com.aotain.common.policyapi.model.AreaGroupDTO;
import com.aotain.common.policyapi.service.AreaGroupService;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/12/21
 */
public class AreaGroupServiceTest extends BaseTest{

    @Autowired
    private AreaGroupService areaGroupService;

    @Autowired
    private AreaGroupMapper areaGroupMapper;

    @Autowired
    private AreaGroupAsMapper areaGroupAsMapper;

    @Test
    public void testAdd(){
        AreaGroupAs areaGroupAs = new AreaGroupAs();
        areaGroupAs.setAreaGroupId(111L);
        areaGroupAs.setAsAreaId(111L);
        areaGroupAs.setAsAreaName("bang");
        areaGroupAs.setAsType(1);
        areaGroupAsMapper.insertData(areaGroupAs);
        System.out.println("==========ok========");
    }

    @Test
    public void testDelete(){
        areaGroupAsMapper.deleteDataByAreaGroupId(111L);
        System.out.println("==========ok========");
    }

    @Test
    public void testAddGroup(){
        AreaGroupDTO areaGroupDTO = new AreaGroupDTO();
        List<AreaGroup> areaGroupList = Lists.newArrayList();
        AreaGroup areaGroup = new AreaGroup();
        areaGroup.setSeqOperType(1);
        areaGroup.setAreaType(0);
        areaGroup.setCreateTime(new Date());
        areaGroup.setMessageName("test");
        areaGroup.setAreaId(3L);
        areaGroup.setAreaGroupName("bang");

        List<AreaGroupAs> areaGroupAsList = Lists.newArrayList();
        AreaGroupAs areaGroupAs1 = new AreaGroupAs();
        areaGroupAs1.setAsType(0);
        areaGroupAs1.setAreaSubId(123L);
        areaGroupAs1.setAsAreaId(101L);
        areaGroupAs1.setAsAreaName("areaGroupAs1");
        areaGroupAsList.add(areaGroupAs1);

        AreaGroupAs areaGroupAs2 = new AreaGroupAs();
        areaGroupAs2.setAsType(0);
        areaGroupAs2.setAreaSubId(124L);
        areaGroupAs2.setAsAreaId(10100L);
        areaGroupAs2.setAsAreaName("areaGroupAs2");
        areaGroupAsList.add(areaGroupAs2);

        areaGroup.setAreaGroupAsList(areaGroupAsList);

        areaGroupList.add(areaGroup);

        areaGroupDTO.setInternalAreaGroupInfo(areaGroupList);


        List<AreaGroup> areaGroupList2 = Lists.newArrayList();
        AreaGroup areaGroup2 = new AreaGroup();
        areaGroup2.setSeqOperType(1);
        areaGroup2.setAreaType(1);
        areaGroup2.setCreateTime(new Date());
        areaGroup2.setMessageName("testext");
        areaGroup2.setAreaId(3L);
        areaGroup2.setAreaGroupName("bangext");

        List<AreaGroupAs> exterGroupAsList = Lists.newArrayList();

        AreaGroupAs areaGroupAs3 = new AreaGroupAs();

        areaGroupAs3.setAsType(1);
        areaGroupAs3.setAreaSubId(123L);
        areaGroupAs3.setAsAreaId(1110L);
        areaGroupAs3.setAsAreaName("extareaGroupAs1");

        exterGroupAsList.add(areaGroupAs3);

        areaGroup2.setAreaGroupAsList(exterGroupAsList);
        areaGroupList2.add(areaGroup2);
        areaGroupDTO.setExternalAreaGroupInfo(areaGroupList2);

        areaGroupService.addPolicy(areaGroupDTO);
    }


    @Test
    public void testModify(){
        AreaGroupDTO areaGroupDTO = new AreaGroupDTO();
        areaGroupDTO.setMessageNo(143L);
        List<AreaGroup> areaGroupList = Lists.newArrayList();
        AreaGroup areaGroup = new AreaGroup();
        areaGroup.setSeqOperType(1);
        areaGroup.setAreaType(0);
        areaGroup.setCreateTime(new Date());
        areaGroup.setMessageName("----testmodify---");
        areaGroup.setAreaId(3L);
        areaGroup.setAreaGroupName("---bang----");

        List<AreaGroupAs> areaGroupAsList = Lists.newArrayList();
        AreaGroupAs areaGroupAs1 = new AreaGroupAs();
        areaGroupAs1.setAsType(0);
        areaGroupAs1.setAreaSubId(123L);
        areaGroupAs1.setAsAreaId(101L);
        areaGroupAs1.setAsAreaName("----areaGroupAs1");
        areaGroupAsList.add(areaGroupAs1);

        AreaGroupAs areaGroupAs2 = new AreaGroupAs();
        areaGroupAs2.setAsType(0);
        areaGroupAs2.setAreaSubId(124L);
        areaGroupAs2.setAsAreaId(10100L);
        areaGroupAs2.setAsAreaName("-----areaGroupAs2");
        areaGroupAsList.add(areaGroupAs2);

        areaGroup.setAreaGroupAsList(areaGroupAsList);

        areaGroupList.add(areaGroup);

        areaGroupDTO.setInternalAreaGroupInfo(areaGroupList);


        List<AreaGroup> areaGroupList2 = Lists.newArrayList();
        AreaGroup areaGroup2 = new AreaGroup();
        areaGroup2.setSeqOperType(1);
        areaGroup2.setAreaType(1);
        areaGroup2.setCreateTime(new Date());
        areaGroup2.setMessageName("----testext");
        areaGroup2.setAreaId(3L);
        areaGroup2.setAreaGroupName("---bangext");

        List<AreaGroupAs> exterGroupAsList = Lists.newArrayList();

        AreaGroupAs areaGroupAs3 = new AreaGroupAs();

        areaGroupAs3.setAsType(1);
        areaGroupAs3.setAreaSubId(123L);
        areaGroupAs3.setAsAreaId(1110L);
        areaGroupAs3.setAsAreaName("---extareaGroupAs1");

        exterGroupAsList.add(areaGroupAs3);

        areaGroup2.setAreaGroupAsList(exterGroupAsList);
        areaGroupList2.add(areaGroup2);
        areaGroupDTO.setExternalAreaGroupInfo(areaGroupList2);

        areaGroupService.modifyPolicy(areaGroupDTO);
    }


    @Test
    public void testDeleteGroup(){
        AreaGroupDTO areaGroupDTO = new AreaGroupDTO();
        areaGroupDTO.setMessageNo(141L);
        areaGroupService.deletePolicy(areaGroupDTO);
    }
}
