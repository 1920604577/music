package com.hln.music.service;

import com.hln.music.pojo.Song;

import java.util.List;

public interface SongService {

    /**
     * @author hln 2024-5-1
     * 添加
     */
    public boolean insert(Song song);

    /**
     * @author hln 2024-5-1
     * 修改
     */
    public boolean update(Song song);

    /**
     * @author hln 2024-5-1
     * 删除
     */
    public boolean delete(Long id);

    /**
     * @author hln 2024-5-1
     * 根据id查询对象
     */
    public Song selectByPrimaryKey(Long id);

    /**
     * @author hln 2024-5-1
     * 查询所有
     */
    public List<Song> allSong();

    /**
     * @author hln 2024-5-1
     * 根据歌名模糊查询list
     */
    public List<Song> songOfName(String name);

    /**
     * @author hln 2024-5-1
     * 根据歌手id查询
     */
    public List<Song> songOfSingerId(Long singerId);


}
