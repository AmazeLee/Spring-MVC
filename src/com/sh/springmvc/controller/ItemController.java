package com.sh.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sh.springmvc.pojo.Items;
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
}
