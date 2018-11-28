package com.aotain.common.policyapi.model;

import com.aotain.common.policyapi.base.BaseVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/12/21
 */
@Getter
@Setter
public class AreaGroupDTO extends BaseVo{

    private List<AreaGroup> internalAreaGroupInfo;
    private List<AreaGroup> externalAreaGroupInfo;

}
