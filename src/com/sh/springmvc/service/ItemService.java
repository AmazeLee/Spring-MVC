package com.sh.springmvc.service;

import java.util.List;

import com.sh.springmvc.pojo.Items;

public interface ItemService {
	
	//查询商品列表
	public List<Items> selectItemsList();
	
	//根据商品id查询商品
	Items queryItemById(Integer id);
	
	//根据id更新商品
	public void updateItemById(Items item);
}
