package com.lomo.sys.shiro;

import com.lomo.entity.PermissionEntity;
import com.lomo.entity.RoleEntity;
import com.lomo.entity.UserEntity;
import com.lomo.service.PermissionService;
import com.lomo.service.RoleService;
import com.lomo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义Realm，登录认证及权限
 * @author lomo
 * @create 2017-03-06 13:36
 **/
public class MyRealm extends AuthorizingRealm {

  @Resource
  private UserService userService;
  @Resource
  private RoleService roleService;
  @Resource
  private PermissionService permissionService;

  /**
   * 权限认证
   * @param principalCollection
   * @return
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    //获取用户登录时输入的用户名
    String loginName = (String) principalCollection.fromRealm(getName()).iterator().next();
    //数据库查询是否有该用户
    UserEntity user = userService.findDataByUserName(loginName);
    if (null != user) {
      //权限信息对象info，用来存放查出的用户所有角色及权限
      SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
      // 获得角色集合
      Set<String> role_set = this.findRolesByUserId(user.getId());
      if (null != role_set && role_set.size() > 0) {
        info.setRoles(role_set);
      }
      // 获得权限集合(这里用户的的权限都是角色对应的)
      Set<String> permission_set = this.findPermissionsByUserId(user.getId());
      if (null != permission_set && permission_set.size() > 0) {
        info.setStringPermissions(permission_set);
      }
      return info;
    }
    return null;
  }

  /**
   * 用户认证
   * @param authenticationToken
   * @return
   * @throws AuthenticationException
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    //UsernamePasswordToken存储提交的登录信息
    UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
    String loginName = token.getUsername();
    String password = String.valueOf(token.getPassword());
    if (StringUtils.isAnyBlank(loginName, password)) {
      throw new AuthenticationException("登录名密码不能为空！");
    }
    checkAuthentication(loginName, password);
    //如果没有问题，用户放入登录认证info中
    return new SimpleAuthenticationInfo(token.getUsername(), token.getPassword(), getName());
  }

  /**
   * 根据用户ID，获取用户角色集合
   * @param userId 用户主键ID
   * @return 用户角色集合
   */
  private Set<String> findRolesByUserId(String userId) {
    if (StringUtils.isBlank(userId)) {
      return null;
    }
    // 获取用户对应的角色
    final List<RoleEntity> roleEntityList = roleService.findDataListByUserId(userId);
    if (null != roleEntityList && roleEntityList.size() > 0) {
      Set<String> role_set = new HashSet<>(roleEntityList.size());
      for (RoleEntity rE_loop : roleEntityList) {
        role_set.add(rE_loop.getRoleName());
      }
      return role_set;
    }
    return null;
  }

  /**
   * 根据用户ID，获取用户权限集合
   * @param userId 用户主键ID
   * @return 用户权限集合
   */
  private Set<String> findPermissionsByUserId(String userId) {
    if (StringUtils.isBlank(userId)) {
      return null;
    }
    // 获取用户对应的角色
    final List<PermissionEntity> permissionEntityList = permissionService.findDataListByUserId(userId);
    if (null != permissionEntityList && permissionEntityList.size() > 0) {
      Set<String> p_set = new HashSet<>(permissionEntityList.size());
      for (PermissionEntity pE_loop : permissionEntityList) {
        p_set.add(pE_loop.getPermissionName());
      }
      return p_set;
    }
    return null;
  }

  /**
   * 验证登录信息并保存到session中
   *
   * @param userName
   * @param password
   * @throws AuthenticationException 认证失败，抛出异常
   */
  private void checkAuthentication(final String userName, final String password)
      throws AuthenticationException {
    //查询是否有该用户
    UserEntity user = userService.findDataByUserName(userName);
    if (null == user) {
      throw new AuthenticationException("用户不存在！");
    }
    if (!password.equals(user.getPassword())) {
      throw new AuthenticationException("密码错误！");
    }
  }
}
