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
public class CartServiceImpl implements ICartService {
	@Autowired
	   private CartMapper  CartMapper;
	
	public int selectCartByGid(Cart car) {
		for (int i = 1; i <  LoginController.cart.size(); i ++)
		{
			if (LoginController.cart.get(i).getCid() == car.getCid())
				return i;
		}
		return -1;
	}

	public int deleteByExample(CartExample example) {
		// TODO Auto-generated method stub
		return CartMapper.deleteByExample(example);
	}

	public int insert(Cart record) {
		// TODO Auto-generated method stub
		return CartMapper.insert(record);
	}

	public int insertSelective(Cart record) {
		// TODO Auto-generated method stub
		return CartMapper.insertSelective(record);
	}

	public List<Cart> selectByExample(CartExample example) {
		// TODO Auto-generated method stub
		return CartMapper.selectByExample(example);
	}



//	public int deleteByPrimaryKey(Integer cid) {
//		// TODO Auto-generated method stub
//		return CartMapper.deleteByPrimaryKey(cid);
//	}

//	public Cart selectByPrimaryKey(Integer cid) {
//		// TODO Auto-generated method stub
//		return CartMapper.selectByPrimaryKey(cid);
//	}

	public int updateByPrimaryKey(Cart record) {
		// TODO Auto-generated method stub
		return CartMapper.updateByPrimaryKey(record);
	}

	public  Cart selectByPrimaryKey(CartKey key) {
		// TODO Auto-generated method stub
		return CartMapper.selectByPrimaryKey(key);
	}

	public List<Cart> selectByPrimaryusername(String username) {
		// TODO Auto-generated method stub
		return CartMapper.selectByPrimaryusername(username);
	}

	public int deleteByPrimaryKey(CartKey key) {
		// TODO Auto-generated method stub
		return CartMapper.deleteByPrimaryKey(key);
	}




	


}
