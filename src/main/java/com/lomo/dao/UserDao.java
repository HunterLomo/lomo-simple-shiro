package com.lomo.dao;

import com.lomo.entity.UserEntity;
import com.lomo.sys.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户Dao接口类
 * @author lomo
 * @create 2017-03-06 14:36
 **/
@MyBatisDao
public interface UserDao {

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
  UserEntity findDataByUserName(@Param("userName") String userName);
}
