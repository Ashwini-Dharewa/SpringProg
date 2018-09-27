package com.capgemini.hotelSearch;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HotelDao {
	
	//private int id;	
	Connection connection = null;
	
	public void connectDB() throws ClassNotFoundException, SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Ashwini", "angshuman");
	
	}
	
	
	public List<HotelPojo> availableHotels(String city,String date,int noOfRooms)
	{
		List<HotelPojo> hotels=new ArrayList<HotelPojo>();
		try
	    {
			 connectDB();
			 Statement statement = connection.createStatement();
			 ResultSet resultSet = statement.executeQuery("SELECT * FROM HOTELSLIST");
			 while (resultSet.next())
	         {
				 int id=resultSet.getInt("hotelID");
				 boolean isCity=findByCity(city,id);
				 boolean isDate=findByDate(date,noOfRooms,id);
				 if(isCity==true && isDate==true)
	        	 {
	        		 String name=resultSet.getString("hotelName");
	        		 String location=resultSet.getString("location");
	        		 double df=resultSet.getDouble("doubleFare");
	        		 double sf=resultSet.getDouble("singleFare");
	        		 int rating=resultSet.getInt("rating");
		        	 hotels.add(new HotelPojo(name,location,df,sf,rating));	        		 		 
	        	 }	        	
	          }			
	    }
		catch(Exception exception)
	    {
	        System.out.println("Error!!");
	    }
		return hotels;
	}
	
	

	public boolean findByCity(String city,int id)
	{
		try
	    {
			 connectDB();
			 Statement statement = connection.createStatement();
			 ResultSet resultSet = statement.executeQuery("SELECT city FROM HotelsLIST where hotelId='"+id+"'");
	         while (resultSet.next())
	         {
	            if((city.equals(resultSet.getString("city"))) )
	            {
	            	return true;
	            }  

	         }
	       return false;	        
	    } 
		catch(Exception exception)
	    {
	        System.out.println("Error!!");

	    }
		return false;
	}
	
	public boolean findByDate(String date,int noOfRooms,int id)
	{
		try
	    {
			 connectDB();
			 Statement statement = connection.createStatement();
			 ResultSet resultSet = statement.executeQuery("SELECT tripDate,singleBed,doubleBed FROM HotelsLIST where hotelId='"+id+"'");
	         while (resultSet.next())
	         {
	            if((date.equals(resultSet.getString("tripDate"))) )
	            {
	            	if(noOfRooms<=(resultSet.getInt("singleBed"))  || noOfRooms<=(resultSet.getInt("doubleBed")))
	            	return true;
	            }  

	         }
	       return false;	        
	    } 
		catch(Exception exception)
	    {
	        System.out.println("Error!!");

	    }
		return false;
	}
}
	
	
	
	
	
	