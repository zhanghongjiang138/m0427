package com.m0427.web.model.security;

import org.springframework.security.core.GrantedAuthority;

public class MyAuthority implements GrantedAuthority {
  /** 
  *
  * @creator     :zhanghongjiang
  */ 
  private static final long serialVersionUID = 7686446569596735330L;

  private String authority;
  public MyAuthority(String authority)
  {
   this.authority=authority; 
  }
  @Override
  public String getAuthority() {
    return authority;
  }

}
