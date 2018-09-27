package com.capgemini.hotelSearch;

import java.util.Date;

public class HotelPojo {
	
	@Override
	public String toString() {
		return "HotelPojo [hotelName=" + hotelName + ", location=" + location + ", doubleFare="
				+ doubleFare + ", singleFare=" + singleFare + ", rating=" + rating + "]";
	}


	private int hotelId;
	private String hotelName;
	private String city;
	private String location;
	private String date;
	private int doubleBed;
	private int singleBed;
	private double doubleFare;
	private double singleFare;
	private int rating;
	
	
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getDoubleBed() {
		return doubleBed;
	}
	public void setDoubleBed(int doubleBed) {
		this.doubleBed = doubleBed;
	}
	public int getSingleBed() {
		return singleBed;
	}
	public void setSingleBed(int singleBed) {
		this.singleBed = singleBed;
	}
	public double getDoubleFare() {
		return doubleFare;
	}
	public void setDoubleFare(double doubleFare) {
		this.doubleFare = doubleFare;
	}
	public double getSingleFare() {
		return singleFare;
	}
	public void setSingleFare(double singleFare) {
		this.singleFare = singleFare;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	public HotelPojo(String hotelName, String location, double doubleFare, double singleFare, int rating) {
		super();
		
		this.hotelName = hotelName;
		this.location = location;
		this.doubleFare = doubleFare;
		this.singleFare = singleFare;
		this.rating = rating;
	}

}
