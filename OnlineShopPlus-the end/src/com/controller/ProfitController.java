package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mapper.pojo.Commodity;
import com.mapper.pojo.Orderdetails;
import com.mapper.pojo.Orders;
import com.mapper.pojo.Profit;
import com.service.ICartService;
import com.service.ICommodityService;
import com.service.IOrderdetailsService;
import com.service.IOrdersService;
import com.service.IProfitService;


@Controller
@RequestMapping("ProfitController")
public class ProfitController {
	@Autowired
    private ICommodityService ICommodityService;
    @Autowired
    private IOrderdetailsService IOrderdetailsService;
    @Autowired
    private IOrdersService IOrdersService;
    @Autowired
    private IProfitService IProfitService;
    
    
    
    
    @RequestMapping("Profitadd/{oid}")
    public String profit(Model m,Orderdetails orderdetails1,Orders orders1,RedirectAttributes r,HttpSession session,@PathVariable int oid){ 	
    	List<Orderdetails>op=IOrderdetailsService.selectByoid(oid);
    	Profit pro=new Profit(); 
    	
    	 for (Orderdetails u : op) {
    		 Commodity com=ICommodityService.selectByPrimaryKey(u.getCid());
    	    	int priceadd=com.getPrice()*u.getNumber();
    	    	int costadd=com.getCost()*u.getNumber();
    	    	pro.setCid(u.getCid());
    	    	Profit proselect=IProfitService.selectByPrimaryKey(u.getCid());
    	    	if(proselect==null){
    	        	pro.setIncome(priceadd);
    	        	pro.setCost(costadd);
    	        	IProfitService.insertSelective(pro);
    	    	}
    	    	else{
    	    		int priceadd1=proselect.getIncome()+priceadd;
    	    		int costadd1=proselect.getCost()+costadd;
    	    		pro.setIncome(priceadd1);
    	    		pro.setCost(costadd1);
    	    		IProfitService.updateByPrimaryKeySelective(pro);
    	    	}    	
    	 }
    	   	
		return "redirect:/OrderControl/usertolistOrders";
    	
    }
    
    @RequestMapping("selectProfit")
    public String selectProfit(Model m) {
    	 List<Profit> selectAll=IProfitService.selectByExample(null);	
		 m.addAttribute("list", selectAll);
		 return "ListProfit";
	}
    
    @RequestMapping("deleprofit/{cid}")
    public String deleprofit(Model m,@PathVariable int cid){
    	IProfitService.deleteByPrimaryKey(cid);
		return "redirect:/ProfitController/selectProfit";
    	
    }
    
    
    
}
