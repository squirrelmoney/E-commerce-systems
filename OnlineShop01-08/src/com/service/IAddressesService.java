package com.service;

import java.util.List;

import com.mapper.pojo.Addresses;
import com.mapper.pojo.AddressesExample;



public interface IAddressesService {
	public List<Addresses> selectAllAddresses(AddressesExample example);
	public List<Addresses> selectById(String username);
	public int insertIntoAddress(Addresses record);
	int deleteAddress(int id);
	int updateByPrimaryKeySelective(Addresses record, AddressesExample example);
}
