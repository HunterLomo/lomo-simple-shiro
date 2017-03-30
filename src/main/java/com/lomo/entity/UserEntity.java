package com.lomo.entity;

/**
 * 用户实体类
 * @author lomo
 * @create 2017-03-06 14:35
 **/
public class UserEntity extends BaseEntity {
  private static final long serialVersionUID = 6838386900379627861L;

  private String userName;//用户名
  private String password;//密码
  private String hideInfo;//隐藏的（just for play）

  public UserEntity() {
  }

  public UserEntity(String id, String userName, String password) {
    this.id = id;
    this.userName = userName;
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getHideInfo() {
    return hideInfo;
  }

  public void setHideInfo(String hideInfo) {
    this.hideInfo = hideInfo;
  }
}
