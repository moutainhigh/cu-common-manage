package com.aotain.common.policyapi.model;

import com.alibaba.fastjson.annotation.JSONField;
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
public class AreaGroupAs {
    /**
     * 对应的AreaSubId
     */
    @JSONField(serialize = false)
    private Long areaSubId;

    /**
     *
     */
    private Long areaGroupId;

    /**
     * 类型，0=AS_ID， 1=Area_Name
     */
    private Integer asType;

//    private List<Long> asAreaIds;
//
//    private List<String> asAreaNames;

    @JSONField(serialize = false)
    private Long asAreaId;

    @JSONField(serialize = false)
    private String asAreaName;


}
