package com.hln.music.pojo;

import java.io.Serializable;

/**
 * (ListSong)实体类
 *
 * @author makejava
 * @since 2024-05-01 11:28:54
 */
public class ListSong implements Serializable {
    private static final long serialVersionUID = 829760856735521554L;

    private Long id;

    private Long songId;

    private Long songListId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}

