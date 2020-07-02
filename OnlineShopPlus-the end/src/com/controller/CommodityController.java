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
	
	//�û�������
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
	/*request��ǰ�����������ȫ����װ������
	 * filename���������ļ�����
	 * out����ǰ�˻ص�������ӡ����·�������·��*/
	public void uploadPic(HttpServletRequest request,String fileName,PrintWriter out)
	{
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
