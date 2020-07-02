package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.pojo.Commodity;
import com.mapper.pojo.Orderdetails;
import com.mapper.pojo.OrderdetailsExample;
import com.mapper.pojo.OrderdetailsKey;
import com.mapper.pojo.Orderdetailst;
import com.onlineshop.mapper.OrderdetailsMapper;
import com.service.IOrderdetailsService;
@Service
public class OrderdetailsServiceImpl implements IOrderdetailsService {
	@Autowired
private OrderdetailsMapper OrderdetailsMapper;
	
	public int insert(Orderdetails record) {
		// TODO Auto-generated method stub
		return OrderdetailsMapper.insert(record);
	}

	public List<Orderdetails> selectByExample(OrderdetailsExample example) {
		// TODO Auto-generated method stub
		return OrderdetailsMapper.selectByExample(example);
	}

	public Orderdetails selectByPrimaryKey(OrderdetailsKey key) {
		// TODO Auto-generated method stub
		return OrderdetailsMapper.selectByPrimaryKey(key);
	}

	public int updateByPrimaryKeySelective(Orderdetails record) {
		// TODO Auto-generated method stub
		return OrderdetailsMapper.updateByPrimaryKeySelective(record);
	}

	public List<Orderdetails> selectByoid(int oid) {
		// TODO Auto-generated method stub
		return OrderdetailsMapper.selectByOid(oid);
	}

	public int deleteByPrimaryoid(int oid) {
		// TODO Auto-generated method stub
		return OrderdetailsMapper.deleteByoid(oid);
	}

	@Override
	public int insertSelective(Orderdetails record) {
		// TODO Auto-generated method stub
		return OrderdetailsMapper.insertSelective(record);
	}

	@Override
	public int updateByoid(Orderdetailst a) {
		// TODO Auto-generated method stub
		return OrderdetailsMapper.updateByoid(a);
	}





}
