package com.hln.music.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    /**
     * @author hln 2024-4-30
     * 验证密码是否正确
     */
    public int verifyPassword(String username,String password);

}
