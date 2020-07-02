package com.service;

import java.util.List;

import com.mapper.pojo.Addresses;
import com.mapper.pojo.AddressesExample;



public interface IAddressesService {
	public List<Addresses> selectAllAddresses(AddressesExample example);
	public List<Addresses> selectById(String username);
	public int deleteAddress(Addresses record);
	public int insertIntoAddress(Addresses record);
	public int updateByExample(Addresses record,AddressesExample example);
}
