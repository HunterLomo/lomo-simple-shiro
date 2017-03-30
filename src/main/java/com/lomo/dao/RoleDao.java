package com.lomo.dao;

import com.lomo.entity.RoleEntity;
import com.lomo.sys.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户角色Dao接口
 * @author lomo
 * @create 2017-03-29 15:33
 **/
@MyBatisDao
public interface RoleDao {
  /**
   * 根据用户主键ID，获取角色集合
   * @param userId 用户主键ID
   * @return 用户对应角色集合
   */
  List<RoleEntity> findDataListByUserId(@Param("userId") String userId);
}
