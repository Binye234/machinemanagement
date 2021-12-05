package cn.erbai.machinemanagement.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: boood
 * @time: 2021/12/5 19:40
 */
@Aspect
@Component
public class OperationAop {
    @Pointcut("execution(* cn.erbai.machinemanagement.web.LoginController.test())")
    public void operationPointcut(){}
    @Before("operationPointcut()")
    public void beforeMethod(){
        System.out.println("before is run");
    }
    @After("operationPointcut()")
    public void aftermethod(){
        System.out.println("after is run");
    }
}
