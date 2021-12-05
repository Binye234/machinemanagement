package cn.erbai.machinemanagement.web;

import cn.erbai.machinemanagement.mybatis.entity.User;
import cn.erbai.machinemanagement.service.UserService;
import jdk.nashorn.internal.runtime.Context;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @description:
 * @author: boood
 * @time: 2021/12/4 22:26
 */
@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private UserService userService;
    private final Logger logger = LoggerFactory.getLogger(HelloController.class.getName());
    @GetMapping("index")
    public String index() {

        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken("root", "1234"));
        } catch (AuthenticationException ex) {
            logger.error("{}!", ex.getMessage());
            return "index";
        }
        logger.error("{}!", "成功");
        return "index";
    }
    @GetMapping("register")
    public String register(){
        User user=new User();
        user.setUsername("root");
        user.setPassword("123");
        user.setName("测试");
        user.setLastLoginTime(String.valueOf(System.currentTimeMillis()));
        userService.insertUser(user);
        return "index";
    }
    @GetMapping("test")
    public String test(){
        System.out.println("test is run");
        return "index";
    }
}
