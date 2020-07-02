package com.service.Impl;

import java.util.List;

import org.eclipse.jdt.internal.compiler.problem.ProblemSeverities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.pojo.Profit;
import com.mapper.pojo.ProfitExample;
import com.onlineshop.mapper.ProfitMapper;
import com.service.IProfitService;
@Service
public class ProfitServiceImpl implements IProfitService{
    @Autowired
	private ProfitMapper  profitmapper;
	@Override
	public List<Profit> selectAll(ProfitExample example) {
		return profitmapper.selectByExample(example);
	}

	@Override
	public Profit selectById(Integer cid) {
		return profitmapper.selectByPrimaryKey(cid);
	}

	@Override
	public int deletePrifitById(Integer cid) {
		return profitmapper.deleteByPrimaryKey(cid);
	}

	@Override
	public int insertIntoPrifit(Profit record) {
		return profitmapper.insertSelective(record);
	}

	@Override
	public int updatePrifitById(Profit record) {
		return profitmapper.updateByPrimaryKey(record);
	}

}
