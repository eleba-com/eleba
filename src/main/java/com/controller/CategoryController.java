package com.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Category;
import com.pojo.Merchant;
import com.service.CategoryService;
import com.util.Page;
import com.util.Upload.UoloadImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
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

	private UoloadImage uploadImage;

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

	/**
	 * 方法实现说明
	 * @author      jhao
	 * @param       httpSession
	 * @return      java.util.Map
	 * @exception
	 * @date        2018/11/22 16:06
	 */
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
			map.put("message", "出错了！");
			map.put("cs",cs);
		} catch (Exception e) {
			map.put("errorCode", 1);
			map.put("errorMessage", "未知错误");
		}

		System.out.println("已经进入controllor");



		// 放入转发参数
		//mav.addObject("cs", cs);
		// 放入jsp路径
		//mav.setViewName("listCategory");
		System.out.println("已经设置返回了");
		return map;
		//return mav;
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

	/**
	* 上传图片测试
	* @author：      jiehao
	* @param
	* @return：
	* @exception：
	* @date：       2018/11/27 10:45
	*/
	@RequestMapping(value = "uploadImage" ,method = RequestMethod.GET)
	@ResponseBody
	public Map uploadImageTest(Merchant merchant, HttpServletRequest request)throws Exception{

		String dir = request.getSession().getServletContext().getRealPath("")+"/upload/images/";
		File file=new File(dir);
		//如果文件夹不存在
		if(!file.exists()){
			//创建文件夹
			file.mkdir();
		}
		uploadImage=new UoloadImage();
		String  filename=uploadImage.uploadImage(merchant.getImageFile(),dir);
		Map<String,Object> map = new HashMap<String, Object>();
		String sqlPath="/upload/images/"+filename;
		map.put("sqlPath",sqlPath);
		return map;
	}

}
