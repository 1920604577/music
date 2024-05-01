package com.hln.music.mapper;

import com.hln.music.pojo.Singer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SingerMapper {

    /**
     * @author hln 2024-4-30
     * 添加
     */
    public int insert(Singer singer);

    /**
     * 修改
     */
    public int update(Singer singer);

    /**
     * 删除
     */
    public int delete(Long id);

    /**
     * 根据id查询对象
     */
    public Singer selectByPrimaryKey(Long id);

    /**
     * 查询所有
     */
    public List<Singer> allSinger();

    /**
     * 根据歌手名模糊查询list
     */
    public List<Singer> singerOfName(String name);

}
