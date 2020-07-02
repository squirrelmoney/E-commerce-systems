package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mapper.pojo.Commodity;
import com.mapper.pojo.Orderdetails;
import com.mapper.pojo.OrderdetailsKey;
import com.mapper.pojo.Orders;
import com.mapper.pojo.User;
import com.mapper.pojo.Userdetails;
import com.service.ICartService;
import com.service.ICommodityService;
import com.service.IOrderdetailsService;
import com.service.IOrdersService;
import com.service.IUserService;
import com.service.IUserdetailsService;
@Controller
@RequestMapping("/CustomerController")
public class CustomerController {
	@Autowired
    private ICommodityService ICommodityService;
    @Autowired
    private ICartService ICartService;
    @Autowired
    private IOrderdetailsService IOrderdetailsService;
    @Autowired
    private IOrdersService IOrdersService;
    @Autowired
    private IUserService IUserService;
    @Autowired
    private IUserdetailsService IUserdetailsService;
	  
    
	@RequestMapping("customerorders")
    public String usertolistOrders(Model m,HttpSession session,String username,User user,Orderdetails orderdetails1){	
		User us = (User) session.getAttribute("user");
//		session.setAttribute("user", us);
		System.out.println("usertolistOrders"+us);
		List<Orders> selectAll= IOrdersService.selectByusernames(us.getUsername());
		 m.addAttribute("list", selectAll);
			 return "CustomerOrders";	      	 
    }
	
		
		//”√ªß
		@RequestMapping("customerorderdetails/{oid}")
	    public String testMode(@PathVariable int oid,Model m){	
		  	     List<Orderdetails>selectAll=IOrderdetailsService.selectByoid(oid);
				 m.addAttribute("list", selectAll);
				 return "CustomerOrderdetails";	      	 
	    }
		
		
	    @RequestMapping("Customerdetails")
	    public String tolistUser(Model m,HttpSession session,User user){	
			User u=(User) session.getAttribute("user");
			Userdetails Userdetails = IUserdetailsService.selectByPrimaryKey(u.getUsername());
				 m.addAttribute("Userdetails", Userdetails);
				 m.addAttribute("user",u);
				 return "Customerdetails";	    
	    }
	    
	    @RequestMapping("updateUserdetailsById")
	    public String tolistUser(Model m,Userdetails userdetails){
	    	IUserdetailsService.updateByPrimaryKey(userdetails);
				 return "redirect:/rest/CustomerController/Customerdetails";	    
	    }
	    
	    @RequestMapping("updateUserpoints/{oid}/{username}")
	    public String updateUserpoints(Model m,@PathVariable int oid,Orderdetails orderdetails1, @PathVariable String username){
	    	Userdetails uu=IUserdetailsService.selectByPrimaryKey(username); 
	    	List<Orderdetails> list1=IOrderdetailsService.selectByoid(oid);
	    	int q=0;
	        for (Orderdetails u : list1) {
	        	 Commodity cc= ICommodityService.selectByPrimaryKey(u.getCid());
	         	int sum=cc.getPoints();
	         	int nem=u.getNumber();
	         	 q=q+sum*nem;
	         	 System.out.println(q);
			}
	        System.out.println(q);
	    	if(uu.getPoints()==null){
	    		uu.setPoints(q);
	    	}
	    	else{
	    	   uu.setPoints(uu.getPoints()+q);
	    	}
	    	IUserdetailsService.updateByPrimaryKey(uu);
	    	return "redirect:/OrderControl/updateorders1/{oid}";
	    	
	    }
	    
	    
	    @RequestMapping("deleteUser/{username}")
	    public String toEdit(@PathVariable String username,Model m){
	    	IUserService.deleteByPrimaryKey(username);
	    	IUserdetailsService.deleteByPrimaryKey(username);
	  	   List<User> selectAll=IUserService.selectByExample(null);	   
			 m.addAttribute("list", selectAll);
			 return "redirect:/rest/AdminController/AllUser";
	    }
}
