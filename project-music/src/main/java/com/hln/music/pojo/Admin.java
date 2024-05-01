package com.hln.music.pojo;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2024-05-01 11:28:54
 */
public class Admin implements Serializable {
    private static final long serialVersionUID = 371643170485862047L;

    private Long id;

    private String name;

    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

