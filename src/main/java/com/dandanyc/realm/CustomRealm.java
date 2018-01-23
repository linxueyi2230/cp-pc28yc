//package com.dandanyc.realm;
//
//import com.dandanyc.service.UserService;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class CustomRealm extends AuthorizingRealm{
//    private static final Logger logger = LoggerFactory.getLogger(CustomRealm.class);
//    @Autowired
//    private UserService userService;
//    /**
//     * 用户授权认证
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        logger.info("======用户授权认证======");
//        String userName = principalCollection.getPrimaryPrincipal().toString();
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.setRoles(userService.queryRolesByName(userName));
//        return simpleAuthorizationInfo;
//    }
//    /**
//     * 用户登陆认证
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        logger.info("======用户登陆认证======");
//        String userName = authenticationToken.getPrincipal().toString();
//        User user = userService.queryUserByName(userName);
//        if (user!=null) {
//            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), "peng");
//            return authenticationInfo;
//        }
//        return null;
//    }
//
//}
