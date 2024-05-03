package com.hln.music.service.impl;

import com.hln.music.mapper.SongMapper;
import com.hln.music.pojo.Song;
import com.hln.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongMapper songMapper;

    /**
     * @author hln 2024-5-1
     * 添加
     */
    @Override
    public boolean insert(Song song) {
        return songMapper.insert(song) > 0;
    }


    @Override
    public boolean update(Song song) {
        return songMapper.update(song) > 0;
    }

    @Override
    public boolean delete(Long id) {
        return songMapper.delete(id) > 0;
    }

    @Override
    public Song selectByPrimaryKey(Long id) {
        return songMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Song> allSong() {
        return songMapper.allSong();
    }

    @Override
    public List<Song> songOfName(String name) {
        return songMapper.songOfName(name);
    }

    @Override
    public List<Song> songOfSingerId(Long singerId) {
        List<Song> songs = songMapper.songOfSingerId(singerId);
        return songs;
    }
}
