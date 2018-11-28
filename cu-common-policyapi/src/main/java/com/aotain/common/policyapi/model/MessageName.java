package com.aotain.common.policyapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/11/21
 */
@Getter
@Setter
public class MessageName {

    private Long messageNo;

    private Integer messageType;

    private String messageName;

    private Integer operationType;

    private Date updateTime;
}
