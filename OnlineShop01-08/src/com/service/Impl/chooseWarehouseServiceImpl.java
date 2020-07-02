package com.service.Impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import net.sf.json.JSONObject;

import com.mapper.pojo.LatitudeAndLongitude;
import com.mapper.pojo.Warehouse;
import com.mapper.pojo.chooseWarehouseDao;
import com.service.IchooseWarehouseService;
@Service
public class chooseWarehouseServiceImpl implements IchooseWarehouseService {
	@Autowired 
    private chooseWarehouseDao  chooseWarehouseDao;
	@Autowired
	private IchooseWarehouseService  IchooseWarehouseService;
	@Override
	public double getdistance(String adreess, String destination) {
		LatitudeAndLongitude lngAndLat1 = chooseWarehouseDao.getLngAndLat(adreess);
		LatitudeAndLongitude lngAndLat2 = chooseWarehouseDao.getLngAndLat(destination);
		double distance = chooseWarehouseDao.getDistance
		(lngAndLat1.getLongitude(), lngAndLat1.getLatitude(), lngAndLat2.getLongitude(), lngAndLat2.getLatitude());
		return distance;
	}
	
	
	@Override
	public int chooseWarehouse(List<Warehouse> list,String destination) {
		int BestChoose=0;
		double temp=-1;
	for (Warehouse w : list) {
		double distance = IchooseWarehouseService.getdistance(w.getAddress(), destination);
		System.out.println(w.getAddress()+"æ‡¿Î "+destination+": "+distance);
		if(distance<temp&&temp!=-1){
		BestChoose=w.getWid();
		temp=distance;
		}else if(temp==-1){
			temp=distance;
			BestChoose=w.getWid();
		}
	}
	return BestChoose;
	}


}
