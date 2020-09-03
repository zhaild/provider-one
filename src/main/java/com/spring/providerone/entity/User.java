package com.spring.providerone.entity;

import java.io.Serializable;

/**
 * @author zhaild
 * @date 2020/7/3110:35 AM
 * @Description: 用户实体类
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
