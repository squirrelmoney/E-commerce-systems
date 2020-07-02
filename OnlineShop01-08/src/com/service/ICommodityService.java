package com.service;

import java.util.List;

import com.mapper.pojo.Commodity;
import com.mapper.pojo.CommodityExample;


public interface ICommodityService {
	public List<Commodity> selectAll(CommodityExample example);
	public Commodity selectById(Integer cid);
	public int deleteCommodityById(Integer cid);
	public int insertIntoCommodity(Commodity record);
	public int updateCommodityById(Commodity Commodity);
}
