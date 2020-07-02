package com.service;

import java.util.List;

import com.mapper.pojo.LatitudeAndLongitude;
import com.mapper.pojo.Warehouse;

public interface IchooseWarehouseService {
	public double getdistance(String adreess,String destination);
	public int chooseWarehouse(List<Warehouse> list,String destination);
}
