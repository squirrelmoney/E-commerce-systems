package com.service;

import java.util.List;



import com.mapper.pojo.Cart;
import com.mapper.pojo.CartExample;
import com.mapper.pojo.CartKey;

public interface ICartService {	//判断购物车中是否有想要添加的商品
	List<Cart> selectCartByusername(String username);
	Cart selectByPrimaryKey(CartKey key);
	int insertSelective(Cart record);
	int deleteCartBycid(int cid);
	int updateByPrimaryKeySelective(Cart record);
}
