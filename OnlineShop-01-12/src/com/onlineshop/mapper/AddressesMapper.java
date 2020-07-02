package com.onlineshop.mapper;

import com.mapper.pojo.Addresses;
import com.mapper.pojo.AddressesExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AddressesMapper {
    int countByExample(AddressesExample example);

    int deleteByExample(AddressesExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Addresses record);

    int insertSelective(Addresses record);

    List<Addresses> selectByExample(AddressesExample example);

    Addresses selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Addresses record, @Param("example") AddressesExample example);

    int updateByExample(@Param("record") Addresses record, @Param("example") AddressesExample example);

    int updateByPrimaryKeySelective(Addresses record);

    int updateByPrimaryKey(Addresses record);

	Addresses selectByaId(Integer aid);

	List<Addresses> selectByusername(String username);
}