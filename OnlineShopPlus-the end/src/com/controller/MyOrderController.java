package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mapper.pojo.Commodity;
import com.mapper.pojo.Orderdetails;
import com.mapper.pojo.Orders;
import com.mapper.pojo.TwoOrderdetails;
import com.mapper.pojo.User;
import com.onlineshop.mapper.OrderdetailsMapper;
import com.onlineshop.mapper.OrdersMapper;
import com.service.ICartService;
import com.service.ICommodityService;
import com.service.IOrderdetailsService;
import com.service.IOrdersService;


@Controller
@RequestMapping("MyOrderController")
public class MyOrderController
{
	@Autowired
	private IOrdersService orderService;
	
	@Autowired
	private ICommodityService commodityService;
	
	@Autowired
	private IOrderdetailsService orderdetailsService;
	
	@Autowired
	private ICartService cartService;
	
	@RequestMapping("Myorder.do")
	public String Myorder(HttpServletRequest request,int cid,Model m)
	{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println(user.getUsername());
		System.out.println(cid);
		Commodity commodity = commodityService.selectByPrimaryKey(cid);
		int freight=0;
		if(commodity.getPrice()<200)
			freight=10;
		Orders record=new Orders();
		record.setUsername(user.getUsername());
		record.setFreight(freight);
		record.setStatus(1);
		orderService.insert(record);
		System.out.println(record.getOid());
		Orderdetails orderdetails=new Orderdetails();
		orderdetails.setOid(record.getOid());
		orderdetails.setCid(cid);
		orderdetails.setNumber(1);
		m.addAttribute("username", user.getUsername());
		m.addAttribute("orderdetails", orderdetails);
		return "MyOrderdetails";
	}
	
	@RequestMapping("insertOrder.do")
	public @ResponseBody Orders  insertOrder(HttpServletRequest request,@RequestBody List<TwoOrderdetails> str)
	{
		System.out.println(str);
		if(str.size()!=0)
		{			
			HttpSession session = request.getSession();
			User u=(User) session.getAttribute("user");
			int sum=0;
			int freight=0;
			for (TwoOrderdetails t : str)
			{
				sum=sum+t.getMoney();
			}
			if(sum<200)
				freight=10;
			Orders order=new Orders();
			order.setUsername(u.getUsername());
			order.setFreight(freight);
			order.setStatus(1);
			orderService.insert(order);
			for (TwoOrderdetails t : str) 
			{				
				Orderdetails detail=new Orderdetails();
				detail.setOid(order.getOid());
				detail.setCid(t.getCid());
				detail.setNumber(t.getNum());
				orderdetailsService.insertSelective(detail);
				cartService.deleteCartBycid(t.getCid());
			}
			System.out.println(order.getOid());
			return order;			
		}
		return null;
	}
	
	@RequestMapping("selectOrder.do")
	public String selectOrder(HttpServletRequest request,Model m)
	{
		HttpSession session = request.getSession();
		User u=(User) session.getAttribute("user");
		List<Orders> list = orderService.selectByusernames(u.getUsername());
		m.addAttribute("list", list);
		return "Myorder";
	}
}
