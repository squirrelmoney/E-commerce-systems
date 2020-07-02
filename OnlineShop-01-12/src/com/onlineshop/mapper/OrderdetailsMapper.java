package com.onlineshop.mapper;

import com.mapper.pojo.Orderdetails;
import com.mapper.pojo.OrderdetailsExample;
import com.mapper.pojo.OrderdetailsKey;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrderdetailsMapper {
    int countByExample(OrderdetailsExample example);

    int deleteByExample(OrderdetailsExample example);

    int deleteByPrimaryKey(OrderdetailsKey key);

    int insert(Orderdetails record);

    int insertSelective(Orderdetails record);

    List<Orderdetails> selectByExample(OrderdetailsExample example);

    Orderdetails selectByPrimaryKey(OrderdetailsKey key);

    int updateByExampleSelective(@Param("record") Orderdetails record, @Param("example") OrderdetailsExample example);

    int updateByExample(@Param("record") Orderdetails record, @Param("example") OrderdetailsExample example);

    int updateByPrimaryKeySelective(Orderdetails record);

    int updateByPrimaryKey(Orderdetails record);

	List<Orderdetails> selectByOid(Integer oid);
	
	int deleteByoid(int oid);//ʫ

}