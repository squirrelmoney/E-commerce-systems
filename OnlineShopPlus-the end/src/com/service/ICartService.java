package com.service;

import java.util.List;



import com.mapper.pojo.Cart;
import com.mapper.pojo.CartExample;
import com.mapper.pojo.CartKey;

public interface ICartService {	//�жϹ��ﳵ���Ƿ�����Ҫ��ӵ���Ʒ
	List<Cart> selectCartByusername(String username);
	Cart selectByPrimaryKey(CartKey key);
	int insertSelective(Cart record);
	int deleteCartBycid(int cid);
	int updateByPrimaryKeySelective(Cart record);
}
