package com.m0427.web.model;

public enum CallbackType {
	/**
	   * 客户端无任何操作
	   */
	  Empty(""),
	  /**
	   * dwz客户端关闭当前tab
	   */
	  closeCurrent("closeCurrent"),
	  /**
	   * 页面跳转命令，配合forwardUrl（跳转接口）指令
	   */
	  forward("forward");

	  String value;
	  private CallbackType(String code)
	  {
		  this.value=code;
	  }
	  public String getValue(){
		  return this.value;
	  }

}
