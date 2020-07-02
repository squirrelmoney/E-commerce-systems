package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.pojo.Warehouse;
import com.mapper.pojo.WarehouseExample;
import com.mapper.pojo.WarehouseKey;
import com.onlineshop.mapper.WarehouseMapper;
import com.service.IWarehouseService;
@Service
public class WarehouseServiceImpl implements IWarehouseService{
    @Autowired
	private WarehouseMapper warehousemapper;
	@Override
	public List<Warehouse> selectAll(WarehouseExample example) {
		return warehousemapper.selectByExample(example);
	}

	@Override
	public Warehouse selectById(WarehouseKey wid) {
		return warehousemapper.selectByPrimaryKey(wid);
	}
	
	@Override
	public List<Warehouse> selectByCId(Integer cid) {
		return warehousemapper.selectByCid(cid);
	}
	
	@Override
	public int deleteWarehouseById(WarehouseKey wid) {
		return warehousemapper.deleteByPrimaryKey(wid);
	}

	@Override
	public int insertIntoWarehouse(Warehouse record) {
		return warehousemapper.insertSelective(record);
	}

	@Override
	public int updateWarehouseById(Warehouse record) {
		return warehousemapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Warehouse> selectByExample(WarehouseExample example) {
		// TODO Auto-generated method stub
		return warehousemapper.selectByExample(example);
	}



}
