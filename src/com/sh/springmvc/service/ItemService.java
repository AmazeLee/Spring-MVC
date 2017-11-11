package com.sh.springmvc.service;

import java.util.List;

import com.sh.springmvc.pojo.Items;

public interface ItemService {
	
	//查询商品列表
	public List<Items> selectItemsList();
}
