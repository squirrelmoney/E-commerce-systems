package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mapper.pojo.Commodity;
import com.service.ICommodityService;

@Controller
@RequestMapping("commoditycontroller")
public class CommodityController {
@Autowired
private ICommodityService commodityservice;

@RequestMapping("selectAllCommodity")
public String selectAllCommodity(Model m){
	List<Commodity> list=commodityservice.selectAll(null);
	 m.addAttribute("list",list);
	return "selectCommodity";
}

@RequestMapping("deleteCommodityById")
public String deleteCommodityById(Model m,int cid){
	commodityservice.deleteCommodityById(cid);
	return "redirect:/commoditycontroller/selectAllCommodity.do";
}

@RequestMapping("updateCommodityById/{cid}")
public String updateCommodityById(@PathVariable int cid,Model m){
	m.addAttribute("list",commodityservice.selectById(cid));
	return "updateCommodity";
}

@RequestMapping("updateCommodity")
public String updateCommodityById(Model m,Commodity Commodity){
	commodityservice.updateCommodityById(Commodity);
	return "redirect:/commoditycontroller/selectAllCommodity.do";
}


@RequestMapping("insertIntoCommodity/{cid}")
public String insertIntoCommodity(@PathVariable int cid,Model m){
	return "insertIntoCommodity";
}

@RequestMapping("insertCommodity")
public String insertIntoCommodity(Commodity Commodity){
	commodityservice.insertIntoCommodity(Commodity);
	return "redirect:/commoditycontroller/selectAllCommodity.do";
}
}
