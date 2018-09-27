package com.capgemini.flightSearch;

import java.util.List;


import org.springframework.stereotype.Service;
@Service
public class FlightService {			
		FlightDao flightDao=new FlightDao();
		public boolean findBySource(String source,int id)
		{	
			return flightDao.findBySource(source,id);		
		}	
		public boolean findByDestination(String destination,int id)
		{
			return flightDao.findByDestination(destination,id);
		}
		public double findByClass(String classType,int noOfSeats,String journeyDate,int id)
		{
			return flightDao.findByClass(classType,noOfSeats,journeyDate,id);
		}
		public List<FlightPojo> availableFlights(String source,String destination,String journeyDate,String classType,int seats)
		{
			return flightDao.availableFlights(source,destination,journeyDate,classType,seats);
		}	
		
	}
