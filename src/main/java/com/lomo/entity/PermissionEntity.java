package com.lomo.entity;

/**
 * 权限实体类
 * @author lomo
 * @create 2017-03-29 13:31
 **/
public class PermissionEntity extends BaseEntity {
  private String permissionName;
  private String roleId;

  public String getPermissionName() {
    return permissionName;
  }

  public void setPermissionName(String permissionName) {
    this.permissionName = permissionName;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }
}
