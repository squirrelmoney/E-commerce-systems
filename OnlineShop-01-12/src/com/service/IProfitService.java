package com.service;

import java.util.List;

import com.mapper.pojo.Profit;
import com.mapper.pojo.ProfitExample;

public interface IProfitService {
	int insertSelective(Profit record);

    List<Profit> selectByExample(ProfitExample example);
    
    Profit selectByPrimaryKey(Integer cid);
    
    int updateByPrimaryKeySelective(Profit record);
    
    int deleteByPrimaryKey(Integer cid);
}
