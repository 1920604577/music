package com.hln.music.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Singer)实体类
 *
 * @author makejava
 * @since 2024-04-29 20:21:07
 */
public class Singer implements Serializable {
    private static final long serialVersionUID = 624173142654009187L;

    private Long id;

    private String name;

    private Integer sex;

    private String pic;

    private Date birth;

    private String location;

    private String introduction;


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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

}

