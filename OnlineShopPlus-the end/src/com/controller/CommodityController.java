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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.coms.Commons;
import com.mapper.pojo.Commodity;
import com.mapper.pojo.User;
import com.mapper.pojo.Warehouse;
import com.service.ICommodityService;
import com.service.Impl.CommodityServiceImpl;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Controller
@RequestMapping("CommodityController")
public class CommodityController
{
	@Autowired
	private ICommodityService commodityService;
	
	//用户看到的
	@RequestMapping("UserCommodity.do")
	public String UserCommodity(HttpServletRequest request,Model m)
	{
		List<Commodity> list = commodityService.selectByExample(null);
		m.addAttribute("list", list);	
		return "UserCommodity";
	}
	
	@RequestMapping("selectCommodity.do")
	public String getAllCommodity(Model m)
	{
		List<Commodity> list = commodityService.selectByExample(null);
		m.addAttribute("list", list);
		return "AllCommodity";
	}
	
	@RequestMapping("updateCommodity.do")
	public String updateCommodity(Integer cid,Model m)
	{
		System.out.println(cid);
		Commodity c = commodityService.selectByPrimaryKey(cid);
		m.addAttribute("commodity", c);
		return "updateCommodity";
	}
	
	@RequestMapping("update.do")
	public String update(Commodity c)
	{
		commodityService.updateByPrimaryKeySelective(c);
		return "redirect:selectCommodity.do";
	}
	
	@RequestMapping("uploadPic.do")
	/*request：前端提出的请求全部封装在里面
	 * filename：里面存放文件对象
	 * out：向前端回调函数打印绝对路径和相对路径*/
	public void uploadPic(HttpServletRequest request,String fileName,PrintWriter out)
	{
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
	
	@RequestMapping("insertCommodity.do")
	public String insertCommodity()
	{
		System.out.println("ndsjnfkjfn");
		return "insertCommdity";
	}
	
	@RequestMapping("insert.do")
	public String insert(Commodity c)
	{		
		commodityService.insertSelective(c);
		return "redirect:selectCommodity.do";
	}	
}
