package com.aotain.common.policyapi.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/11/28
 */
@Getter
@Setter
public class BindMessage implements Serializable{

    private Long bindMessageType;

    private Long bindMessageNo;

    @Override
    public int hashCode() {
        return this.bindMessageType.hashCode() + this.bindMessageNo.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if ( !(o instanceof BindMessage) ){
            return false;
        }
        BindMessage bindMessage = (BindMessage) o;
        return bindMessage.getBindMessageNo().equals(this.getBindMessageNo())
                &&bindMessage.getBindMessageType().equals(this.getBindMessageType());
    }
}
