package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.core.config.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mapper.pojo.Addresses;
import com.mapper.pojo.Commodity;
import com.mapper.pojo.Orderdetails;
import com.mapper.pojo.OrderdetailsList;
import com.mapper.pojo.Orders;
import com.mapper.pojo.Warehouse;
import com.mapper.pojo.WarehouseKey;
import com.service.IAddressesService;
import com.service.ICommodityService;
import com.service.IOrderdetailsService;
import com.service.IOrdersService;
import com.service.IUserdetailsService;
import com.service.IWarehouseService;
import com.service.IchooseWarehouseService;


@Controller
@RequestMapping("delivergoodscontroller")
public class deliverGoodsController {
	@Autowired
	private IOrderdetailsService IOrderdetailsService;
	@Autowired
	private IOrdersService IOrderService;
	@Autowired
	private ICommodityService ICommodityService;
	@Autowired
	private IAddressesService IAddressesService;
	@Autowired
	private IWarehouseService IWarehouseService;
	@Autowired
	private IchooseWarehouseService IchooseWarehouseService;
	@Autowired
	private IUserdetailsService IUserdetailsService;
	
	@RequestMapping("delivergoods/{oid}")
	public String delivergoods(Model m,@PathVariable int oid){
		List<Orderdetails> orderdetails = IOrderdetailsService.selectByoid(oid);
		Orders orders = IOrderService.selectByPrimaryKey(oid);
		m.addAttribute("userdetails",IUserdetailsService.selectByPrimaryKey(orders.getUsername()));
		m.addAttribute("Orderdetails",orderdetails);
		m.addAttribute("Address",IAddressesService.selectAllAddresses(null));
		m.addAttribute("Warehouse",IWarehouseService.selectAll(null));
		m.addAttribute("oid",oid);
		m.addAttribute("size",orderdetails.size());
		return "deliverGoods";
	}
	
	@RequestMapping("checkdelivergoods/{oid}")
	public String checkdelivergoods(Model m,@PathVariable int oid){
		List<Orderdetails> orderdetails = IOrderdetailsService.selectByoid(oid);
		List<Commodity> Commoditylist=new ArrayList<Commodity>();
		List<Warehouse> Warehouselist=new ArrayList<Warehouse>();
		WarehouseKey key=new WarehouseKey();
		for (Orderdetails o : orderdetails) {
			key.setCid(o.getCid());
			key.setWid(o.getWid());
			Commoditylist.add(ICommodityService.selectByPrimaryKey(o.getCid()));
			Warehouselist.add(IWarehouseService.selectById(key));
		}
		Orders orders = IOrderService.selectByPrimaryKey(oid);
		m.addAttribute("userdetails",IUserdetailsService.selectByPrimaryKey(orders.getUsername()));
		m.addAttribute("Orderdetails",orderdetails);
		m.addAttribute("Address",IAddressesService.selectAllAddresses(null));
		m.addAttribute("Warehouselist",Warehouselist);
		m.addAttribute("Commoditylist",Commoditylist);
		m.addAttribute("oid",oid);
		return "checkDeliverGoods";
	}

	@RequestMapping("delivering")
	public String delivering(OrderdetailsList list){
		//IOrderdetailsService.updateOrderdetailsById(orderdetails);
		List<Orderdetails> orderdetailsList = list.getOrderdetailsList();
		for (Orderdetails orderdetails : orderdetailsList) {
		 if(IOrderdetailsService.updateByPrimaryKeySelective(orderdetails)!=0){
			 Orders orders = IOrderService.selectByPrimaryKey(orderdetails.getOid());
			 orders.setStatus(2);
			 IOrderService.updateByPrimaryKey(orders);
			 WarehouseKey key=new WarehouseKey();
			 key.setCid(orderdetails.getCid());
			 key.setWid(orderdetails.getWid());
			 Warehouse warehouse = IWarehouseService.selectById(key);
			 warehouse.setInventory(warehouse.getInventory()-orderdetails.getNumber());
			 IWarehouseService.updateWarehouseById(warehouse);
		 }
		}
		return "redirect:/rest/AdminController/AllOrderDetails";
	
	}
	
	@RequestMapping("confirming")
	public String confirming(@PathVariable int oid){
		List<Orderdetails> list = IOrderdetailsService.selectByoid(oid);
		for (Orderdetails orderdetails : list) {
		 Orders orders = IOrderService.selectByPrimaryKey(orderdetails.getOid());
		 orders.setStatus(2);
		 IOrderService.updateByPrimaryKey(orders);
		 WarehouseKey key=new WarehouseKey();
		 key.setCid(orderdetails.getCid());
		 key.setWid(orderdetails.getWid());
		 Warehouse warehouse = IWarehouseService.selectById(key);
		 warehouse.setInventory(warehouse.getInventory()-orderdetails.getNumber());
		 IWarehouseService.updateWarehouseById(warehouse);
		}
		return "redirect:/rest/AdminController/AllOrderDetails";
	}
	
}
