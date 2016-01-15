package com.m0427.web.controller;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m0427.web.model.AjaxResult;
import com.m0427.web.model.UserInfo;
import com.m0427.web.service.UserService;


@Controller
@RequestMapping("/security/*")
public class SecurityController extends BaseController {
	
	@Resource
	  private UserService userService;
	  
	  @RequestMapping("redirectRegister")
	  public String redirectRegister(Model model)
	  {
		  return "security/register";
	  }
	  
	  @RequestMapping("register")
	  @ResponseBody
	  public AjaxResult index(UserInfo user,Model model) throws Exception
	  {
	    if(StringUtils.isBlank(user.getUserName()))
	    {
	      user.setUserName(user.getEmail());
	    }
	    if(StringUtils.isBlank(user.getPassword()))
	    {
	      return new AjaxResult("密码不能为空");
	    }
	    userService.insertUser(user);
	    return new AjaxResult("注册成功");
	  }
	  
	  @RequestMapping("validateUser")
	  @ResponseBody
	  public boolean validateUser(String userName) throws Exception
	  {
	    return userService.validateUser(userName)!=null;
	  }


}
