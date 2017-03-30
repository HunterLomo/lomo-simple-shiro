package com.lomo.service.impl;

import com.lomo.dao.RoleDao;
import com.lomo.entity.RoleEntity;
import com.lomo.service.RoleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色Service实现类
 * @author lomo
 * @create 2017-03-29 15:31
 **/
public class RoleServiceImpl implements RoleService {
  @Resource
  private RoleDao roleDao;

  /**
   * 根据用户主键ID，获取角色集合
   * @param userId 用户主键ID
   * @return 用户对应角色集合
   */
  @Override
  public List<RoleEntity> findDataListByUserId(String userId) {
    return roleDao.findDataListByUserId(userId);
  }
}
