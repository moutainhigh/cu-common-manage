package com.aotain.common.policyapi.constant;

import lombok.Getter;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/11/28
 */
@Getter
public enum DevFlag {
    DPI("DevFlag_DPI",(short)0), IDC("DevFlag_IDC",(short)1);

    private String name;
    private Short value;
    DevFlag(String name,Short value){
        this.name = name;
        this.value = value;
    }

    public static void main(String[] args) {
        System.out.println("========"+DevFlag.IDC.getValue());
    }
}
