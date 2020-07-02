package com.service;

import java.util.List;

import com.mapper.pojo.Orders;
import com.mapper.pojo.OrdersExample;


public interface IOrdersService {
	public List<Orders> selectAll(OrdersExample example);
	public Orders selectById(Integer oid);
	public int deleteOrdersById(Integer oid);
	public int insertIntoOrders(Orders record);
	public int updateOrdersById(Orders record);
}
