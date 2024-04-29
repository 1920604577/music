package com.hln.music.pojo;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2024-04-29 20:18:34
 */
public class Admin implements Serializable {
    private static final long serialVersionUID = -68989398214783257L;

    private Object id;

    private String name;

    private String password;


    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

