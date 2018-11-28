package com.aotain.common.policyapi.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.aotain.common.policyapi.base.BaseVo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * DPIFlowUpload实体类
 *
 * @author daiyh@aotain.com
 * @date 2017/12/15
 */
@Getter
@Setter
public class DPIFlowUpload extends BaseVo{
    /**
     * 主键
     */
    @JSONField(serialize = false)
    private Long seqId;

    /**
     * Ud 报文类型
     */
    private Integer packetType;
    /**
     * Ud 报文子类型
     */
    private Integer packetSubType;
    /**
     * 分析结果上报开始时间
     */
    @JSONField(name = "startTime")
    private Long rStartTime;
    /**
     * 分析结果上报结束时间
     */
    @JSONField(name = "endTime")
    private Long rEndTime;
    /**
     * 分析结果上报周期:0=即时上报，1=每5分钟上报，2=每小时整点上报，3=每3小时整点上报，4=每天零点上报，5=每30秒上报，6=每一分钟上报，7=每3分钟上报
     */
    @JSONField(name = "freq")
    private Integer rFreqence;
    /**
     * 上报服务器 IP 地址
     */
    @JSONField(name = "destIp")
    private String rDestIp;
    /**
     * 接收上报数据的上报服务器端口号
     */
    @JSONField(name = "destPort")
    private Integer rDestPort;
    /**
     * UD记录上报方式，1=socket方式，2=文件方式
     */
    @JSONField(name = "method")
    private Integer rMethod;
    /**
     * 服务器登录名
     */
    @JSONField(name = "userName")
    private String rServiceName;
    /**
     * 服务器密码
     */
    @JSONField(name = "password")
    private String rServicePwd;

    /**
     * 创建时间
     */
    @JSONField(serialize = false)
    private Date createTime;
    /**
     * 统计周期类型: 0小时 1日 2周 3月
     */
    @JSONField(serialize = false)
    private String statType;
}
