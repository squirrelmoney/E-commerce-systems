package com.service.Impl;
import java.util.List;

import org.apache.catalina.util.CharsetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controller.LoginController;
import com.mapper.pojo.Cart;
import com.mapper.pojo.CartExample;
import com.mapper.pojo.CartKey;
import com.onlineshop.mapper.CartMapper;
import com.service.ICartService;


@Service
public class CartServiceImpl implements ICartService 
{
	@Autowired
	private CartMapper cartDao;
	
	@Override
	public List<Cart> selectCartByusername(String username) {
		// TODO Auto-generated method stub
		return cartDao.selectCartByusername(username);
	}

	@Override
	public int insertSelective(Cart record) {
		// TODO Auto-generated method stub
		return cartDao.insertSelective(record);
	}

	@Override
	public int deleteCartBycid(int cid) {
		// TODO Auto-generated method stub
		return cartDao.deleteCartBycid(cid);
	}

	@Override
	public Cart selectByPrimaryKey(CartKey key) {
		// TODO Auto-generated method stub
		return cartDao.selectByPrimaryKey(key);
	}

	@Override
	public int updateByPrimaryKeySelective(Cart record) {
		// TODO Auto-generated method stub
		System.out.println(record);
		return cartDao.updateByPrimaryKey(record);
	}
}
