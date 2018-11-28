package com.aotain.common.policyapi.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.aotain.common.policyapi.base.BaseVo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import java.util.Date;

/**
 * EU状态实体类
 *
 * @author daiyh@aotain.com
 * @date 2017/11/30
 */
@Getter
@Setter
public class EuDeviceStatus extends BaseVo {

    @JSONField(serialize = false)
    private Date createTime;

    @JSONField(serialize = false)
    private Long userId;

    /**
     * EU设备类型
     */
    @JSONField(name="type")
    private Integer rType;

    /**
     * EU设备上报频率
     */
    @JSONField(name="frequence")
    private Integer rFreq;

    /**
     * 用于接收参数 不入库 也不序列化写入redis
     */
//    @Transient
//    private Integer rType2;

    /**
     * 用于接收参数 不入库  也不序列化写入redis
     */
//    @Transient
//    private Integer rFreq2;

}
