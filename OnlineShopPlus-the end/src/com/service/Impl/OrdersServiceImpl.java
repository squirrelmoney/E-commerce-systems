package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.pojo.Orders;
import com.mapper.pojo.OrdersExample;
import com.onlineshop.mapper.OrdersMapper;
import com.service.IOrdersService;
@Service
public class OrdersServiceImpl implements IOrdersService {
	@Autowired
private OrdersMapper OrdersMapper;

public int insert(Orders record) {
	// TODO Auto-generated method stub
	return OrdersMapper.insertSelective(record);
}

public Orders selectByPrimaryKey(Integer oid) {
	// TODO Auto-generated method stub
	return OrdersMapper.selectByPrimaryKey(oid);
}

public List<Orders> selectByExample(OrdersExample example) {
	// TODO Auto-generated method stub
	return OrdersMapper.selectByExample(example);
}

public int deleteByPrimaryKey(Integer oid) {
	// TODO Auto-generated method stub
	return OrdersMapper.deleteByPrimaryKey(oid);
}


public List<Orders> selectByusernames(String username) {
	// TODO Auto-generated method stub
	return (List<Orders>) OrdersMapper.selectByusernames(username);
}

public int insertSelective(Orders record) {
	// TODO Auto-generated method stub
	return OrdersMapper.insertSelective(record);
}

public int updateByPrimaryKey(Orders record) {
	// TODO Auto-generated method stub
	return OrdersMapper.updateByPrimaryKey(record);
}




}
