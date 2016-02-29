package com.m0427.web.model.web;

public enum HttpStatus {
	 /**
	   * 操作成功返回200
	   */
	  OK(200),
	  /**
	   * 操作失败返回300
	   */
	  ERROR(300),
	  /**
	   * 会话超时（即登录失效）返回301，表示session超时
	   */
	  TIMEOUT(301);
	  
	  int value;
	  
	  private HttpStatus(int code)
	  {
		  this.value=code;
	  }
	  
	  public int getValue() {
		  return value;
	 }

}
