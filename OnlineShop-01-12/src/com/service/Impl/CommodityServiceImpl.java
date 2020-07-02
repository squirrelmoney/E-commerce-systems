package com.service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.pojo.Commodity;
import com.mapper.pojo.CommodityExample;
import com.onlineshop.mapper.CommodityMapper;
import com.service.ICommodityService;
@Service
public class CommodityServiceImpl implements ICommodityService {

	@Autowired
	 private CommodityMapper CommodityMapper;
	

	
	@Override
	public List<Commodity> selectexistinventory() {
		// TODO Auto-generated method stub
		return CommodityMapper.selectexistinventory();
	}


	@Override
	public Commodity selectByPrimaryKey(Integer cid) {
		// TODO Auto-generated method stub
		return CommodityMapper.selectByPrimaryKey(cid);
	}


	@Override
	public List<Commodity> selectByExample(CommodityExample example) {
		// TODO Auto-generated method stub
		return CommodityMapper.selectByExample(example);
	}


	@Override
	public int insertSelective(Commodity record) {
		// TODO Auto-generated method stub
		return CommodityMapper.insertSelective(record);
	}


	@Override
	public int deleteByPrimaryKey(Integer cid) {
		// TODO Auto-generated method stub
		return CommodityMapper.deleteByPrimaryKey(cid);
	}


	@Override
	public int updateByPrimaryKeySelective(Commodity record) {
		// TODO Auto-generated method stub
		return CommodityMapper.updateByPrimaryKeySelective(record);
	}




}
