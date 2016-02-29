package com.m0427.web.model.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserInfo implements UserDetails {
  
  /** 
  * 
  * @creator     :zhanghongjiang
  */ 
  private static final long serialVersionUID = -2909430350129866959L;

  private String password;
  
  private String userName;
  
  private List<MyAuthority> authorities=new ArrayList<MyAuthority>(10);;
  

  /** 
  * @param userName 要设置的 userName
  */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /** 
  * @param password 要设置的 password
  */
  public void setPassword(String password) {
    this.password = password;
  }

  /** 
  * @param authorities 要设置的 authorities
  */
  public void setAuthorities(List<MyAuthority> authorities) {
    this.authorities = authorities;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.userName;
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities;
  }

}
