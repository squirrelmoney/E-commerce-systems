package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mapper.pojo.Orderdetails;
import com.mapper.pojo.OrderdetailsKey;
import com.service.IOrderdetailsService;

@Controller
@RequestMapping("orderdetailscontroller")
public class OrderdetailsController {
	@Autowired
	private IOrderdetailsService IOrderdetailsService;

	@RequestMapping("selectAllOrderdetails")
	public String selectAllOrderdetails(Model m){
		List<Orderdetails> list=IOrderdetailsService.selectAll(null);
		 m.addAttribute("list",list);
		return "selectOrderdetails";
	}

	@RequestMapping("deleteOrderdetailsById")
	public String deleteOrderdetailsById( OrderdetailsKey key){
		IOrderdetailsService.deleteOrderdetailsById(key);
		return "redirect:/orderdetailscontroller/selectAllOrderdetails.do";
	}

	@RequestMapping("updateOrderdetailsById/{cid}/{oid}")
	public String updateOrderdetailsById(@PathVariable int oid,@PathVariable int cid,Model m){
		OrderdetailsKey key=new OrderdetailsKey();
        key.setCid(cid);
        key.setOid(oid);
		m.addAttribute("list",IOrderdetailsService.selectById(key));
		return "updateOrderdetails";
	}

	@RequestMapping("updateOrderdetails")
	public String updateCommodityById(Model m,Orderdetails Orderdetails){
		IOrderdetailsService.updateOrderdetailsById(Orderdetails);
		return "redirect:/orderdetailscontroller/selectAllOrderdetails.do";
	}


	@RequestMapping("insertIntoOrderdetails")
	public String insertIntoCommodity(Model m){
		return "insertIntoOrderdetails";
	}

	@RequestMapping("insertOrderdetails")
	public String insertIntoOrderdetails(Orderdetails Orderdetails){
		IOrderdetailsService.insertIntoOrderdetails(Orderdetails);
		return "redirect:/orderdetailscontroller/selectAllOrderdetails.do";
	}
	}


