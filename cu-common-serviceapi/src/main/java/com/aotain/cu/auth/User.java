package com.aotain.cu.auth;

/**
 * Demo class
 *
 * @author bang
 * @date 2018/11/20
 */
public class User {
    private Long id;

    public User(Long id) {
        this.id = id;
    }
    public User() {
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
