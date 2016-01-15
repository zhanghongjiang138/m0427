/**
 * <strong>Title : UserServiceImpl.java<br></strong>
 * <strong>Package : com.m0427.web.service.impl<br></strong>
 * <strong>Description : </strong>TODO@类注释说明写在此处@<br> 
 * <strong>Create on : 2016年1月4日 下午5:09:04<br></strong>
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
package com.m0427.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.m0427.web.dao.UserDao;
import com.m0427.web.model.UserInfo;
import com.m0427.web.service.UserService;
import com.m0427.web.utils.EncryptAlgorithm;

/**
 * <strong>Title : UserServiceImpl.java<br></strong>
 * <strong>Package : com.m0427.web.service.impl<br></strong>
 * <strong>Description : </strong>用户业务实现<br> 
 * <strong>Create on : 2016年1月4日 下午5:09:04<br></strong>
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
@Service("userService")
public class UserServiceImpl implements UserService {
  @Resource
  UserDao userDao;

  @Override
  public UserInfo getUser(String userName, String password) throws Exception {
    String MD5Password=EncryptAlgorithm.hexMD5(password);
    return userDao.getUser(userName,MD5Password);
  }

 
  @Override
  public boolean insertUser(UserInfo user) throws Exception {
    user.setPassword(EncryptAlgorithm.hexMD5(user.getPassword()));
    userDao.insertUser(user);
    return true;
  }


  /**
   * <strong>Title : validateUser<br></strong>
   * <strong>Description : </strong>验证用户名是否存在<br> 
   * <strong>Create on : 2016年1月6日 下午4:06:38<br></strong>
   * <p>
   * @param userName
   * @return
   * Object
   * @throws 
   * @author zhanghongjiang<br>
   * @version <strong>v1.0.0</strong><br>
   * <br>
   * <strong>修改历史:</strong><br>
   * 修改人	|	修改日期	|	修改描述<br>
   * -------------------------------------------<br>
   * <br>
   * <br>
   */
  public UserInfo validateUser(String userName) {
    return userDao.validateUser(userName);
  }

}
