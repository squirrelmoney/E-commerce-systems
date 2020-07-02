package com.service;

import java.util.List;


import com.mapper.pojo.Cart;
import com.mapper.pojo.CartExample;
import com.mapper.pojo.CartKey;

public interface ICartService {	//判断购物车中是否有想要添加的商品
	int selectCartByGid(Cart car);
	
	   int deleteByExample(CartExample example);

	    int insert(Cart record);
	  //  int deleteByPrimaryKey(Integer cid);

	    int insertSelective(Cart record);

	    List<Cart> selectByExample(CartExample example);

	    int updateByPrimaryKey(Cart record);
	   // Cart selectByPrimaryKey(Integer cid);
	    
	    Cart selectByPrimaryKey(CartKey key);
	    int deleteByPrimaryKey(CartKey key);
	    
	    List<Cart> selectByPrimaryusername(String username);
}
