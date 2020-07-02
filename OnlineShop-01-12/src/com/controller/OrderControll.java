package com.controller;

import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mapper.pojo.Cart;
import com.mapper.pojo.CartKey;
import com.mapper.pojo.Commodity;
import com.mapper.pojo.OrderdetailsKey;
import com.mapper.pojo.User;
import com.mapper.pojo.Userdetails;
import com.mapper.pojo.Orders;
import com.mapper.pojo.Orderdetails;
import com.onlineshop.mapper.OrdersMapper;
import com.service.ICartService;
import com.service.ICommodityService;
import com.service.IOrderdetailsService;
import com.service.IOrdersService;

@Controller
@RequestMapping("/OrderControl")
public class OrderControll {
	@Autowired
    private ICommodityService ICommodityService;
    @Autowired
    private ICartService ICartService;
    @Autowired
    private IOrderdetailsService IOrderdetailsService;
    @Autowired
    private IOrdersService IOrdersService;
    
    
    
   @RequestMapping("updateordersTest")
   public String toEdit11(@RequestParam(value = "cid")int  cid,@RequestParam(value = "oid")int  oid,Model m,HttpSession session,User user){ 	     
		User us = (User) session.getAttribute("user");
		session.setAttribute("user", us);	   
	   m.addAttribute("orders", IOrdersService.selectByPrimaryKey(oid));
  	   OrderdetailsKey key=new OrderdetailsKey();
  	   key.setCid(cid);
  	   key.setOid(oid);  	 
	   m.addAttribute("orderdetails", IOrderdetailsService.selectByPrimaryKey(key));
	   return "updateorders";
  } 
   
  @RequestMapping("updateorders11/{oid}")
   public String updateuser(Model m,Orderdetails orderdetails1,Orders orders1,HttpSession session,int oid,User user){ 
	  IOrderdetailsService.updateByPrimaryKeySelective(orderdetails1);
		User us = (User) session.getAttribute("user");
		session.setAttribute("user", us);
	    return "redirect:/OrderControl/usertolistOrders";
  	
  }
  
  
   //用户确认收货 
  @RequestMapping("updateorders1/{oid}")
  public String updateorders1(@PathVariable int oid){ 
	 
	    Orders oo =IOrdersService.selectByPrimaryKey(oid);
	    oo.setStatus(3);
	    IOrdersService.updateByPrimaryKey(oo);
	    return "redirect:/ProfitController/Profitadd/{oid}";
 	
 }
  
  

	


 
    @RequestMapping("deleteOrders/{oid}")
    public String toEdit(@PathVariable int oid,Model m){
    	IOrdersService.deleteByPrimaryKey(oid);
    	IOrderdetailsService.deleteByPrimaryoid(oid);
		 return "redirect:/CustomerController/customerorderdetails";
    }


    

    
    
    
    
    
    
    
}
