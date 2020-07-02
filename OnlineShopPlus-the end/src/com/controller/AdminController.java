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

@Controller//��ȡ��ǰ�����
@RequestMapping("AdminController")
public class AdminController {
	@Autowired//��ȡuserservice�ķ���
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
	  //������Ʒ
    @RequestMapping("insertCommdity")
    public String insertCommdity(Model model) { 
        return "insertCommdity";
    }
    
	@RequestMapping("uploadPic.do")
	/*request��ǰ�����������ȫ����װ������
	 * filename���������ļ�����
	 * out����ǰ�˻ص�������ӡ����·�������·��*/
	public void uploadPic(HttpServletRequest request,String fileName,PrintWriter out)
	{
		System.out.println("njfejkfbejbf");
		/*ͼƬ�Զ���������������ʽ�ϴ�
		 * MultipartHttpServletRequestֻ�ܽ��ܶ�������������ͼƬ���ƺ�ͼƬ������request����
		 * requestǿת�ɶಿ������*/
		MultipartHttpServletRequest mh=(MultipartHttpServletRequest) request;
		/*�����ļ����Ƶõ��ļ�����
		 * �õ��ļ�����֮��Ҫ�����*/
		CommonsMultipartFile cm= (CommonsMultipartFile) mh.getFile(fileName);
		byte[] fbytes = cm.getBytes();
		
		//����ļ����ڷ���������
		String newFileName="";
		/*ϵͳʱ��ת�����ַ�������*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		System.out.println(new Date());
		/*Mon Jan 06 22:22:06 CST 2020*/
		newFileName = sdf.format(new Date());
		System.out.println(newFileName);
		Random r=new Random();
		
		/*r.nextInt(10)ȡ0-9֮��������*/
		for(int i=0;i<3;i++)
			newFileName=newFileName+r.nextInt(10);
		
		//��ȡ�ļ�����չ��--��ȡ�ļ���ԭʼ�ļ�������ȡ��.��֮����ַ���
		String originalFilename = cm.getOriginalFilename();
		System.out.println(originalFilename);
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
		System.out.println(suffix);
		
		/*��������ϴ�*/
		//�����ͻ���
		Client client = Client.create();
		/*�ͻ���Ҫ���ļ��ϴ������������Ǹ�λ�ã���������ַ��λ�ã��ļ����ƺͺ�׺*/
		WebResource resource = client.resource(Commons.pic+"/upload/"+newFileName+suffix);
		//������������ŵ�������
		resource.put(String.class, fbytes);
		
		/*�Ѿ���·�������·��ƴ��json�ַ�������ǰ��ȥ��ǰ�˵õ�����ַ�����ת����json����json�����ٵõ�����·�������·��
		 * ���ݿⱣ������·��
		 * ͼƬ��Ҫ����Ҫ�о���·��*/
		String fullPath = Commons.pic+"/upload/"+newFileName+suffix;
		
		String relativePath="/upload/"+newFileName+suffix;		
		
		String result="{\"fullPath\":\""+fullPath+"\",\"relativePath\":\""+relativePath+"\"}";
		
		//��ǰ�˻ص�������ӡ����·�������·��
		out.print(result);
	}
    
     
    @RequestMapping("saveCommndity")
    public String Save(Commodity Commodity, Model model) { // user:��ͼ�㴫�����Ʋ�ı�����model�����Ʋ㷵�ظ���ͼ��Ķ���
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
    public String Save(User user,Userdetails userdetails, Model model) { // user:��ͼ�㴫�����Ʋ�ı�����model�����Ʋ㷵�ظ���ͼ��Ķ���
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
