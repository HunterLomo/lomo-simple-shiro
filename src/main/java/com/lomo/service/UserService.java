package com.lomo.service;

import com.lomo.entity.UserEntity;

import java.util.List;

/**
 * 用户Service接口类
 * @author lomo
 * @create 2017-03-06 15:23
 **/
public interface UserService {
  /**
   * 测试
   * @return
   */
  List<UserEntity> searchAllData();

  /**
   * 根据用户名查询数据
   * @param userName 用户名
   * @return 用户实体
   */
  UserEntity findDataByUserName(String userName);
}
