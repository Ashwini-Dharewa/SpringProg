package com.capgemini.flightSearch;

import java.util.ArrayList;
import java.util.List;

public class FlightMain {

	public static void main(String[] args) {
		
		FlightService ob=new FlightService();
		List<FlightPojo> flights=new ArrayList<FlightPojo>();
		flights=ob.availableFlights("Kolkata", "Bangalore", "09/12/2018", "Economy", 36);
		System.out.println(flights);
		
		// TODO Auto-generated method stub

	}

}
