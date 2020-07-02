package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mapper.pojo.Cart;
import com.mapper.pojo.Commodity;
import com.mapper.pojo.User;
import com.service.ICartService;
import com.service.ICommodityService;
///CommdityController/tolistallCommodity

@Controller
@RequestMapping("/mainHomeController")//加根路径实际上在开发过程中，controller会很多，区分不同controller里面的方法·
public class mainHomeController{
    @Autowired
    private ICartService ICartService;
    @Autowired
    private ICommodityService ICommodityService;
	
  
    //商家
	@RequestMapping("adminhomepage")
    public String testModel(Model m){		
		  List<Commodity> selectAll=ICommodityService.selectByExample(null);	   
			 m.addAttribute("list", selectAll);
			 return "AdminHomepage";	    
   	 
    }
	//普通用户
	@RequestMapping("homepage")
    public String allcommdity(Model m,HttpSession session,User user){	
		  List<Commodity> selectAll=ICommodityService.selectexistinventory();
			 m.addAttribute("list", selectAll);
			 return "Homepage";	    
   	 
    }

	 
    
    

}
