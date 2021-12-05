package cn.erbai.machinemanagement.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description:
 * @author: boood
 * @time: 2021/12/4 21:33
 */
@RestController
@RequestMapping("test")
public class HelloController {
    //测试日志
    private final Logger logger = LoggerFactory.getLogger(HelloController.class.getName());

    @GetMapping("hello")
    public String hello() {
        logger.info("{}!", "日志测试");

        return "hello world!";
    }
}
