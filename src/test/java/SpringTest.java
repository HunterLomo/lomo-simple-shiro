import com.lomo.entity.UserEntity;
import com.lomo.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * spring测试类
 * @author lomo
 * @create 2017-03-06 15:49
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class SpringTest {

  @Resource
  private UserService userService;

  /**
   * 首个测试用户查询
   */
  @org.junit.Test
  public void testUser() {
    List<UserEntity> userEntityList = userService.searchAllData();
    System.out.println(userEntityList.get(0).getId());
    System.out.println(userEntityList.get(0).getUserName());
    System.out.println(userEntityList.get(0).getPassword());
  }
}
