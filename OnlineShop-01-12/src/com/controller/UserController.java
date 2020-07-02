package com.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mapper.pojo.User;
import com.service.IUserService;

@Controller
@RequestMapping("UserController")
public class UserController 
{
	@Autowired
	private IUserService IUserService;
	
	@RequestMapping("selectUser.do")
	public String getAll(Model m)
	{
		List<User> list = IUserService.selectByExample(null);
		m.addAttribute("list", list);
		return "AllUser";
	}
	
	@RequestMapping("login.do")
	public String login()
	{
		return "login";
	}	
	
	@RequestMapping("function.do")
	public String function()
	{
		return "function";
	}	
	
	
	@RequestMapping("selectByUsername.do")
	public String selectByUsername(HttpServletRequest request,String username)
	{
		HttpSession session = request.getSession();
		User user = IUserService.selectByPrimaryKey(username);
		session.setAttribute("user", user);
		if(user.getAuthority()==2)
			return "redirect:function.do";
		else if(user.getAuthority()==1)
			return "redirect:/CommodityController/UserCommodity.do";
		else
			return "redirect:register.do";
	}
	
	@RequestMapping("insertUser.do")
	public String insertUser()
	{
		return "insertUser";
	}
	
	@RequestMapping("insert.do")
	public String insert(User u)
	{
		IUserService.insertSelective(u);
		return "redirect:selectUser.do";
	}
	
	@RequestMapping("updateUser.do")
	public String updateUser(Model m,User u)
	{
		m.addAttribute("user", u);
		return "updateUser";
	}
	
	@RequestMapping("update.do")
	public String updateUser(User u)
	{
		IUserService.updateByPrimaryKeySelective(u);
		return "redirect:selectUser.do";
	}	
	
	@RequestMapping("register.do")
	public String register()
	{
		return "register";
	}
	
	@RequestMapping("registerUser.do")
	public String registerUser(User record)
	{
		IUserService.insertSelective(record);
		return "redirect:login.do";
	}	

	@RequestMapping("checkusername")
	public void checkusername(HttpServletRequest request,String username,PrintWriter out)
	{
		System.out.println(username);
		User user = IUserService.selectByPrimaryKey(username);
		System.out.println(user);
		if(user!=null)
		{
			String flag="{\"flag\":\"0\"}";
			System.out.println(flag);
			out.print(flag);
		}
	}
}
