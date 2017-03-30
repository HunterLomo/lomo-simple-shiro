package com.lomo.sys;

import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识MyBatis的DAO
 * <p>便于org.mybatis.spring.mapper.MapperScannerConfigurer的快速扫描<p>
 * @author lomo
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MyBatisDao {
  /**
   * The value may indicate a suggestion for a logical component name, to be turned into a Spring
   * bean in case of an autodetected component.
   * @return the suggested component name, if any
   */
  String value() default "";
}
