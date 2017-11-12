package com.sh.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.springmvc.dao.ItemsMapper;
import com.sh.springmvc.pojo.Items;

/**
 * @ClassName: ItemServiceImpl 
 * @Description: 查询商品信息
 * @author lishuhua leeshuhua@163.com 
 * @date 2017年11月11日 下午3:28:14 
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	//查询商品列表
	public List<Items> selectItemsList(){
		return itemsMapper.selectByExampleWithBLOBs(null);
	}
	
	//通过id查询商品
	@Override
	public Items queryItemById(Integer id) {
		return itemsMapper.selectByPrimaryKey(id);
	}

	//通过id更新商品
	@Override
	public void updateItemById(Items item) {
		itemsMapper.updateByPrimaryKeySelective(item);
	}
}
