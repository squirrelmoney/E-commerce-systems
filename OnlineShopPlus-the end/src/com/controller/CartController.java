package com.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mapper.pojo.Cart;
import com.mapper.pojo.CartKey;
import com.mapper.pojo.Commodity;
import com.mapper.pojo.User;
import com.service.ICartService;
import com.service.ICommodityService;


@Controller
@RequestMapping("CartController")
public class CartController 
{
	@Autowired
	private ICartService cartService;
	@Autowired
	private ICommodityService commodityService;
	
	@RequestMapping("Mycart.do")
	public String mycart(HttpServletRequest request,Model m)
	{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Cart> list = cartService.selectCartByusername(user.getUsername());
		m.addAttribute("list", list);
		/*m.addAttribute("size", 0);*/
		return "Mycart";
	}
	
	@RequestMapping("insertMycart.do")
	public String insertMycart(HttpServletRequest request,Model m,int cid)
	{
		Commodity c=commodityService.selectByPrimaryKey(cid);
		HttpSession session = request.getSession();		
		System.out.println("bejbfejbfjebf");	
		if(session.getAttribute("user")!=null)
		{
			User user = (User) session.getAttribute("user");
			System.out.println(user.getUsername());
			List<Cart> list=cartService.selectCartByusername(user.getUsername());
			for (Cart cart : list)
			{
				if(cart.getCid()==cid)
				{
					Cart car=new Cart();
					car.setUsername(user.getUsername());
					car.setCid(cid);
					car.setName(c.getName());
					int price=c.getPrice();
					car.setPrice(price);
					int sum=cart.getSum()+1;
					car.setSum(sum);
					int money=sum*price;
					car.setMoney(money);
					cartService.updateByPrimaryKeySelective(car);
					return "redirect:/rest/mainHomeController/homepage";
				}
			}
			Cart ca=new Cart();
			ca.setUsername(user.getUsername());
			ca.setCid(cid);
			ca.setName(c.getName());
			ca.setPrice(c.getPrice());				
			ca.setSum(1);
			ca.setMoney(c.getPrice());
			cartService.insertSelective(ca);
			return "redirect:/rest/mainHomeController/homepage";			
		}
		else
		{
			return "redirect:/rest/LoginController/Loginuser";
		}

	}	
	
	@RequestMapping("deleteMycart.do")
	public String deleteMycart(int cid)
	{
		cartService.deleteCartBycid(cid);
		return "redirect:Mycart.do";
	}	
	
	@RequestMapping("add.do")
	//使用@ResponseBody返回的是json对象
	public @ResponseBody Cart add(HttpServletRequest request,@RequestBody Cart cart)
	{
		HttpSession session=request.getSession();
		User u=(User) session.getAttribute("user");		
		System.out.println(u.getUsername());
		Commodity com = commodityService.selectByPrimaryKey(cart.getCid());
		Cart c=new Cart();
		c.setUsername(u.getUsername());
		c.setCid(cart.getCid());
		c.setName(com.getName());
		c.setPrice(com.getPrice());
		System.out.println(cart.getSum());
		int sum=cart.getSum()+1;
		c.setSum(sum);
		int price=cart.getPrice();
		int money=sum*price;
		c.setMoney(money);
		cartService.updateByPrimaryKeySelective(c);
		return c;
	}
	
	@RequestMapping("reduce.do")
	public @ResponseBody Cart reduce(HttpServletRequest request,@RequestBody Cart cart)
	{
		HttpSession session=request.getSession();
		User u=(User) session.getAttribute("user");		
		System.out.println(u.getUsername());
		System.out.println("njdnfjnfejkfn");
		Commodity com = commodityService.selectByPrimaryKey(cart.getCid());
		Cart c=new Cart();
		c.setUsername(u.getUsername());
		c.setCid(cart.getCid());
		c.setName(com.getName());
		c.setPrice(com.getPrice());
		System.out.println("123232323");
		System.out.println(cart.getSum());
		int sum=cart.getSum()-1;
		c.setSum(sum);
		int price=cart.getPrice();
		int money=sum*price;
		c.setMoney(money);
		cartService.updateByPrimaryKeySelective(c);
		return c;
	}	
	
}
