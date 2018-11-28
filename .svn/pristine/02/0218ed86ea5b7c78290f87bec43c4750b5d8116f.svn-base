package com.aotain.common.policyapi.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.aotain.common.policyapi.base.BaseVo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/12/20
 */
@Getter
@Setter
public class AreaGroup {
    /**
     * 对应的AreaSubId
     */
    private Long areaGroupId;
    /**
     * 对应的AreaSubName
     */
    @JSONField(serialize = false)
    private String areaGroupName;
    /**
     * 类型，0=源区域组，1=目的区域组
     */
    @JSONField(serialize = false)
    private Integer areaType;

    @JSONField(serialize = false)
    private Long messageNo;
    @JSONField(serialize = false)
    private Long messageSequenceNo;
    @JSONField(serialize = false)
    private int operationType;
    @JSONField(serialize = false)
    private int probeType;
    @JSONField(serialize = false)
    private int messageType;
    @JSONField(serialize = false)
    private String messageName;

    @JSONField(serialize = false)
    private Date createTime;
    /**
     * 操作类型：1添加 2修改 3删除
     */
    @JSONField(serialize = false)
    private Integer seqOperType;

    @JSONField(serialize = false)
    private Long areaId;

    private List<Long> asIds;

    private List<String> areaNames;

    @JSONField(serialize = false)
    private List<AreaGroupAs> areaGroupAsList;
}
