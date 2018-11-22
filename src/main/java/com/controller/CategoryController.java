package com.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Category;
import com.service.CategoryService;
import com.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping("listCategory")
	public ModelAndView listCategory(Page page){
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(),5);
		List<Category> cs= categoryService.list();
		int total = (int) new PageInfo<>(cs).getTotal();
		
		page.caculateLast(total);
		System.out.println("已经进入controllor");
		// 放入转发参数
		mav.addObject("cs", cs);
		// 放入jsp路径
		mav.setViewName("listCategory");
		System.out.println("已经设置返回了");
		return mav;
	}

	@RequestMapping(value = "getJson", method = RequestMethod.GET)
	@ResponseBody
	public Map getJson(HttpSession httpSession){
		Map<String,Object> map = new HashMap<String, Object>();
		List<Category> cs = new LinkedList<Category>();
		cs.add(new Category());
		cs.add(new Category());
		cs.add(new Category());
		cs.add(new Category());
		try {
			map.put("errorCode", 0);
			map.put("message", "hello");
			map.put("cs",cs);
		} catch (Exception e) {
			map.put("errorCode", 1);
			map.put("errorMessage", "未知错误");
		}
		System.out.println("已经进入controllor");
		System.out.println("已经设置返回了");
		return map;

	}

	@RequestMapping(value = "listCategorytoJson", method = RequestMethod.GET)
	@ResponseBody
	public Map listCategorytoJson(Page page){
		//ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(),5);
		List<Category> cs= categoryService.list();
		int total = (int) new PageInfo<>(cs).getTotal();

		page.caculateLast(total);
		System.out.println("已经进入controllor");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("cs",cs);
		// 放入转发参数
		//mav.addObject("cs", cs);
		// 放入jsp路径
		//mav.setViewName("listCategory");
		System.out.println("已经设置返回了");
		return map;
		//return mav;
	}

}
