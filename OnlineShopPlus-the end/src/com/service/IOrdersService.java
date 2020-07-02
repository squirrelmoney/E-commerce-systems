package com.service;

import java.util.List;

import com.mapper.pojo.Orders;
import com.mapper.pojo.OrdersExample;

public interface IOrdersService {
	int insert(Orders record);
	int insertSelective(Orders record);
	Orders selectByPrimaryKey(Integer oid);
	int deleteByPrimaryKey(Integer oid);
	List<Orders> selectByExample(OrdersExample example);
	List<Orders> selectByusernames(String username);
	int updateByPrimaryKey(Orders record);
}
