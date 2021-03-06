package com.service;

import java.util.List;

import com.mapper.pojo.Commodity;
import com.mapper.pojo.Orderdetails;
import com.mapper.pojo.OrderdetailsExample;
import com.mapper.pojo.OrderdetailsKey;
import com.mapper.pojo.Orderdetailst;



public interface IOrderdetailsService {
	int insert(Orderdetails record);
	List<Orderdetails> selectByExample(OrderdetailsExample example);
	Orderdetails selectByPrimaryKey(OrderdetailsKey key);
	int updateByPrimaryKeySelective(Orderdetails record);
	List<Orderdetails> selectByoid(int oid);
	int deleteByPrimaryoid(int oid);
	int insertSelective(Orderdetails record);
	int updateByoid(Orderdetailst a);

}
