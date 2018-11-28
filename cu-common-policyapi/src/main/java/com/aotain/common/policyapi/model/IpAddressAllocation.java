package com.aotain.common.policyapi.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.aotain.common.policyapi.base.BaseVo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * IP地址库下发策略实体类
 *
 * @author daiyh@aotain.com
 * @date 2017/12/25
 */
@Getter
@Setter
public class IpAddressAllocation extends BaseVo{

    @JSONField(serialize = false)
    private Integer dataId;
    @JSONField(serialize = false)
    private Short dataType;
    @JSONField(name="ip")
    private String serverIp;
    @JSONField(name="port")
    private Integer serverPort;

    private String userName;

    private String password;

    private String fileName;

    @JSONField(serialize = false)
    private Short fileStatus;
    @JSONField(serialize = false)
    private Date generateTime;
    @JSONField(serialize = false)
    private Date createTime;
    @JSONField(serialize = false)
    private String fileName2;
    @JSONField(serialize = false)
    private String fileName3;
}
