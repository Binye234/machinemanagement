package cn.erbai.machinemanagement.config;

import cn.erbai.machinemanagement.shiro.realm.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 用来整合shiro框架的相关配置类
 */
@Configuration
public class ShiroConfig {
    //1.创建shirofuter
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //配置系统受限资源
        Map<String,String> map=new HashMap<>();
        map.put("/login/*","anon");
        map.put("/**","authc");//"authc"请求这个资源需要认证和授权

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        shiroFilterFactoryBean.setLoginUrl("/login/index");
        //未授权跳转页面
//        shiroFilterFactoryBean.setUnauthorizedUrl("/login/index1");
        return shiroFilterFactoryBean;
    }

    //2.创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("getRealm") Realm realm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

    //3.创建自定义ream
    @Bean
    public Realm getRealm() {
        CustomerRealm customerRealm=new CustomerRealm();
        //生成hash密码匹配器
        HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();
        //设置hash算法
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        //设置hash的次数
        hashedCredentialsMatcher.setHashIterations(5);
        //修改匹配器为hash匹配器
        customerRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        //开启缓存管理
        customerRealm.setCacheManager(new EhCacheManager());
        //开启全局缓存
        customerRealm.setCachingEnabled(true);
        //开启认证缓存
        customerRealm.setAuthenticationCachingEnabled(true);
        //设置认证缓存在内存中的名字
        customerRealm.setAuthenticationCacheName("authenticationCache");
        //开启授权缓存
        customerRealm.setAuthorizationCachingEnabled(true);
        //设置授权缓存在内存中的名字
        customerRealm.setAuthorizationCacheName("authorizationCache");

        return customerRealm;
    }
}




