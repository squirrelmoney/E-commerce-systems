package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mapper.pojo.User;
import com.service.IUserService;
@Controller
@RequestMapping("logincontroller")
public class LoginController {
	@Autowired//获取userservice的方法
	 private IUserService userservice ;
	
	@RequestMapping("register")
	public String InsertUser(){
	   return "register";
	}
	
	@RequestMapping("InsertUser")
     public String InsertUser(User record,Model m){
    	  int i=userservice.insertIntoUser(record);
    	  if(i!=0){
    		  return "";//商品页面
    	  }
    	  else{
    		  return "error";
    	  }
    	  
     }
	
	
	@RequestMapping("login")
	 public String login()
		{
			return "login";
		 }
		
	@RequestMapping("proving")
	 public String selectById( String username, String password,Model m)
	{
		 User u=userservice.selectById(username);
		 if(u!=null&&u.getPassword().equals(password)){
			 m.addAttribute("user",u);
			 if(u.getAuthority()==1)
			 return "userdeatils";//商品页
			 else if(u.getAuthority()==2)
				 return "";//管理员页面
		 }
		return "login";
	 }
}
