package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.pojo.User;
import com.mapper.pojo.UserExample;
import com.onlineshop.mapper.UserMapper;
import com.service.IUserService;

    @Service
public class UserServiceImpl implements IUserService{
	@Autowired
   private UserMapper userMapper;

	
	public List<User> selectByExample(UserExample example) {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(example);
	}


	
	public int deleteByPrimaryKey(String username) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(username);
	}


	
	public int insert(User record) {
		// TODO Auto-generated method stub
		return userMapper.insert(record);
	}


	

	
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(record);
	}



	
	public User getUsersByAccNumberPassword(User user) {		     
            User user1=new User();
            user1.setUsername(user.getUsername());
            user1.setPassword(user.getPassword());
			List<User>a= userMapper.selectByExample(null);

		 
			for (int i = 0; i < a.size(); i++)
			{
				if (a.get(i).getUsername().equals(user.getUsername()) && a.get(i).getPassword().equals(user.getPassword()))
				{
					
					return a.get(i);
					
				}
			}
			return null;
	}


//	@Override
//	public int selectByname(String name) {
//		// TODO Auto-generated method stub
//		 List<User> list = selectByExample(null);
//		 for (int i = 0; i < list.size(); i++)
//		 {
//			 if (list.get(i).getUsername().equals(name))
//				 return 1;
//		 }
//		 return 0;
//	}


	
	public String getUidByaccNumberPassword(User user) {
		// TODO Auto-generated method stub
		 List<User> list = selectByExample(null);
		 for (int i = 0; i < list.size(); i++)
		 {
			 if (list.get(i).getUsername().equals(user.getUsername()) && list.get(i).getPassword().equals(user.getPassword()))
				 return list.get(i).getUsername();
		 }
		// return "0";
		return null;
	}


	
	public User selectByPrimaryKey(String username) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(username);
	}


	
	public int CheckByUsername(String Username) {
		// TODO Auto-generated method stub
		 List<User> list = selectByExample(null);
		 for (int i = 0; i < list.size(); i++)
		 {
			 if (list.get(i).getUsername().equals(Username))
				 return 1;
		 }
		 return 0;
	}


	
	public User selectByPrimaryKey(User user) {
		// TODO Auto-generated method stub
		return null;
	}



	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return userMapper.findWithLoginAndPassword(username, password);
	}



	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(record);
	}







}
