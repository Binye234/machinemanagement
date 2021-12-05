package cn.erbai.machinemanagement.service;

import cn.erbai.machinemanagement.mybatis.entity.User;

public interface UserService {
    void insertUser(User user);
    User findByUserName(String username);
}
