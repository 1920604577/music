package com.hln.music.service;

public interface AdminService {

    /**
     * @author hln 2024-4-30
     * 验证密码是否正确
     */
    public boolean verifyPassword(String username,String password);

}
