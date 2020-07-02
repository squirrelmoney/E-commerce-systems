package com.test;

import java.util.List;
import java.util.Random;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.controller.UserController;
import com.controller.WarehouseController;
import com.mapper.pojo.Commodity;
import com.mapper.pojo.User;
import com.mapper.pojo.UserExample;
import com.mapper.pojo.Warehouse;
import com.mapper.pojo.WarehouseKey;
import com.service.ICommodityService;
import com.service.IUserService;
import com.service.Impl.CommodityServiceImpl;

public class Test {
    private ApplicationContext ac;

	public ApplicationContext getAc(){
		return new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	//@org.junit.Test
/*    public void test(){
    	ApplicationContext  ac = new Test().getAc();
    	WarehouseController c=(WarehouseController) ac.getBean("warehouseController");//通过spring获取需要的对象，注解component。。。
    	UserController u=(UserController) ac.getBean("userController");
    	List<Commodity> selectAll = ICommodityService.selectAll(null);
        c.apportion("湖南省长沙市岳麓区湖南大学", selectAll);
        u.selectById("admin");

    }*/
	@org.junit.Test
	public void test1(){
		Random a=new Random();
		for (int i = 0; i < 5; i++) {
			System.out.println(a.nextInt(10));
		}
	}
}
