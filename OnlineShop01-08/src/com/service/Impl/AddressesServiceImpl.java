package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.pojo.Addresses;
import com.mapper.pojo.AddressesExample;
import com.onlineshop.mapper.AddressesMapper;
import com.service.IAddressesService;

@Service
public class AddressesServiceImpl implements IAddressesService {
@Autowired
private AddressesMapper Addressesmapper;
	@Override
	public List<Addresses> selectAllAddresses(AddressesExample example) {
		return Addressesmapper.selectByExample(example);
	}

	@Override
	public List<Addresses> selectById(String username) {
		return Addressesmapper.selectByAddressesId(username);
	}

	@Override
	public int deleteAddress(int id) {
		return Addressesmapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertIntoAddress(Addresses record) {
		return Addressesmapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Addresses record,AddressesExample example) {
		return Addressesmapper.updateByPrimaryKeySelective(record);
	}



}
