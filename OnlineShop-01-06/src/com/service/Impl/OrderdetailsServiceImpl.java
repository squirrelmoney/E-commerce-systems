package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mapper.pojo.Orderdetails;
import com.mapper.pojo.OrderdetailsExample;
import com.mapper.pojo.OrderdetailsKey;
import com.onlineshop.mapper.OrderdetailsMapper;
import com.service.IOrderdetailsService;
@Service
public class OrderdetailsServiceImpl implements IOrderdetailsService{
	@Autowired
    private OrderdetailsMapper orderdetailsmapper;
	@Override
	public List<Orderdetails> selectAll(OrderdetailsExample example) {
		return orderdetailsmapper.selectByExample(example);
		 
	}

	@Override
	public Orderdetails selectById(OrderdetailsKey oid) {
		return orderdetailsmapper.selectByPrimaryKey(oid);
	}

	@Override
	public int deleteOrderdetailsById(OrderdetailsKey oid) {
		return orderdetailsmapper.deleteByPrimaryKey(oid);
	}

	@Override
	public int insertIntoOrderdetails(Orderdetails record) {
		return orderdetailsmapper.insertSelective(record);
	}

	@Override
	public int updateOrderdetailsById(Orderdetails Orderdetails) {
		return orderdetailsmapper.updateByPrimaryKeySelective(Orderdetails);
	}

}
