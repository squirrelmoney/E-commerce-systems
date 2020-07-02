package com.onlineshop.mapper;

import com.mapper.pojo.Profit;
import com.mapper.pojo.ProfitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProfitMapper {
    int countByExample(ProfitExample example);

    int deleteByExample(ProfitExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Profit record);

    int insertSelective(Profit record);

    List<Profit> selectByExample(ProfitExample example);

    Profit selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Profit record, @Param("example") ProfitExample example);

    int updateByExample(@Param("record") Profit record, @Param("example") ProfitExample example);

    int updateByPrimaryKeySelective(Profit record);

    int updateByPrimaryKey(Profit record);
}