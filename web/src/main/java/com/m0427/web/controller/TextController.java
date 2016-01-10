package com.m0427.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.m0427.web.model.AjaxResult;
import com.m0427.web.model.Essay;
import com.m0427.web.service.EssayService;

/**
 * 
 * @author zhanghongjiang
 *文章控制器
 */

@Controller
@RequestMapping("/text/*")
public class TextController extends BaseController {
	
	@Resource EssayService essayService;
	
	@RequestMapping(value="insertEssay")
	public AjaxResult insertTitle(Model model,Essay essay)
	{
		essayService.insertEssay(essay);
		return null;
	}
	
	@RequestMapping(value="selectAllEssay")
	public List<Essay> selectAllEssay(Model model,Essay essay)
	{
		return essayService.selectAllEssay();
	}
	
	@RequestMapping(value="addEssay")
	public String addEssay(Model model,Essay essay)
	{
		return "text/addEssay";
	}
			
}
