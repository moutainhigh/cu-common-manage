package com.aotain.common.policyapi.base;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 策略实体基类
 * @author Administrator
 *
 */
public class BaseVo implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private int messageType;
    private Long messageNo;
    private Long messageSequenceNo;

    @JSONField(serialize = false)
    private Long topTaskId;

    @JSONField(serialize = false)
    private String messageName;
    /**
     * 策略类型， 0-DPI、1-EU 0
     */
//    @JSONField(serialize = false)
    private int probeType;

    /**
     * 操作类型：1-新增、2-修改、3-删除
     */
    private int operationType;
        

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public Long getMessageNo() {
        return messageNo;
    }

    public void setMessageNo(Long messageNo) {
        this.messageNo = messageNo;
    }

    public Long getMessageSequenceNo() {
        return messageSequenceNo;
    }

    public void setMessageSequenceNo(Long messageSequenceNo) {
        this.messageSequenceNo = messageSequenceNo;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public int getProbeType() {
        return probeType;
    }

    public void setProbeType(int probeType) {
        this.probeType = probeType;
    }

    public int getOperationType() {
        return operationType;
    }

    public void setOperationType(int operationType) {
        this.operationType = operationType;
    }

    public void setTopTaskId(long topTaskId) {
        this.topTaskId = topTaskId;
    }

    public Long getTopTaskId(){
        return topTaskId;
    }
    /**
     * 实体转JSON字符串
     * @return
     */
    public String objectToJson() {
        return JSON.toJSONString(this);
    }
    
    /**
     *  字符串转消息实体
     * @param json
     * @param cls
     * @return
     */
    public static <T extends BaseVo> T parseFrom(String json, Class<T> cls) {
        return  JSON.parseObject(json,cls);
    }
}
