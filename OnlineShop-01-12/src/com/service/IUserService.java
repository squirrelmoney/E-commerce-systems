package com.service;

import java.util.List;

import com.mapper.pojo.User;
import com.mapper.pojo.UserExample;

public interface IUserService {
	User selectByPrimaryKey(String username);
	int deleteByPrimaryKey(String username);
	int insertSelective(User record);
	int updateByPrimaryKeySelective(User record);
	List<User> selectByExample(UserExample example);
	User getUsersByAccNumberPassword(User user);
	int CheckByUsername(String Username);                 //�����˺��жϸ��û��治����
	String getUidByaccNumberPassword(User user);
	User login(String username,String password);
//	int updateByPrimaryKey(String username);
}
