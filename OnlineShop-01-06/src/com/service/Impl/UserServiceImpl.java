package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.pojo.User;
import com.mapper.pojo.UserExample;
import com.onlineshop.mapper.UserMapper;
import com.service.IUserService;
@Service//��ȡ��ǰ��Ķ���,ע����Ϊ��IOC(����ע��)����spring����������
public class UserServiceImpl implements IUserService{

	@Autowired//��ȡUsermapper���������
    private UserMapper Usermapper;
	@Override
	public List<User> selectAll(UserExample example) {
		return Usermapper.selectByExample(example);
	}
	@Override
	public User selectById(String username) {
		return Usermapper.selectByPrimaryKey(username);
		}
	
	@Override
	public int deleteUserById(String username) {
		return Usermapper.deleteByPrimaryKey(username);
	}
	@Override
	public int insertIntoUser(User record) {
		return Usermapper.insertSelective(record);
	}

	@Override
	public int updateUserById(User user) {
		return Usermapper.updateByPrimaryKeySelective(user);
	}

	


}
