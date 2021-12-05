package cn.erbai.machinemanagement.domain;

import cn.erbai.machinemanagement.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: boood
 * @time: 2021/12/5 12:34
 */
@Mapper
@Repository
public interface UserDao {
    void insertUser(User user);
    User findByUsername(String username);
}
