package com.onlineshop.mapper;

import com.mapper.pojo.Addresses;
import com.mapper.pojo.AddressesExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AddressesMapper {
    int countByExample(AddressesExample example);
    
    List<Addresses> selectByAddressesId(String username);
    
    List<Addresses> selectByExample(AddressesExample example);
    
    int deleteByExample(AddressesExample example);
    
    int deleteByrecord(Addresses record);
    
    int insert(Addresses record);

    int insertSelective(Addresses record);

    int updateByExampleSelective(@Param("record") Addresses record, @Param("example") AddressesExample example);

    int updateByExample(@Param("record") Addresses record, @Param("example") AddressesExample example);
}