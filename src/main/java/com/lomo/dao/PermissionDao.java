package com.lomo.dao;

import com.lomo.entity.PermissionEntity;
import com.lomo.sys.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户权限Dao接口
 * @author lomo
 * @create 2017-03-30 13:59
 **/
@MyBatisDao
public interface PermissionDao {

  /**
   * 根据用户ID，获取用户权限集合
   * @param userId
   * @return
   */
  List<PermissionEntity> findDataListByUserId(@Param("userId") String userId);
}
