package com.hln.music.pojo;

import java.io.Serializable;

/**
 * (SongList)实体类
 *
 * @author makejava
 * @since 2024-05-01 11:28:54
 */
public class SongList implements Serializable {
    private static final long serialVersionUID = 245344597916217899L;

    private Long id;

    private String title;

    private String pic;

    private String introduction;

    private String style;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

}

