package com.aotain.common.policyapi.constant;

import lombok.Getter;

import java.io.Serializable;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/11/28
 */
@Getter
public class MessageTypeConstants implements Serializable{

    // EU设备通用信息下发
    public static final Integer MESSAGE_TYPE_DPI_INFO =  209;
    //IDC机房与IP地址段对应信息下发
    public static final Integer MESSAGE_TYPE_HOUSE_IP =  130;
    //ISMS流量结果上报
    public static final Integer MESSAGE_TYPE_FLOW_UPLOAD =  11;
    //机房策略绑定
    public static final Integer MESSAGE_TYPE_HOUSE_POLICY_BIND =  133;
    // 信息安全管理策略
    public static final Integer MESSAGE_TYPE_ISP_MESSAGE_POLICY =  16;
    //访问日志管理策略
    public static final Integer MESSAGE_TYPE_ACCESS_LOG =  15;
    // EU设备状态查询请求
    public static final Integer MESSAGE_TYPE_EU_STATUS = 210;

    //应用流量流向上报策略
    public static final Integer MESSAGE_TYPE_APPLICATION_FLOW_UPLOAD = 69;
    //流量分析结果上报策略
    public static final Integer MESSAGE_TYPE_FLOW_UPLOAD_ANALYSIS = 1;
    //用户应用策略信息下发
    public static final Integer MESSAGE_TYPE_USER_BIND_POLICY = 133;
    //IP地址库下发策略
    public static final Integer MESSAGE_TYPE_IP_ADDRESS_ALLOCATION = 202;


}
