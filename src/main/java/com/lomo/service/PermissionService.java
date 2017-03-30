package com.lomo.service;

import com.lomo.entity.PermissionEntity;

import java.util.List;

/**
 * 权限Service接口类
 * @author lomo
 * @create 2017-03-30 13:48
 **/
public interface PermissionService {
  /**
   * 根据用户ID，获取用户权限集合
   * @param userId 用户主键ID
   * @return 用户权限集合
   */
  List<PermissionEntity> findDataListByUserId(String userId);
}
