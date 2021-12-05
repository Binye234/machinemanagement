package cn.erbai.machinemanagement.mybatis.entity;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: boood
 * @time: 2021/12/5 12:02
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private String salt;
    //时间戳
    private String lastLoginTime;
}
