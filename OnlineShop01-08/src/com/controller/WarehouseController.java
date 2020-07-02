package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mapper.pojo.Commodity;
import com.mapper.pojo.Warehouse;
import com.mapper.pojo.WarehouseKey;
import com.service.IOrderdetailsService;
import com.service.IWarehouseService;
import com.service.IchooseWarehouseService;
@Controller
public class WarehouseController {
    @Autowired
    private IOrderdetailsService iOrderdetailsService;
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
    
	@RequestMapping("selectAllWarehouse")
	public String selectAllIWarehouse(Model m){
		// m.addAttribute("list",IWarehouseservice.selectAllWarehouse(null));
		m.addAttribute("p","5");
		return "selectWarehouse";
	}
    
	
/*	@RequestMapping("selectAllWarehouse1")
	public @ResponseBody  List<Warehouse> selectAllIWarehouse(@RequestBody Warehouse Warehouse){
		return IWarehouseservice.selectAllWarehouse(null);
	}*/
	
	@RequestMapping("selectuserWarehouse")
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


	@RequestMapping("insertIWarehouse")
	public @ResponseBody Warehouse insertIntoIWarehouse(@RequestBody Warehouse Warehouse){
		iWarehouseService.insertIntoWarehouse(Warehouse);
		return Warehouse;
	}

	

}
