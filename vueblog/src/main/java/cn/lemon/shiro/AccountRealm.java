package cn.lemon.shiro;

import cn.hutool.core.bean.BeanUtil;
import cn.lemon.entity.User;
import cn.lemon.service.UserService;
import cn.lemon.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) authenticationToken;
        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();
        User user = userService.getById(Long.valueOf(userId));
        if (user == null)
            throw new  UnknownAccountException("该用户不存在");
        if (user.getStatus() == -1)
            throw new LockedAccountException("该用户已被锁定");
        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user,profile);
        return new SimpleAuthenticationInfo(profile,jwtToken.getCredentials(),getName());
    }
}
