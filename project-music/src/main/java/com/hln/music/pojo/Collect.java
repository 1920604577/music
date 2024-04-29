package com.hln.music.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Collect)实体类
 *
 * @author makejava
 * @since 2024-04-29 20:21:07
 */
public class Collect implements Serializable {
    private static final long serialVersionUID = -42567047344394254L;

    private Long id;

    private Long userId;

    private Integer type;

    private Long songId;

    private Long songListId;

    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public Long getSongListId() {
        return songListId;
    }

    public void setSongListId(Long songListId) {
        this.songListId = songListId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

