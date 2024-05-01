package com.hln.music.pojo;

import java.io.Serializable;

/**
 * (Rank)实体类
 *
 * @author makejava
 * @since 2024-05-01 11:28:54
 */
public class Rank implements Serializable {
    private static final long serialVersionUID = 436661251076369990L;

    private Object id;

    private Object songlistid;

    private Object consumerid;

    private Object score;


    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getSonglistid() {
        return songlistid;
    }

    public void setSonglistid(Object songlistid) {
        this.songlistid = songlistid;
    }

    public Object getConsumerid() {
        return consumerid;
    }

    public void setConsumerid(Object consumerid) {
        this.consumerid = consumerid;
    }

    public Object getScore() {
        return score;
    }

    public void setScore(Object score) {
        this.score = score;
    }

}

