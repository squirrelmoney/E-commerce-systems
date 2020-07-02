package com.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.coms.Commons;
import com.mapper.pojo.Commodity;
import com.mapper.pojo.Orderdetails;
import com.mapper.pojo.Orders;
import com.mapper.pojo.Profit;
import com.mapper.pojo.User;
import com.mapper.pojo.Userdetails;
import com.service.ICartService;
import com.service.ICommodityService;
import com.service.IOrderdetailsService;
import com.service.IOrdersService;
import com.service.IProfitService;
import com.service.IUserService;
import com.service.IUserdetailsService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Controller//获取当前类对象
@RequestMapping("AdminController")
public class AdminController {
	@Autowired//获取userservice的方法
	 private IUserService IUserService ;
    @Autowired
    private ICartService ICartService;
    @Autowired
    private ICommodityService ICommodityService;
    @Autowired
    private IOrderdetailsService IOrderdetailsService;
    @Autowired
    private IOrdersService IOrdersService;
    @Autowired
    private IProfitService IProfitService;
    @Autowired
    private IUserdetailsService IUserdetailsService;
	  //插入商品
    @RequestMapping("insertCommdity")
    public String insertCommdity(Model model) { 
        return "insertCommdity";
    }
    
	@RequestMapping("uploadPic.do")
	/*request：前端提出的请求全部封装在里面
	 * filename：里面存放文件对象
	 * out：向前端回调函数打印绝对路径和相对路径*/
	public void uploadPic(HttpServletRequest request,String fileName,PrintWriter out)
	{
		System.out.println("njfejkfbejbf");
		/*图片以二进制数据流的形式上传
		 * MultipartHttpServletRequest只能接受二进制数据流，图片名称和图片详情以request请求
		 * request强转成多部件对象*/
		MultipartHttpServletRequest mh=(MultipartHttpServletRequest) request;
		/*根据文件名称得到文件对象
		 * 得到文件对象之后要获得流*/
		CommonsMultipartFile cm= (CommonsMultipartFile) mh.getFile(fileName);
		byte[] fbytes = cm.getBytes();
		
		//解决文件名在服务器重名
		String newFileName="";
		/*系统时间转换成字符串类型*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		System.out.println(new Date());
		/*Mon Jan 06 22:22:06 CST 2020*/
		newFileName = sdf.format(new Date());
		System.out.println(newFileName);
		Random r=new Random();
		
		/*r.nextInt(10)取0-9之间的随机数*/
		for(int i=0;i<3;i++)
			newFileName=newFileName+r.nextInt(10);
		
		//获取文件的扩展名--获取文件的原始文件名并截取“.”之后的字符串
		String originalFilename = cm.getOriginalFilename();
		System.out.println(originalFilename);
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
		System.out.println(suffix);
		
		/*跨服务器上传*/
		//创建客户端
		Client client = Client.create();
		/*客户端要把文件上传到服务器的那个位置：服务器地址，位置，文件名称和后缀*/
		WebResource resource = client.resource(Commons.pic+"/upload/"+newFileName+suffix);
		//把数据流数组放到服务器
		resource.put(String.class, fbytes);
		
		/*把绝对路径和相对路径拼成json字符串传到前端去，前端得到这个字符串并转换成json对象，json对象再得到绝对路径和相对路径
		 * 数据库保存的相对路径
		 * 图片需要回显要有绝对路径*/
		String fullPath = Commons.pic+"/upload/"+newFileName+suffix;
		
		String relativePath="/upload/"+newFileName+suffix;		
		
		String result="{\"fullPath\":\""+fullPath+"\",\"relativePath\":\""+relativePath+"\"}";
		
		//向前端回调函数打印绝对路径和相对路径
		out.print(result);
	}
    
     
    @RequestMapping("saveCommndity")
    public String Save(Commodity Commodity, Model model) { // user:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
    	model.addAttribute("Commdity", Commodity);
    	ICommodityService.insertSelective(Commodity);
	    List<Commodity> selectAll=ICommodityService.selectByExample(null);	
		 model.addAttribute("list", selectAll);
		 return "redirect:/rest/mainHomeController/adminhomepage";
    	
    }
	
    
    @RequestMapping("selectProfit")
    public String selectProfit(Model m) {
    	 List<Profit> selectAll=IProfitService.selectByExample(null);	
		 m.addAttribute("list", selectAll);
		 return "ListProfit";
	}
    
    @RequestMapping("selectAllWarehouse")
	public String selectAllIWarehouse(Model m){
		return "selectWarehouse";
	}
    
    
    
    @RequestMapping("AllOrderDetails")
	public String deliverOrderDetails(Model m){
		 m.addAttribute("Orderdetails",IOrderdetailsService.selectByExample(null));
		 m.addAttribute("Orders",IOrdersService.selectByExample(null));
		 m.addAttribute("Commodity",ICommodityService.selectByExample(null));
		return "AllOrderDetails";
	}
    
    

	@RequestMapping("AllUser")
    public String testModel(Model m){		
		  List<com.mapper.pojo.User> selectAll=IUserService.selectByExample(null);	   
			 m.addAttribute("list", selectAll);
			 return "AllUser";	    
   	 
    }
	
	

	
	
    @RequestMapping("deleteCommodity/{cid}")
    public String toEdit(@PathVariable int cid,Model m){
    	ICommodityService.deleteByPrimaryKey(cid);
  	   List<Commodity> selectAll=ICommodityService.selectByExample(null);
		 m.addAttribute("list", selectAll);
		 return "redirect:/rest/mainHomeController/adminhomepage";
    }
    
    
    @RequestMapping("updateCommodity/{cid}")
    public String toEdit11(@PathVariable int cid,Model m){ 
    	m.addAttribute("Commodity", ICommodityService.selectByPrimaryKey(cid)); 
		return "updateCommodity";
    }
    
    
    @RequestMapping("updateCommodity")
    public String updateuser(Model m,Commodity commodity){    	
    	ICommodityService.updateByPrimaryKeySelective(commodity);
    	return "redirect:/rest/mainHomeController/adminhomepage";
    	
    }
    
    @RequestMapping("updateUser/{username}")
    public String toEdit11(@PathVariable String username,Model m){ 
    	m.addAttribute("user", IUserService.selectByPrimaryKey(username));  
    	m.addAttribute("userdetails", IUserdetailsService.selectByPrimaryKey(username)); 
		 return "AdminupdateUser";
    }
    
    @RequestMapping("updatingUser")
    public String updateuser(Model m,User user,Userdetails userdetails){    	
    	IUserService.updateByPrimaryKeySelective(user);
    	IUserdetailsService.updateByPrimaryKey(userdetails);
    	return "redirect:/rest/AdminController/AllUser";
    	
    }
    
    @RequestMapping("insertUser")
    public String insertUser(Model model) { 
        return "insertUser";
    }
    
     
    @RequestMapping("saveUser")
    public String Save(User user,Userdetails userdetails, Model model) { // user:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
    	model.addAttribute("user", user);
    	model.addAttribute("userdetails",userdetails); 
    	user.setAuthority(1);
    	IUserService.insert(user);
    	IUserdetailsService.insert(userdetails);
	    List<User> selectAll=IUserService.selectByExample(null);	   
		 model.addAttribute("list", selectAll);
		 return "redirect:/rest/AdminController/AllUser";
    	
    }
    

}
