package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mapper.pojo.User;
import com.mapper.pojo.Userdetails;
import com.service.IUserService;
import com.service.IUserdetailsService;

@Controller//获取当前类对象
@RequestMapping("usercontroller")
public class UserController {
	
	@Autowired//获取userservice的方法
	 private IUserService userservice ;
	@Autowired
	private IUserdetailsService userdetailsservice;
	
	
	@RequestMapping("modify/{username}")
	 public String  Modification(Model m,@PathVariable String username){
		m.addAttribute("username", username); 
		return "updateUser";
	}
	
	@RequestMapping("updateUser")
	 public String updateUser(Model m,User user){
		 m.addAttribute("list", userservice.updateUserById(user));
		 return "userdeatils";
	 }
	
	@RequestMapping("deleteUserById")//*.do
	 public String deleteUserById(String username,Model m){
		  userservice.deleteUserById(username);
		 return "redirect:/usercontroller/selectAll.do";
	 }
	
	
	
}
