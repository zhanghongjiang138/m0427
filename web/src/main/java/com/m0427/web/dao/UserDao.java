/**
 * <strong>Title : UserDao.java<br></strong>
 * <strong>Package : com.m0427.web.dao<br></strong>
 * <strong>Description : </strong>TODO@类注释说明写在此处@<br> 
 * <strong>Create on : 2016年1月4日 下午4:58:26<br></strong>
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
package com.m0427.web.dao;

import org.apache.ibatis.annotations.Param;

import com.m0427.web.model.security.UserData;
import com.m0427.web.model.security.UserInfo;

/**
 * <strong>Title : UserDao.java<br></strong>
 * <strong>Package : com.m0427.web.dao<br></strong>
 * <strong>Description : </strong>用户持久层接口<br> 
 * <strong>Create on : 2016年1月4日 下午4:58:26<br></strong>
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
public interface UserDao {
  
    public UserInfo getUser(@Param("userName")String userName);

    public void insertUser(UserData user);


    public UserInfo validateUser(@Param("userName")String userName);
}
