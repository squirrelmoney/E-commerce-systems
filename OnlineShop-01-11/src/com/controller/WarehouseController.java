package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mapper.pojo.Addresses;
import com.mapper.pojo.Commodity;
import com.mapper.pojo.Orderdetails;
import com.mapper.pojo.OrderdetailsKey;
import com.mapper.pojo.Warehouse;
import com.mapper.pojo.WarehouseDate;
import com.mapper.pojo.WarehouseKey;
import com.service.IAddressesService;
import com.service.IOrderdetailsService;
import com.service.IWarehouseService;
import com.service.IchooseWarehouseService;
@Controller
@RequestMapping("warehousecontroller")
public class WarehouseController {
    @Autowired
    private IOrderdetailsService IOrderdetailsService;
    @Autowired
    private IWarehouseService iWarehouseService;
    @Autowired
    private IchooseWarehouseService IchooseWarehouseService;
    @Autowired
    private IAddressesService IAddressesService;
    @RequestMapping("apportion")
	public @ResponseBody List<WarehouseDate> apportion(@RequestBody WarehouseDate date)
    {
    	
		List<Orderdetails> orderdetails = IOrderdetailsService.selectByoId(date.getOid());
		List<WarehouseDate> list=new ArrayList<WarehouseDate>();
		
		for (Orderdetails od : orderdetails) {
			WarehouseDate date1=new WarehouseDate();
			date1.setOid(date.getOid());
			date1.setCid(od.getCid());
			date1.setAid(od.getAid());
		List<Warehouse> WarehouseList = iWarehouseService.selectByCId(od.getCid());
			 Addresses addresses = IAddressesService.selectByaId(od.getAid());
			 int wid=IchooseWarehouseService.chooseWarehouse(WarehouseList, addresses.getAddress());
			 date1.setWid(wid);
			 WarehouseKey key=new WarehouseKey();
			 key.setCid(od.getCid());
			 key.setWid(wid);
			 date1.setWarehouse(iWarehouseService.selectById(key).getAddress());
			 double distance=IchooseWarehouseService.getdistance
					 (iWarehouseService.selectById(key).getAddress(),addresses.getAddress()); 
			 date1.setDistance(distance);
			 list.add(date1);
			 
		}
		return list;
		}
		
    @RequestMapping("apportionBySelected")
   	public @ResponseBody WarehouseDate apportionBySelected(@RequestBody WarehouseDate date)
       {
       	OrderdetailsKey key=new OrderdetailsKey();
       	key.setCid(date.getCid());
       	key.setOid(date.getOid());
   		Orderdetails orderdetails = IOrderdetailsService.selectBykey(key);
   			WarehouseDate date1=new WarehouseDate();
   			date1.setOid(date.getOid());
   			date1.setCid(date.getCid());
   			date1.setAid(orderdetails.getAid());
   		    List<Warehouse> WarehouseList = iWarehouseService.selectByCId(date.getCid());
   			 Addresses addresses = IAddressesService.selectByaId(orderdetails.getAid());
   			 int wid=IchooseWarehouseService.chooseWarehouse(WarehouseList, addresses.getAddress());
   			 date1.setWid(wid);
   			 WarehouseKey key1=new WarehouseKey();
   			 key1.setCid(orderdetails.getCid());
   			 key1.setWid(date.getWid());
   			 date1.setWarehouse(iWarehouseService.selectById(key1).getAddress());
   			 double distance=IchooseWarehouseService.getdistance
   					 (iWarehouseService.selectById(key1).getAddress(),addresses.getAddress()); 
   			 date1.setDistance(distance);
   			return date1;
   		}
   		
    
	@RequestMapping("selectAllWarehouse")
	public String selectAllIWarehouse(Model m){
		return "selectWarehouse";
	}
    
	
	@RequestMapping("selectWarehouse")
	public @ResponseBody  List<Warehouse> selectuserWarehouse(@RequestBody Warehouse Warehouse){
		return iWarehouseService.selectAll(null);
	}

	
	@RequestMapping("deleteWarehouseByList")
	public @ResponseBody List<Warehouse> deleteIWarehouseById(@RequestBody Warehouse Warehouse){
		WarehouseKey key=new WarehouseKey();
		key.setCid(Warehouse.getCid());
		key.setWid(Warehouse.getWid());
		iWarehouseService.deleteWarehouseById(key);
		return iWarehouseService.selectAll(null);
	}


	@RequestMapping("updateWarehouse")
	public @ResponseBody Warehouse updateIWarehouseById(Model m,@RequestBody Warehouse Warehouse){
		iWarehouseService.updateWarehouseById(Warehouse);
		return Warehouse;
	}


	@RequestMapping("insertWarehouse")
	public @ResponseBody Warehouse insertIntoIWarehouse(@RequestBody Warehouse Warehouse){
		iWarehouseService.insertIntoWarehouse(Warehouse);
		return Warehouse;
	}

	

}
