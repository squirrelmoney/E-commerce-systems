package com.service;

import java.util.List;

import com.mapper.pojo.Commodity;
import com.mapper.pojo.CommodityExample;

public interface ICommodityService {
	Commodity selectByPrimaryKey(Integer cid);
	List<Commodity> selectByExample(CommodityExample example);
	int insertSelective(Commodity record);
	int deleteByPrimaryKey(Integer cid);
	int updateByPrimaryKeySelective(Commodity record);
	List<Commodity> selectexistinventory();
}
