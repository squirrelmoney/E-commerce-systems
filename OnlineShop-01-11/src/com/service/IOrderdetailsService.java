package com.service;

import java.util.List;

import com.mapper.pojo.Orderdetails;
import com.mapper.pojo.OrderdetailsExample;
import com.mapper.pojo.OrderdetailsKey;
import com.onlineshop.mapper.OrderdetailsMapper;

public interface IOrderdetailsService {
	
		public List<Orderdetails> selectAll(OrderdetailsExample example);
		public Orderdetails selectBykey(OrderdetailsKey key);
		public int deleteOrderdetailsBykey(OrderdetailsKey key);
		public int insertIntoOrderdetails(Orderdetails record);
		public int updateOrderdetailsById(Orderdetails Orderdetails);
		public List<Orderdetails> selectByoId(Integer oid);

}
