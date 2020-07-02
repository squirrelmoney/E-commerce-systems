package com.onlineshop.mapper;

import com.mapper.pojo.Warehouse;
import com.mapper.pojo.WarehouseExample;
import com.mapper.pojo.WarehouseKey;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WarehouseMapper {
    int countByExample(WarehouseExample example);

    int deleteByExample(WarehouseExample example);

    int deleteByPrimaryKey(WarehouseKey key);

    int insert(Warehouse record);

    int insertSelective(Warehouse record);

    List<Warehouse> selectByExample(WarehouseExample example);

    Warehouse selectByPrimaryKey(WarehouseKey key);

    int updateByExampleSelective(@Param("record") Warehouse record, @Param("example") WarehouseExample example);

    int updateByExample(@Param("record") Warehouse record, @Param("example") WarehouseExample example);

    int updateByPrimaryKeySelective(Warehouse record);

    int updateByPrimaryKey(Warehouse record);

	List<Warehouse> selectByCid(Integer cid);


}