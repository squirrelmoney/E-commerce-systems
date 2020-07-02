package com.service;

import java.util.List;

import com.mapper.pojo.Warehouse;
import com.mapper.pojo.WarehouseExample;
import com.mapper.pojo.WarehouseKey;


public interface IWarehouseService {
	public List<Warehouse> selectAll(WarehouseExample example);
	public Warehouse selectById(WarehouseKey key);
	public List<Warehouse> selectByCId(Integer cid);
	public int deleteWarehouseById(WarehouseKey wid);
	public int insertIntoWarehouse(Warehouse record);
	public int updateWarehouseById(Warehouse record);
}
