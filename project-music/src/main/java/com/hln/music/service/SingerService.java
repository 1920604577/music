package com.hln.music.service;

import com.hln.music.pojo.Singer;

import java.util.List;

public interface SingerService {

    /**
     * @author hln 2024-4-30
     * 添加
     */
    public boolean insert(Singer singer);

    /**
     * @author hln 2024-4-30
     * 修改
     */
    public boolean update(Singer singer);

    /**
     * @author hln 2024-4-30
     * 删除
     */
    public boolean delete(Long id);

    /**
     * @author hln 2024-4-30
     * 根据id查询对象
     */
    public Singer selectByPrimaryKey(Long id);

    /**
     * @author hln 2024-4-30
     * 查询所有
     */
    public List<Singer> allSinger();

    /**
     * @author hln 2024-4-30
     * 根据歌手名模糊查询list
     */
    public List<Singer> singerOfName(String name);

    /**
     * @author hln 2024-4-30
     * 根据性别查询
     */
    public List<Singer> singerOfSex(Integer sex);


}
