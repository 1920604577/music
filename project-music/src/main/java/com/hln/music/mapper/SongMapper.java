package com.hln.music.mapper;

import com.hln.music.pojo.Song;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SongMapper {

    /**
     * @author hln 2024-5-1
     * 添加
     */
    public int insert(Song song);

    /**
     * @author hln 2024-5-1
     * 修改
     */
    public int update(Song song);

    /**
     * @author hln 2024-5-1
     * 删除
     */
    public int delete(Long id);

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
