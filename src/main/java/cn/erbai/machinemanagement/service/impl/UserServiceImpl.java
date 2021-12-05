package cn.erbai.machinemanagement.service.impl;

import cn.erbai.machinemanagement.domain.UserDao;
import cn.erbai.machinemanagement.mybatis.entity.User;
import cn.erbai.machinemanagement.service.UserService;
import cn.erbai.machinemanagement.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: boood
 * @time: 2021/12/5 12:46
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void insertUser(User user) {
        String salt= SaltUtils.getSalt(8);
        user.setSalt(salt);
        Md5Hash md5Hash=new Md5Hash(user.getPassword(),salt,5);
        user.setPassword(md5Hash.toHex());
        userDao.insertUser(user);
    }

    @Override
    public User findByUserName(String username) {
        User user = userDao.findByUsername(username);
        return user;
    }
}
