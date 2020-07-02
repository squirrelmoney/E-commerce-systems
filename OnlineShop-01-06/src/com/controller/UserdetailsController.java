package com.controller;

import java.util.List;








import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mapper.pojo.Userdetails;
import com.service.IUserdetailsService;

@Controller
@RequestMapping("userdetailscontroller")
public class UserdetailsController {
	
	@Autowired
	private IUserdetailsService Userdetailsservice;
	
	@RequestMapping("selectAllUserdetails")
	public String selectAllUserdetails(Model m){
		List<Userdetails> list=Userdetailsservice.selectAll(null);
		 m.addAttribute("list",list);
		return "selectUserdetails";
	}

	@RequestMapping("deleteUserdetailsById/{username}")
	public String deleteUserdetailsById(Model m,@PathVariable String username){
		Userdetailsservice.deleteUserdetailsById(username);
		return "redirect:/userdetailscontroller/selectAllUserdetails.do";
	}

	@RequestMapping("updateUserdetailsById/{username}")
	public String updateUserdetailsById(@PathVariable String username,Model m){
		m.addAttribute("list",Userdetailsservice.selectById(username));
		return "updateUserdetails";
	}

	@RequestMapping("updateUserdetails")
	public String updateUserdetailsById(Model m,Userdetails Userdetails){
		Userdetailsservice.updateUserdetailsById(Userdetails);
		return "redirect:/userdetailscontroller/selectAllUserdetails.do";
	}



}
