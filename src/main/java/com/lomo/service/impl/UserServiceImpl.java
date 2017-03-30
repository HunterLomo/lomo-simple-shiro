package com.lomo.service.impl;

import com.lomo.dao.UserDao;
import com.lomo.entity.UserEntity;
import com.lomo.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户Service实现类
 * @author lomo
 * @create 2017-03-06 15:43
 **/
public class UserServiceImpl implements UserService {
  @Resource
  private UserDao userDao;

  /**
   * 测试
   * @return
   */
  @Override
  public List<UserEntity> searchAllData() {
    return userDao.searchAllData();
  }

  /**
   * 根据用户名查询数据
   * @param userName 用户名
   * @return 用户实体
   */
  @Override
  public UserEntity findDataByUserName(String userName) {
    return userDao.findDataByUserName(userName);
  }
}
