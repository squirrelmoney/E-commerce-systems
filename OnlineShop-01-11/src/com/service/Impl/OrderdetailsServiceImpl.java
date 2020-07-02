package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mapper.pojo.Orderdetails;
import com.mapper.pojo.OrderdetailsExample;
import com.mapper.pojo.OrderdetailsKey;
import com.onlineshop.mapper.OrderdetailsMapper;
import com.onlineshop.mapper.OrdersMapper;
import com.service.IOrderdetailsService;
@Service
public class OrderdetailsServiceImpl implements IOrderdetailsService{
	@Autowired
    private OrderdetailsMapper orderdetailsmapper;
	@Autowired
    private OrdersMapper ordersmapper;
	@Override
	public List<Orderdetails> selectAll(OrderdetailsExample example) {
		return orderdetailsmapper.selectByExample(example);
		 
	}

	@Override
	public Orderdetails selectBykey(OrderdetailsKey key) {
		
		return orderdetailsmapper.selectByPrimaryKey(key);
	}

	@Override
	public int deleteOrderdetailsBykey(OrderdetailsKey key) {
		return orderdetailsmapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insertIntoOrderdetails(Orderdetails record) {
			return orderdetailsmapper.insertSelective(record);
		
	}

	@Override
	public int updateOrderdetailsById(Orderdetails Orderdetails) {
		return orderdetailsmapper.updateByPrimaryKeySelective(Orderdetails);
	}

	@Override
	public List<Orderdetails> selectByoId(Integer oid) {
		// TODO Auto-generated method stub
		return orderdetailsmapper.selectByOid(oid);
	}

}
