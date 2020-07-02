package com.service;

import java.util.List;

import com.mapper.pojo.Addresses;
import com.mapper.pojo.AddressesExample;



public interface IAddressesService {
	public List<Addresses> selectAllAddresses(AddressesExample example);
	public List<Addresses> selectByusername(String username);
	public Addresses selectByaId(Integer aid);
	public int insertIntoAddress(Addresses record);
	int deleteAddress(Integer id);
	int updateByPrimaryKeySelective(Addresses record, AddressesExample example);
	List<Addresses> selectByExample(AddressesExample example);
}
