package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
		// m.addAttribute("list",IAddressesservice.selectAllAddresses(null));
		m.addAttribute("p","5");
		return "selectAddresses";
	}
    
	
/*	@RequestMapping("selectAllAddresses1")
	public @ResponseBody  List<Addresses> selectAllIAddresses(@RequestBody Addresses Addresses){
		return IAddressesservice.selectAllAddresses(null);
	}*/
	
	@RequestMapping("selectuserAddresses")
	public @ResponseBody  List<Addresses> selectuserAddresses(@RequestBody Addresses Addresses){
		if(Addresses.getUsername().replace(" ", "").isEmpty())
			return IAddressesservice.selectAllAddresses(null);
		else
		return IAddressesservice.selectById(Addresses.getUsername());
	}
/*	@RequestMapping("selectuserAddresses/{username}")
	public  String selectuserAddresses(@PathVariable String username,Model m){
		m.addAttribute("list",IAddressesservice.selectById(username));
		return "selectAddresses";
	}*/
	
	@RequestMapping("deleteAddressesByList")
	public @ResponseBody List<Addresses> deleteIAddressesById(@RequestBody Addresses Addresses){
		IAddressesservice.deleteAddress(Addresses.getId());
		return IAddressesservice.selectById(Addresses.getUsername());
	}


	@RequestMapping("updateAddresses")
	public @ResponseBody Addresses updateIAddressesById(Model m,@RequestBody Addresses Addresses){
		IAddressesservice.updateByPrimaryKeySelective(Addresses, null);
		return Addresses;
	}


	@RequestMapping("insertIAddresses")
	public @ResponseBody Addresses insertIntoIAddresses(@RequestBody Addresses Addresses){
		IAddressesservice.insertIntoAddress(Addresses);
		return Addresses;
	}

}
