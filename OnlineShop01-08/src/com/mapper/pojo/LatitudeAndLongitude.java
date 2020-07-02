package com.mapper.pojo;

public class LatitudeAndLongitude {
 
	private double Longitude;
	private double Latitude;
	public double getLongitude() {
		return Longitude;
	}
	public void setLongitude(double lng) {
		Longitude = lng;
	}
	public double getLatitude() {
		return Latitude;
	}
	public void setLatitude(double lat) {
		Latitude = lat;
	}
	@Override
	public String toString() {
		return "LatitudeAndLongitude [Longitude=" + Longitude + ", Latitude="
				+ Latitude + "]";
	}

	
}
