package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.IUserService;

@Controller//��ȡ��ǰ�����
@RequestMapping("admincontroller")
public class AdminController {
	@Autowired//��ȡuserservice�ķ���
	 private IUserService userservice ;
	@RequestMapping("selectAllUser")
	 public String selectAll(Model m){
		 m.addAttribute("list", userservice.selectAll(null));
		 return "selectUser";
	 }
	
/*	@RequestMapping("deleteUserById")//*.do
	 public String deleteUserById(String username,Model m){
		  userservice.deleteUserById(username);
		 return "redirect:usercontroller.selectAll.do";
		  
	 }*/
	
}
