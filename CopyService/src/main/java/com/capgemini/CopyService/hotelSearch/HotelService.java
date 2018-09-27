package com.capgemini.hotelSearch;

import java.util.List;


import org.springframework.stereotype.Service;
@Service
public class HotelService {			
		HotelDao hotelDao=new HotelDao();
		public boolean findByCity(String city,int id)
		{	
			return hotelDao.findByCity(city,id);		
		}	
		public boolean findByDate(String date,int rooms,int id)
		{	
			return hotelDao.findByDate(date,rooms,id);		
		}	
		
		public List<HotelPojo> availableHotels(String city,String date,int rooms) 
		{
			/*String pattern = "MM/dd/yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			Date d=new Date("09/27/2018");
			String date = simpleDateFormat.format(d);
			System.out.println(d);*/
			return hotelDao.availableHotels(city,date,rooms);
			
		}	
		
	}

