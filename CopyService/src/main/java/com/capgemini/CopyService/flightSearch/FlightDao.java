package com.capgemini.flightSearch;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;

 

public class FlightDao {

                Connection connection = null;

                public void connectDB() throws ClassNotFoundException, SQLException

                {

                                Class.forName("oracle.jdbc.driver.OracleDriver");

                                connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Ashwini", "angshuman");

               

                }             

               

               

               

                public boolean findBySource(String source,int id)

                {

                                try

                    {

                                                connectDB();

                                                Statement statement = connection.createStatement();

                                                ResultSet resultSet = statement.executeQuery("SELECT source FROM FLIGHTLIST where flightId='"+id+"'");

                         while (resultSet.next())

                         {

                            if((source.equals(resultSet.getString("source"))) )

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

               

               

               

                public boolean findByDestination(String destination,int id)

                {

                try

    {

                                connectDB();

                                Statement statement = connection.createStatement();

                                ResultSet resultSet = statement.executeQuery("SELECT destination FROM FLIGHTLIST where flightId='"+id+"'");

        while (resultSet.next())

        {

            if((destination.equals(resultSet.getString("destination"))) )

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

               

               

               

                public double findByClass(String classType,int noOfSeats,String journeyDate,int id)

                {

                                try

                    {

                                                connectDB();

                                                Statement statement = connection.createStatement();

                                                if(classType.equalsIgnoreCase("Economy"))

                                                {

                                                                ResultSet resultSet = statement.executeQuery("SELECT economySeats,economyFare FROM FLIGHTLIST where journeyDate='"+journeyDate+"' and flightId='"+id+"'");

                                                                while(resultSet.next())

                                                                {

                                                                                if(noOfSeats<=(resultSet.getInt("economySeats")))

                                                                                                return (resultSet.getDouble("economyFare"));

                                                                }

                                                }

                                                else if(classType.equalsIgnoreCase("Business"))

                                                {

                                                                ResultSet resultSet = statement.executeQuery("SELECT businessSeats,businessFare FROM FLIGHTLIST where journeyDate='"+journeyDate+"' and flightId='"+id+"'");

                                                                while(resultSet.next())

                                                                {

                                                                                if(noOfSeats<=(resultSet.getInt("businessSeats")))

                                                                                                return(resultSet.getDouble("businessFare"));

                                                                }

                                                }

                                               

                    }

                                catch(Exception exception)

                    {

                        System.out.println("Error!!");

                    }

                                return 0;

                }

                               

                public List<FlightPojo> availableFlights(String source,String destination,String journeyDate,String classType,int seats)

                {

                       List<FlightPojo> flights=new ArrayList<FlightPojo>();

                       try

                    {

                              connectDB();

                              Statement statement = connection.createStatement();

                              ResultSet resultSet = statement.executeQuery("SELECT * FROM FLIGHTLIST");

                             

                               while (resultSet.next())

                         {

                                    double fare=0;

                                    //int id=resultSet.getInt("flightID");

                                    if((source.equals(resultSet.getString("source"))) && (destination.equals(resultSet.getString("destination"))) && (journeyDate.equals(resultSet.getString("journeyDate"))))

                                    {

                                          

                                            if(classType.equalsIgnoreCase("Economy"))

                                           {

                                                  if(seats<=(resultSet.getInt("economySeats")))

                                                                fare=resultSet.getDouble("economyFare");                                  

                                            }

                                           else

                                           {

                                                  if(seats<=(resultSet.getInt("businessSeats")))

                                                         fare=resultSet.getDouble("businessFare");

                                           }

                                          

                                     }

                                    if(fare>0)

                                    {

                                             String company=resultSet.getString("company");

                                             String at=resultSet.getString("arrivalTime");

                                             String dt=resultSet.getString("departureTime");

                                             flights.add(new FlightPojo(company,dt,at,fare));
                                             

                                    }                        

                                          

                          }  
                               connection.close();

                    }

                       catch(Exception exception)

                    {

                        System.out.println("Error!!");

                    }

                       return flights;

                }     


}

