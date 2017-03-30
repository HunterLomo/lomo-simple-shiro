package com.lomo.service.impl;

import com.lomo.dao.PermissionDao;
import com.lomo.entity.PermissionEntity;
import com.lomo.service.PermissionService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限Service实现类
 * @author lomo
 * @create 2017-03-30 13:48
 **/
public class PermissionServiceImpl implements PermissionService {
  @Resource
  private PermissionDao permissionDao;

  /**
   * 根据用户ID，获取用户权限集合
   * @param userId 用户主键ID
   * @return 用户权限集合
   */
  @Override
  public List<PermissionEntity> findDataListByUserId(String userId) {
    return permissionDao.findDataListByUserId(userId);
  }
}
