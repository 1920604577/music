package com.hln.music.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 定位地址
 */
@Configuration
public class FileConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        // 歌手图片定位
        registry.addResourceHandler("/img/singerPic/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator") + "img"
                + System.getProperty("file.separator") + "singerPic" + System.getProperty("file.separator")
        );

        // 歌单图片定位
        registry.addResourceHandler("/img/songListPic/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator") + "img"
                        + System.getProperty("file.separator") + "singerPic" + System.getProperty("file.separator")
        );

        // 歌曲图片定位
        registry.addResourceHandler("/img/songPic/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator") + "img"
                        + System.getProperty("file.separator") + "songPic" + System.getProperty("file.separator")
        );

        // 歌曲定位
        registry.addResourceHandler("/song/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator") + "song" + System.getProperty("file.separator")
        );
    }

}
