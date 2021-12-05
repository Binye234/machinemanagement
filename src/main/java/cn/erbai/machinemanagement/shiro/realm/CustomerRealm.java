package cn.erbai.machinemanagement.shiro.realm;

import cn.erbai.machinemanagement.mybatis.entity.User;
import cn.erbai.machinemanagement.service.UserService;
import cn.erbai.machinemanagement.utils.ApplicationContextUitls;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.ObjectUtils;

public class CustomerRealm extends AuthorizingRealm {
    /**
     * 权限认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取主身份认证信息（用户名
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        //根据主身份信息获取角色和权限信息
        if(primaryPrincipal.equals("admin")){
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addRole("user");
            simpleAuthorizationInfo.addStringPermission("user:*:*");
            return simpleAuthorizationInfo;
        }
        return null;
    }

    /**
     * 用户认证
     * @param
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UserService userService =(UserService) ApplicationContextUitls.getBean("userServiceImpl");
        //获取用户名
        String username=(String)authenticationToken.getPrincipal();
        User user=userService.findByUserName(username);
        if(!ObjectUtils.isEmpty(user)){
            return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName());
        }
        return null;
    }
}

