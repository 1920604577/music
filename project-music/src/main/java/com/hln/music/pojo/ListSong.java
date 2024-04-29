package com.hln.music.pojo;

import java.io.Serializable;

/**
 * (ListSong)实体类
 *
 * @author makejava
 * @since 2024-04-29 20:21:07
 */
public class ListSong implements Serializable {
    private static final long serialVersionUID = 624291981966174350L;

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

