package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mapper.pojo.Commodity;
import com.mapper.pojo.User;
import com.mapper.pojo.Userdetails;
import com.mapper.pojo.Warehouse;
import com.mapper.pojo.WarehouseKey;
import com.service.IUserService;
import com.service.IUserdetailsService;
import com.service.IWarehouseService;
import com.service.IchooseWarehouseService;
@Controller
public class WarehouseController {
    @Autowired
    private IUserdetailsService iUserdetailsService;
    @Autowired
    private IWarehouseService iWarehouseService;
    @Autowired
    private IchooseWarehouseService IchooseWarehouseService;
	public int apportion(String address ,List<Commodity> list){
		WarehouseKey key=new WarehouseKey();
		for (Commodity a : list) {
		  List<Warehouse> WarehouseList = iWarehouseService.selectByCId(a.getCid());
		  int b=IchooseWarehouseService.chooseWarehouse(WarehouseList, address);
		  key.setCid(a.getCid());
		  key.setWid(b);
		  Warehouse wh=iWarehouseService.selectById(key);
		  System.out.println("…Ã∆∑"+a.getName()+"∑÷≈‰≤÷ø‚£∫"+wh.getAddress());
//		  updateWarehouse(wh.setInventory(wh.getInventory-1));
		  //insertIntoOrderdetail()//
		}
		return 0;
	}
    

}
