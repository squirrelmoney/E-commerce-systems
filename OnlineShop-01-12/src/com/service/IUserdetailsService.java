package com.service;

import java.util.List;

import com.mapper.pojo.User;
import com.mapper.pojo.Userdetails;
import com.mapper.pojo.UserdetailsExample;

public interface IUserdetailsService {
	int insert(Userdetails record);
	int deleteByPrimaryKey(String username);
	int insertSelective(Userdetails record);
    int updateByPrimaryKey(Userdetails record);
    List<Userdetails> selectByExample(UserdetailsExample example);
 //   int selectByPrimaryKey(String username);
    
    Userdetails selectByPrimaryKey(String username);
}
