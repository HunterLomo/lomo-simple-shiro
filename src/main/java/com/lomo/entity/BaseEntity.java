package com.lomo.entity;

import java.io.Serializable;

/**
 * BaseEntity
 * @author lomo
 * @create 2017-03-06 14:57
 **/
public class BaseEntity implements Serializable {
  private static final long serialVersionUID = -7812056973158220094L;
  protected String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
