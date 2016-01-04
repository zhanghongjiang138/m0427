/**
 * <strong>Title : User.java<br></strong>
 * <strong>Package : com.m0427.web<br></strong>
 * <strong>Description : </strong>TODO@类注释说明写在此处@<br> 
 * <strong>Create on : 2016年1月4日 下午2:48:07<br></strong>
 * <p>
 * @author zhanghongjiang<br>
 * @version <strong>v1.0.0</strong><br>
 * <br>
 * <strong>修改历史:</strong><br>
 * 修改人	|	修改日期	|	修改描述<br>
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
package com.m0427.web.model;

/**
 * <strong>Title : User.java<br></strong>
 * <strong>Package : com.m0427.web<br></strong>
 * <strong>Description : </strong>用户基本信息<br> 
 * <strong>Create on : 2016年1月4日 下午2:48:07<br></strong>
 * <p>
 * @author zhanghongjiang<br>
 * @version <strong>v1.0.0</strong><br>
 * <br>
 * <strong>修改历史:</strong><br>
 * 修改人	|	修改日期	|	修改描述<br>
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
public class User {
  private String userName;
  private String password;
  private String phone;
  private String MD5Password;
  /** 
  * @return userName
  */
  public String getUserName() {
    return userName;
  }
  /** 
  * @param userName 要设置的 userName
  */
  public void setUserName(String userName) {
    this.userName = userName;
  }
  /** 
  * @return password
  */
  public String getPassword() {
    return password;
  }
  /** 
  * @param password 要设置的 password
  */
  public void setPassword(String password) {
    this.password = password;
  }
  /** 
  * @return phone
  */
  public String getPhone() {
    return phone;
  }
  /** 
  * @param phone 要设置的 phone
  */
  public void setPhone(String phone) {
    this.phone = phone;
  }
  /** 
  * @return mD5Password
  */
  public String getMD5Password() {
    return MD5Password;
  }
  /** 
  * @param mD5Password 要设置的 mD5Password
  */
  public void setMD5Password(String mD5Password) {
    MD5Password = mD5Password;
  }
  
  
}
