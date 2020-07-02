package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mapper.pojo.Addresses;
import com.service.IAddressesService;

@Controller
@RequestMapping("addressescontroller")
public class AddressesController {
	@Autowired
	private IAddressesService IAddressesservice;
	
	@RequestMapping("selectAllAddresses")
	public String selectAllIAddresses(Model m){
		 m.addAttribute("list",IAddressesservice.selectAllAddresses(null));
		return "selectAddresses";
	}

	
	@RequestMapping("selectuserAddresses/{username}")
	public String selectuserAddresses(@PathVariable String username,Model m){
		m.addAttribute("list",IAddressesservice.selectById(username));
		return "selectAddresses";
	}
	
	@RequestMapping("deleteAddressesByList/{list}")
	public String deleteIAddressesById(Model m,@PathVariable Addresses list){
		IAddressesservice.deleteAddress(list);
		return "redirect:/Addressescontroller/selectAllAddresses.do";
	}

	@RequestMapping("updateAddressesByList/{list}")
	public String updateIAddressesById(@PathVariable Addresses list,Model m){
		m.addAttribute("list",list);
		return "updateAddresses";
	}

	@RequestMapping("updateAddresses")
	public String updateIAddressesById(Model m,Addresses Addresses){
		IAddressesservice.updateByExample(Addresses, null);
		return "redirect:/Addressescontroller/selectuserAddresses.do";
	}


	@RequestMapping("insertIntoAddressesByList")
	public String insertIntoIAddresses(Model m){
		return "insertIntoAddresses";
	}

	@RequestMapping("insertIAddresses")
	public String insertIntoIAddresses(Addresses Addresses,RedirectAttributes r){
		IAddressesservice.insertIntoAddress(Addresses);
		r.addAttribute("username",Addresses.getUsername());
		return "forword:/Addressescontroller/selectuserAddresses.do";
	}

}
