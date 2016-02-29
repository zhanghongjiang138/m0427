package com.m0427.web.controller;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m0427.web.model.security.UserData;
import com.m0427.web.model.web.AjaxResult;
import com.m0427.web.service.UserService;


@Controller
@RequestMapping("/security/*")
public class SecurityController extends BaseController {
  private static final String REGISTER_PAGE="security/register";
  private static final String INDEX="index0";
	
	  @Resource
	  private UserService userService;
	  
	  @RequestMapping("doLogin")
	  public String doLogin(Model model)
	  {
	    return REGISTER_PAGE;
	  }
	  
	  @RequestMapping("redirectRegister")
	  public String redirectRegister(Model model)
	  {
		  return REGISTER_PAGE;
	  }
	  
	  @RequestMapping("accessDenied")
	  public String accessDenied(Model model)
	  {
	    model.addAttribute("accessDenied", true);
	    return REGISTER_PAGE;
	  }
	  
	  @RequestMapping("loginFailure")
    public String loginFailure(Model model)
    {
      model.addAttribute("loginFailure", true);
      return REGISTER_PAGE;
    }
	  
	  @RequestMapping("loginSuccess")
	  public String loginSuccess(Model model)
	  {
	    return INDEX;
	  }
	  
	  @RequestMapping("register")
	  @ResponseBody
	  public AjaxResult index(UserData user,Model model) throws Exception
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
