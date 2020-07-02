package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.pojo.Userdetails;
import com.mapper.pojo.UserdetailsExample;
import com.onlineshop.mapper.UserdetailsMapper;
import com.service.IUserdetailsService;


 @Service
public class UserdetailsServiceImpl implements IUserdetailsService {
		@Autowired
		   private UserdetailsMapper UserdetailsMapper;

		
		public int insert(Userdetails record) {
			// TODO Auto-generated method stub
			return UserdetailsMapper.insert(record);
		}

		
		public int insertSelective(Userdetails record) {
			// TODO Auto-generated method stub
			return UserdetailsMapper.insertSelective(record);
		}


		public int deleteByPrimaryKey(String username) {
			// TODO Auto-generated method stub
			return UserdetailsMapper.deleteByPrimaryKey(username);
		}


		public int updateByPrimaryKey(Userdetails record) {
			// TODO Auto-generated method stub
			return UserdetailsMapper.updateByPrimaryKey(record);
		}


		public List<Userdetails> selectByExample(UserdetailsExample example) {
			// TODO Auto-generated method stub
			return UserdetailsMapper.selectByExample(example);
		}


		public Userdetails selectByPrimaryKey(String username) {
			// TODO Auto-generated method stub
			return UserdetailsMapper.selectByPrimaryKey(username);
		}


	 




}
