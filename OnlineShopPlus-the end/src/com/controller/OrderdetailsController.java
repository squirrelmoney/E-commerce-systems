package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mapper.pojo.Orderdetails;
import com.mapper.pojo.Orderdetailst;
import com.mapper.pojo.Orders;
import com.mapper.pojo.User;
import com.service.IAddressesService;
import com.service.ICommodityService;
import com.service.IOrderdetailsService;
import com.service.IOrdersService;
import com.service.IWarehouseService;
@Controller
@RequestMapping("OrderdetailsController")
public class OrderdetailsController 
{
	@Autowired
	private IOrderdetailsService orderdetailsService;
	
	@Autowired
	private IOrdersService orderService;
	
	@Autowired
	private IAddressesService IAddressesService;
	@Autowired
	private IWarehouseService IWarehouseService;
	
	@Autowired
	private ICommodityService ICommodityService;
	
	
	@RequestMapping("updateOrderdetails.do")
	public String updateOrderdetails(Orderdetails orderdetails)
	{
		orderdetailsService.updateByPrimaryKeySelective(orderdetails);
		return "redirect:selectOrderdetails.do";
	}
	
	@RequestMapping("receive.do")
	public String receive(HttpServletRequest request,int oid,Model m)
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		m.addAttribute("username", u.getUsername());
		m.addAttribute("oid", oid);
		return "receive";
	}
	
	@RequestMapping("updateByoid.do")
	public String updateByoid(Orderdetails detail)
	{
		System.out.println(detail.getOid());
		System.out.println(detail.getAid());
		Orderdetailst o=new Orderdetailst();
		o.setAid(detail.getAid());
		o.setOid(detail.getOid());
		orderdetailsService.updateByoid(o);
		return "redirect:/rest/mainHomeController/homepage";
	}
	
	@RequestMapping("insertOrderdetails.do")
	public String insertOrderdetails(Orderdetails detail)
	{
		orderdetailsService.insertSelective(detail);
		System.out.println("njfnejfnejk");
		return "redirect:/MyOrderController/selectOrder.do";
	}
	
	@RequestMapping("SelectOrderdetails.do")
	public String selectOrderdetails(int oid,Model m)
	{	
		System.out.println("dnwjdhwjdhwejkde");
		System.out.println(oid);
		List<Orderdetails> list = orderdetailsService.selectByoid(oid);
		m.addAttribute("list", list);	
		m.addAttribute("Commodity",ICommodityService.selectByExample(null));
		m.addAttribute("Address",IAddressesService.selectByExample(null));
		m.addAttribute("Warehouse",IWarehouseService.selectByExample(null));
		return "COrderdetails";
	}
}
