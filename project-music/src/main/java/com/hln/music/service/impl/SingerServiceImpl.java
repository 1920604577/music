package com.hln.music.service.impl;

import com.hln.music.mapper.SingerMapper;
import com.hln.music.pojo.Singer;
import com.hln.music.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerMapper singerMapper;

    /**
     * @author hln 2024-4-30
     * 添加
     */
    @Override
    public boolean insert(Singer singer) {
        return singerMapper.insert(singer) > 0;
    }

    /**
     * @author hln 2024-4-30
     * 修改
     */
    @Override
    public boolean update(Singer singer) {
        return singerMapper.update(singer) > 0;
    }

    /**
     * @author hln 2024-4-30
     * 删除
     */
    @Override
    public boolean delete(Long id) {
        return singerMapper.delete(id) > 0;
    }

    /**
     * @author hln 2024-4-30
     * 根据id查询对象
     */
    @Override
    public Singer selectByPrimaryKey(Long id) {
        return singerMapper.selectByPrimaryKey(id);
    }

    /**
     * @author hln 2024-4-30
     * 查询所有
     */
    @Override
    public List<Singer> allSinger() {
        return singerMapper.allSinger();
    }

    /**
     * @author hln 2024-4-30
     * 根据歌手名模糊查询list
     */
    @Override
    public List<Singer> singerOfName(String name) {
        return singerMapper.singerOfName(name);
    }

    /**
     * @author hln 2024-4-30
     * 根据性别查询
     */
    @Override
    public List<Singer> singerOfSex(Integer sex) {
        return singerMapper.singerOfSex(sex);
    }
}
