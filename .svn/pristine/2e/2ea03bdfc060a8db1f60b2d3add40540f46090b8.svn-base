package com.aotain.common.policyapi.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.aotain.common.policyapi.base.BaseVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/12/20
 */
@Getter
@Setter
public class UserPolicyBind extends BaseVo{

    @JSONField(serialize = false)
    private Long bindId;

    @JSONField(serialize = false)
    private Long pUserGroup;

    @JSONField(serialize = false)
    private String createTime;

    @JSONField(serialize = false)
    private Long parentBindId;

    private Integer bindAction;

    private Integer userType;

    private String userName;

    private List<BindMessage> bindInfo;

    @JSONField(serialize = false)
    private Long bindMessageNo;

    @JSONField(serialize = false)
    private Long bindMessageType;

}
