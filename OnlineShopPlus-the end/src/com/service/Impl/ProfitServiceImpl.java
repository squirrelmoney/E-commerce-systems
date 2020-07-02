package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.pojo.Profit;
import com.mapper.pojo.ProfitExample;
import com.onlineshop.mapper.ProfitMapper;
import com.service.IProfitService;
@Service
public class ProfitServiceImpl implements IProfitService {
	@Autowired
	private ProfitMapper ProfitMapper;

	public int insertSelective(Profit record) {
		// TODO Auto-generated method stub
		return ProfitMapper.insert(record);
	}

	public List<Profit> selectByExample(ProfitExample example) {
		// TODO Auto-generated method stub
		return ProfitMapper.selectByExample(example);
	}

	public Profit selectByPrimaryKey(Integer cid) {
		// TODO Auto-generated method stub
		return ProfitMapper.selectByPrimaryKey(cid);
	}

	public int updateByPrimaryKeySelective(Profit record) {
		// TODO Auto-generated method stub
		return ProfitMapper.updateByPrimaryKeySelective(record);
	}

	public int deleteByPrimaryKey(Integer cid) {
		// TODO Auto-generated method stub
		return ProfitMapper.deleteByPrimaryKey(cid);
	}

}
