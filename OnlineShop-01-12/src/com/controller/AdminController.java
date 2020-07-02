package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mapper.pojo.Commodity;
import com.mapper.pojo.Orderdetails;
import com.mapper.pojo.Orders;
import com.mapper.pojo.Profit;
import com.mapper.pojo.User;
import com.mapper.pojo.Userdetails;
import com.service.ICartService;
import com.service.ICommodityService;
import com.service.IOrderdetailsService;
import com.service.IOrdersService;
import com.service.IProfitService;
import com.service.IUserService;
import com.service.IUserdetailsService;

@Controller//获取当前类对象
@RequestMapping("AdminController")
public class AdminController {
	@Autowired//获取userservice的方法
	 private IUserService IUserService ;
    @Autowired
    private ICartService ICartService;
    @Autowired
    private ICommodityService ICommodityService;
    @Autowired
    private IOrderdetailsService IOrderdetailsService;
    @Autowired
    private IOrdersService IOrdersService;
    @Autowired
    private IProfitService IProfitService;
    @Autowired
    private IUserdetailsService IUserdetailsService;
	  //插入商品
    @RequestMapping("insertCommdity")
    public String insertCommdity(Model model) { 
        return "insertCommdity";
    }
    
     
    @RequestMapping("saveCommndity")
    public String Save(Commodity Commodity, Model model) { // user:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
    	model.addAttribute("Commdity", Commodity);
    	ICommodityService.insertSelective(Commodity);
	    List<Commodity> selectAll=ICommodityService.selectByExample(null);	
		 model.addAttribute("list", selectAll);
		 return "redirect:/rest/mainHomeController/adminhomepage";
    	
    }
	
    
    @RequestMapping("selectProfit")
    public String selectProfit(Model m) {
    	 List<Profit> selectAll=IProfitService.selectByExample(null);	
		 m.addAttribute("list", selectAll);
		 return "ListProfit";
	}
    
    @RequestMapping("selectAllWarehouse")
	public String selectAllIWarehouse(Model m){
		return "selectWarehouse";
	}
    
    
    
    @RequestMapping("AllOrderDetails")
	public String deliverOrderDetails(Model m){
		 m.addAttribute("Orderdetails",IOrderdetailsService.selectByExample(null));
		 m.addAttribute("Orders",IOrdersService.selectByExample(null));
		 m.addAttribute("Commodity",ICommodityService.selectByExample(null));
		return "AllOrderDetails";
	}
    
    

	@RequestMapping("AllUser")
    public String testModel(Model m){		
		  List<com.mapper.pojo.User> selectAll=IUserService.selectByExample(null);	   
			 m.addAttribute("list", selectAll);
			 return "AllUser";	    
   	 
    }
	
	

	
	
    @RequestMapping("deleteCommodity/{cid}")
    public String toEdit(@PathVariable int cid,Model m){
    	ICommodityService.deleteByPrimaryKey(cid);
  	   List<Commodity> selectAll=ICommodityService.selectByExample(null);
		 m.addAttribute("list", selectAll);
		 return "redirect:/rest/mainHomeController/adminhomepage";
    }
    
    
    @RequestMapping("updateCommodity/{cid}")
    public String toEdit11(@PathVariable int cid,Model m){ 
    	m.addAttribute("Commodity", ICommodityService.selectByPrimaryKey(cid)); 
		return "updateCommodity";
    }
    
    
    @RequestMapping("updateCommodity")
    public String updateuser(Model m,Commodity commodity){    	
    	ICommodityService.updateByPrimaryKeySelective(commodity);
    	return "redirect:/rest/mainHomeController/adminhomepage";
    	
    }
    
    @RequestMapping("updateUser/{username}")
    public String toEdit11(@PathVariable String username,Model m){ 
    	m.addAttribute("user", IUserService.selectByPrimaryKey(username));  
    	m.addAttribute("userdetails", IUserdetailsService.selectByPrimaryKey(username)); 
		 return "AdminupdateUser";
    }
    
    @RequestMapping("updatingUser")
    public String updateuser(Model m,User user,Userdetails userdetails){    	
    	IUserService.updateByPrimaryKeySelective(user);
    	IUserdetailsService.updateByPrimaryKey(userdetails);
    	return "redirect:/rest/AdminController/AllUser";
    	
    }
    
    @RequestMapping("insertUser")
    public String insertUser(Model model) { 
        return "insertUser";
    }
    
     
    @RequestMapping("saveUser")
    public String Save(User user,Userdetails userdetails, Model model) { // user:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
    	model.addAttribute("user", user);
    	model.addAttribute("userdetails",userdetails); 
    	user.setAuthority(1);
    	IUserService.insertSelective(user);
    	IUserdetailsService.insert(userdetails);
	    List<User> selectAll=IUserService.selectByExample(null);	   
		 model.addAttribute("list", selectAll);
		 return "redirect:/rest/AdminController/AllUser";
    	
    }
    

}
