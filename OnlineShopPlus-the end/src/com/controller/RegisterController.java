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
@RequestMapping("/RegisterController")//加根路径实际上在开发过程中，controller会很多，区分不同controller里面的方法·
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
		    public String Save(User user,Userdetails userdetails, Model model) { // user:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
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
