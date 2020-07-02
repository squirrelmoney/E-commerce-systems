package com.service;

import java.util.List;

import com.mapper.pojo.Userdetails;
import com.mapper.pojo.UserdetailsExample;


public interface IUserdetailsService {
	public List<Userdetails> selectAll(UserdetailsExample example);
	public Userdetails selectById(String username);
	public int deleteUserdetailsById(String username);
	public int insertIntoUserdetails(Userdetails record);
	public int updateUserdetailsById(Userdetails record);
}
