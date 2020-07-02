package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.pojo.Commodity;
import com.mapper.pojo.CommodityExample;
import com.onlineshop.mapper.CommodityMapper;
import com.service.ICommodityService;
@Service
public class CommodityServiceImpl implements ICommodityService{
    @Autowired
	private CommodityMapper commoditymapper;
	@Override
	public List<Commodity> selectAll(CommodityExample example) {
		return commoditymapper.selectByExample(example);
		 
	}

	@Override
	public Commodity selectById(Integer cid) {
		return commoditymapper.selectByPrimaryKey(cid);
	}

	@Override
	public int deleteCommodityById(Integer cid) {
		return commoditymapper.deleteByPrimaryKey(cid);
	}

	@Override
	public int insertIntoCommodity(Commodity record) {
		return commoditymapper.insertSelective(record);
	}

	@Override
	public int updateCommodityById(Commodity Commodity) {
		return commoditymapper.updateByPrimaryKey(Commodity);
	}

}
