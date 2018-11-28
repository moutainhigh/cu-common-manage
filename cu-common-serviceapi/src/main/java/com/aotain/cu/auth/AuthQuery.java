package com.aotain.cu.auth;

/**
 * API用户认证参数类
 *
 * @author bang
 * @date 2018/11/20
 */
public class AuthQuery {
    private String accessKey;

    private String secretKey;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
