package com.aotain.common.policyapi.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.aotain.common.policyapi.base.BaseVo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class DpiV1CfgDpiinfo extends BaseVo {

    @JSONField(serialize = false)
    private Long devId;
    @JSONField(serialize = false)

    private Short devFlag;
    @JSONField(serialize = false)
    private Long zongfenId;
   
    @JSONField(serialize = false)
    private Long areaCode;
    @JSONField(serialize = false)
    private Long idcPort;
    @JSONField(serialize = false)
    private Short connectFlag;
    @JSONField(serialize = false)
    private Short operateFlag;
    @JSONField(serialize = false)
    private String remark;
    @JSONField(serialize = false)
    private Date updateTime;
    @JSONField(serialize = false)
    private Long userId;

    private String devName;

    @JSONField(name="port")
    private Long serialPort;

//    private Integer aliveState;
//
//    private Integer isChange;
//
//    private String alarmTime;
//
//    private Integer alarmNumbers;

    private String deploySiteName;

//    private int probeType;

    private String ip;

    @JSONField(serialize = false)
    private Long port;
    
    private String zfDeviceIp;

    private List<String> idcHouseIds;

}

