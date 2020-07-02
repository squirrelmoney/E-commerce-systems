package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mapper.pojo.Commodity;
import com.mapper.pojo.User;
import com.mapper.pojo.Userdetails;
import com.service.ICommodityService;
import com.service.IUserService;
import com.service.IUserdetailsService;


@Controller
@RequestMapping("/RegisterController")//�Ӹ�·��ʵ�����ڿ��������У�controller��ܶ࣬���ֲ�ͬcontroller����ķ�����
public class RegisterController {

    @Autowired
    private IUserService IUserservice;
    @Autowired
    private IUserdetailsService IUserdetailsservice; 

    @Autowired
    private ICommodityService Comm;
    
		 @RequestMapping("Register")
		    public String Create(Model model) { 
		        return "insertUser";
		    }
		 
		    @RequestMapping("saveUser")
		    public String Save(User user,Userdetails userdetails, Model model) { // user:��ͼ�㴫�����Ʋ�ı�����model�����Ʋ㷵�ظ���ͼ��Ķ���
		    	model.addAttribute("user", user);
		    	model.addAttribute("userdetails",userdetails); 
		    	user.setAuthority(1);
		    	IUserservice.insert(user);
		    	IUserdetailsservice.insert(userdetails);
		        List<Commodity> selectAll=Comm.selectByExample(null);	
				 model.addAttribute("list", selectAll);
				 return "redirect:/rest/LoginController/Loginuser";
		    	
		    }
	
}
