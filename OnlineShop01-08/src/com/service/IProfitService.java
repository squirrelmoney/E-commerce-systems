package com.service;

import java.util.List;

import com.mapper.pojo.Profit;
import com.mapper.pojo.ProfitExample;


public interface IProfitService {
	public List<Profit> selectAll(ProfitExample example);
	public Profit selectById(Integer cid);
	public int deletePrifitById(Integer cid);
	public int insertIntoPrifit(Profit record);
	public int updatePrifitById(Profit record);
}
