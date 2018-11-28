package com.aotain.cu.utils;

public final class ResponseConstant {

    //成功
    public static int RESPONSE_SUCCESS=0;
    //失败
    public static int RESPONSE_ERROR=1;
    //拒绝操作
    public static int RESPONSE_REFUSE=2;

    //网络异常等,导致请求异常
    public static int RESPONSE_STATUE_CODE_NETERROR=400;
    //程序异常
    public static int RESPONSE_STATUE_CODE_SERVICEERROR=500;

    //程序拒绝操作
    public static int RESPONSE_STATUE_CODE_SERVICEREFUSE=201;

    //正常
    public static int RESPONSE_STATUE_CODE_SUCCESS=200;
}
