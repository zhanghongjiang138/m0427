package com.m0427.web.model.core;

import java.util.Date;
/**
 * 
 * @author zhanghongjiang
 * 基本信息
 */
public class BaseInfo {
	private String createUser;
	private Date createDateTime;
	private  String modifyUser;
	private Date modifyDateTime;
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public String getModifyUser() {
		return modifyUser;
	}
	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}
	public Date getModifyDateTime() {
		return modifyDateTime;
	}
	public void setModifyDateTime(Date modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}
	
	
}
