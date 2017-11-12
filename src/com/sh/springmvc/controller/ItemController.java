package com.sh.springmvc.controller;

import java.util.List;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sh.springmvc.pojo.Items;
import com.sh.springmvc.pojo.QueryVo;
import com.sh.springmvc.service.ItemService;

/**
 * 
 * @ClassName: ItemController
 * @Description: 商品管理
 * @author lishuhua leeshuhua@163.com
 * @date 2017年11月11日 上午10:38:57
 *
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	// 入门程序
	@RequestMapping(value = "/item/itemlist.action")
	public ModelAndView itemList() {
		//从Mysql中查询数据
		List<Items> list = itemService.selectItemsList();
		ModelAndView mav = new ModelAndView();
		//添加数据
		mav.addObject("itemList",list);
		mav.setViewName("itemList");
		return mav;
	}
	/*
	//通过id查询商品
	@RequestMapping(value = "/itemEdit.action")
	public ModelAndView queryItemById(HttpServletRequest request) {
		//从request中获取请求参数
		String strId = request.getParameter("id");
		Integer id = Integer.valueOf(strId);
		
		//根据id查询商品数据
		Items item = itemService.queryItemById(id);
		//把结果传递到页面
		ModelAndView modelAndView = new ModelAndView();
		//将商品数据放在模型中
		modelAndView.addObject("item",item);
		
		//设置逻辑视图 
		modelAndView.setViewName("editItem");
		return modelAndView;
		
	}*/
	

	/**
	 * 通过id查询商品,使用Model
	 * @param request
	 * @param model
	 * @return
	 */
	/*@RequestMapping(value = "/itemEdit")
	public String queryItemById(HttpServletRequest request,Model model) {
		//从request中获取请求参数
		String strId = request.getParameter("id");
		Integer id = Integer.valueOf(strId);
		
		//根据id查询商品数据
		Items item = itemService.queryItemById(id);
		
		model.addAttribute("item",item);
		
		return "editItem";	
	}*/
	
	/**
	 * 根据id查询商品，使用ModrlMap
	 * @param request
	 * @param model
	 * @return
	 */
	/*@RequestMapping(value = "/itemEdit")
	public String queryItemById(HttpServletRequest request,ModelMap model) {
		//从request中获取请求参数
		String strId = request.getParameter("id");
		Integer id = Integer.valueOf(strId);
		
		//根据id查询商品数据
		Items item = itemService.queryItemById(id);
		
		model.addAttribute("item",item);
		
		return "editItem";	
	}*/
	
	/**
	 * 根据id查询商品，绑定简单数据类型
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/itemEdit")
	public String queryItemById(int id,ModelMap model) {
		
		//根据id查询商品数据
		Items item = itemService.queryItemById(id);
		
		model.addAttribute("item",item);
		
		return "editItem";	
	}
	
	/**
	 * 更新商品，绑定pojo类型
	 * @param item
	 * @return
	 */
	@RequestMapping(value = "/updateItem")
	public String updateItem(Items item) {
		//调用service更新商品
		itemService.updateItemById(item);
		return "success";
		
	}
	
	/**
	 * 绑定包装数据类型
	 * @param queryVo
	 * @return
	 */
	@RequestMapping(value="/queryItem")
	public String queryItem(QueryVo queryVo) {
		System.out.println(queryVo.getItems().getId()+"------"+queryVo.getItems().getName());
		return "success";
	}
	
}
