/**
 * <strong>Title : BaseController.java<br></strong>
 * <strong>Package : web<br></strong>
 * <strong>Description : </strong>TODO@类注释说明写在此处@<br> 
 * <strong>Create on : 2016年1月4日 下午1:15:17<br></strong>
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
package com.m0427.web.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m0427.web.model.AjaxResult;
import com.m0427.web.model.BaseInfo;
import com.m0427.web.model.UserInfo;
import com.m0427.web.service.UserService;
import com.m0427.web.service.impl.UserServiceImpl;

/**
 * <strong>Title : BaseController.java<br></strong>
 * <strong>Package : web<br></strong>
 * <strong>Description : </strong>基础控制器<br> 
 * <strong>Create on : 2016年1月4日 下午1:15:17<br></strong>
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
public class BaseController {
  public void setBaseInfo(BaseInfo info)
  {
	  String userName="zhanghongjiang";
	  info.setCreateDateTime(new Date());
	  info.setCreateUser(userName);
	  info.setModifyDateTime(new Date());
	  info.setModifyUser(userName);
  }
    
}
