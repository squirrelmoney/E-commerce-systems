package com.mapper.pojo;

import java.util.List;

import com.mapper.pojo.LatitudeAndLongitude;
import com.mapper.pojo.Warehouse;

public interface chooseWarehouseDao {
	public LatitudeAndLongitude getLngAndLat(String address);
    public  String loadJSON(String url) ;
    public  double getDistance(double longitude1, double latitude1, double longitude2, double latitude2);
}
