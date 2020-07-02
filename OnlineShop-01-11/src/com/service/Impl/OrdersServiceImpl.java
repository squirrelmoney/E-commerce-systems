package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.pojo.Orders;
import com.mapper.pojo.OrdersExample;
import com.onlineshop.mapper.OrdersMapper;
import com.service.IOrdersService;
@Service
public class OrdersServiceImpl implements IOrdersService{
    @Autowired
	private OrdersMapper ordersmapper;
	@Override
	public List<Orders> selectAll(OrdersExample example) {
		return ordersmapper.selectByExample(example);
	}

	@Override
	public Orders selectById(Integer oid) {
		return ordersmapper.selectByPrimaryKey(oid);
	}

	@Override
	public int deleteOrdersById(Integer oid) {
		return ordersmapper.deleteByPrimaryKey(oid);
	}

	@Override
	public int insertIntoOrders(Orders record) {
		return ordersmapper.insertSelective(record);
	}

	@Override
	public int updateOrdersById(Orders  record) {
		return ordersmapper.updateByPrimaryKeySelective(record);
	}

}
