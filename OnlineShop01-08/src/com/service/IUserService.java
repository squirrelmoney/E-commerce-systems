package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mapper.pojo.User;
import com.mapper.pojo.UserExample;

public interface IUserService {
	public List<User> selectAll(UserExample example);

	public User selectById(String username);

	public int deleteUserById(String username);

	public int insertIntoUser(User record);

	public int updateUserById(User username);

}
