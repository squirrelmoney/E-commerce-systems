package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mapper.pojo.Addresses;
import com.mapper.pojo.User;
import com.service.IAddressesService;

@Controller
@RequestMapping("addressescontroller")
public class AddressesController {
	@Autowired
	private IAddressesService IAddressesService;
	@RequestMapping("selectAllAddresses")
	public String selectAllIAddresses(Model m){
		return "selectAddresses";
	}
    
	
	@RequestMapping("selectuserAddresses/{username}")
	public String selectuserAddresses(Model m,@PathVariable String username){
		m.addAttribute("username",username);
		return "selectAddresses";
	}
	
	@RequestMapping("selectuserAddressesplus")
	public @ResponseBody  List<Addresses> selectuserAddresses(@RequestBody Addresses Addresses){
		return IAddressesService.selectByusername(Addresses.getUsername());
	}
	
	@RequestMapping("customerAddress")
	public  String selectuserAddresses(Model m,HttpSession session,String username){
		User u = (User) session.getAttribute("user");
		session.setAttribute("user", u);
		m.addAttribute("list",IAddressesService.selectByusername(u.getUsername()));
		return "CustomerAddress";
	}
	
	@RequestMapping("deleteAddressesByList")
	public @ResponseBody List<Addresses> deleteIAddressesById(@RequestBody Addresses Addresses){
		IAddressesService.deleteAddress(Addresses.getAid());
		return IAddressesService.selectByusername(Addresses.getUsername());
	}


	@RequestMapping("updateAddresses")
	public @ResponseBody Addresses updateIAddressesById(Model m,@RequestBody Addresses Addresses){
		IAddressesService.updateByPrimaryKeySelective(Addresses, null);
		return Addresses;
	}
@RequestMapping("insertIntoAddresses")
public String test(){
	return "insertIntoAddresses";
}

@RequestMapping("insertIAddresses1")
public String  insertIntoIAddresses1( Addresses Addresses){
	System.out.println("111111111111111111111111111111111111");
	IAddressesService.insertIntoAddress(Addresses);
	return "redirect:/rest/addressescontroller/customerAddress";
}

	@RequestMapping("insertIAddresses")
	public @ResponseBody Addresses insertIntoIAddresses(@RequestBody Addresses Addresses){
		IAddressesService.insertIntoAddress(Addresses);
		return Addresses;
	}

}
