package com.lomo.service;

import com.lomo.entity.RoleEntity;

import java.util.List;

/**
 * 角色Service接口类
 * @author lomo
 * @create 2017-03-06 15:23
 **/
public interface RoleService {
  /**
   * 根据用户主键ID，获取角色集合
   * @param userId 用户主键ID
   * @return 用户对应角色集合
   */
  List<RoleEntity> findDataListByUserId(String userId);
}
