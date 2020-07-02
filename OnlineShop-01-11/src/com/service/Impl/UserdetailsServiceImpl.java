package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.pojo.Userdetails;
import com.mapper.pojo.UserdetailsExample;
import com.onlineshop.mapper.UserdetailsMapper;
import com.service.IUserdetailsService;
@Service
public class UserdetailsServiceImpl implements IUserdetailsService{
	@Autowired
	private UserdetailsMapper userdetailsmapper;
	@Override
	public List<Userdetails> selectAll(UserdetailsExample example) {
		return userdetailsmapper.selectByExample(example);
	}

	@Override
	public Userdetails selectById(String username) {
		return userdetailsmapper.selectByPrimaryKey(username);
	}

	@Override
	public int deleteUserdetailsById(String username) {
		return userdetailsmapper.deleteByPrimaryKey(username);
	}

	@Override
	public int insertIntoUserdetails(Userdetails record) {
		return userdetailsmapper.insertSelective(record);
	}

	@Override
	public int updateUserdetailsById(Userdetails record) {
		return userdetailsmapper.updateByPrimaryKeySelective(record);
	}

}
