package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mapper.pojo.Cart;
import com.mapper.pojo.Commodity;
import com.mapper.pojo.User;
import com.mapper.pojo.Userdetails;
import com.service.ICommodityService;
import com.service.IUserService;
@Controller
@RequestMapping("/LoginController")
public class LoginController {
	@Autowired 
	public static List<Cart> cart = new ArrayList<Cart>();
    @Autowired  
    private IUserService IUserService;
    @Autowired
    private ICommodityService ICommodityService;
   
    public static User users = new User();
        
       @RequestMapping("Loginuser")
       public String Login(Model model) { 
    	   return "login";
       }
       
       @RequestMapping("test")
       public @ResponseBody User test(@RequestBody User user){
    	return IUserService.selectByPrimaryKey(user.getUsername());
       }
       
       @RequestMapping("selectUser")
       public String selectUser(String username,String password,User user, Model model,HttpSession session,HttpSession session1) { // user:视图层传给控制层的表单对象；model：控制层返回给视图层的对象       	     	   
    	   if (IUserService.getUsersByAccNumberPassword(user)!=null) {  		    		  
   			User u1 = IUserService.getUsersByAccNumberPassword(user);
   			session.setAttribute("user", u1);
   			 session1.setAttribute("username", u1.getUsername());

   			if (u1.getAuthority()==1){  				
   				return "redirect:/rest/mainHomeController/homepage";
   			} 
   			 else if (u1.getAuthority()==2) {
   			 List<Commodity> selectAll=ICommodityService.selectByExample(null);	
   			 model.addAttribute("list", selectAll);
   			 return "redirect:/rest/mainHomeController/adminhomepage";
   				
   		    } 
   			else {
   			System.out.println("登录失败！");
   		    }
   		}
    	   return "redirect:/rest/LoginController/Loginuser";
   	  }
       	
       
       /**
        * 处理/login请求
        */
       @RequestMapping("exit")
       public String login(HttpSession session,User user){   
          return "redirect:/rest/LoginController/backtopage";
       }
       

       @RequestMapping("backtopage")
       public String login11(HttpSession session,User user){   
    	   session.setAttribute("user", null);  	   
           return "redirect:/rest/LoginController/Loginuser";
       }
}
