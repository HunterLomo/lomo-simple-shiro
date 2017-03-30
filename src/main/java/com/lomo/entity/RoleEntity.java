package com.lomo.entity;

/**
 * 角色实体类
 * @author lomo
 * @create 2017-03-29 13:29
 **/
public class RoleEntity extends BaseEntity {
  private String roleName;

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }
}
