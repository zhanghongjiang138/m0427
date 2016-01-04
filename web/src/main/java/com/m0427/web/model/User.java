/**
 * <strong>Title : User.java<br></strong>
 * <strong>Package : com.m0427.web<br></strong>
 * <strong>Description : </strong>TODO@绫绘敞閲婅鏄庡啓鍦ㄦ澶凘<br> 
 * <strong>Create on : 2016骞�鏈�鏃�涓嬪崍2:48:07<br></strong>
 * <p>
 * @author zhanghongjiang<br>
 * @version <strong>v1.0.0</strong><br>
 * <br>
 * <strong>淇敼鍘嗗彶:</strong><br>
 * 淇敼浜�|	淇敼鏃ユ湡	|	淇敼鎻忚堪<br>
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
package com.m0427.web.model;

/**
	用户基本表
 */
public class User {
	private String userName;
	private String password;
	private String phone;
	private String email;
	private String MD5Password;
		  
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMD5Password() {
		return MD5Password;
	}
	public void setMD5Password(String mD5Password) {
		MD5Password = mD5Password;
	}
  
  
  
  
}
