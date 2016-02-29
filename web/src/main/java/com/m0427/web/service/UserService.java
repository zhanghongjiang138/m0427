/**
 * <strong>Title : UserService.java<br></strong>
 * <strong>Package : com.m0427.web.service<br></strong>
 * <strong>Description : </strong>TODO@类注释说明写在此处@<br> 
 * <strong>Create on : 2016年1月4日 下午5:07:50<br></strong>
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
package com.m0427.web.service;

import com.m0427.web.model.security.UserData;
import com.m0427.web.model.security.UserInfo;

/**
 * <strong>Title : UserService.java<br></strong>
 * <strong>Package : com.m0427.web.service<br></strong>
 * <strong>Description : </strong>TODO@类注释说明写在此处@<br> 
 * <strong>Create on : 2016年1月4日 下午5:07:50<br></strong>
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
public interface UserService {
  
   public UserInfo getUser(String userName);

   public boolean insertUser(UserData user);
   
   public UserInfo validateUser(String userName);
   
}
