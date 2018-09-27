package com.capgemini.flightSearch;


import java.sql.Date;

 

public class FlightPojo

{



private String company;

private String source;

private String destination;

private String departureTime;

private String arrivalTime;

private Date date;

private int economySeats;

private int businessSeats;

private double economyFare;

private double businessFare;

private double fare;

private int flightID;

public int getFlightID() {

       return flightID;

}

public void setFlightID(int flightID) {

       this.flightID = flightID;

}

public FlightPojo(String company,String departureTime, String arrivalTime,double fare) {

super();

this.company = company;

this.departureTime = departureTime;

this.arrivalTime = arrivalTime;

this.fare = fare;

}

public String getCompany() {

return company;

}

public void setCompany(String company) {

this.company = company;

}

public String getSource() {

return source;

}

public void setSource(String source) {

this.source = source;

}

public String getDestination() {

return destination;

}

public void setDestination(String destination) {

this.destination = destination;

}

public String getDepartureTime() {

return departureTime;

}

public double getFare() {
	return fare;
}

public void setFare(double fare) {
	this.fare = fare;
}

public void setDepartureTime(String departureTime) {

this.departureTime = departureTime;

}

public String getArrivalTime() {

return arrivalTime;

}

public void setArrivalTime(String arrivalTime) {

this.arrivalTime = arrivalTime;

}

public Date getDate() {

return date;

}

public void setDate(Date date) {

this.date = date;

}

public int getEconomySeats() {

return economySeats;

}

public void setEconomySeats(int economySeats) {

this.economySeats = economySeats;

}

public int getBusinessSeats() {

return businessSeats;

}

public void setBusinessSeats(int businessSeats) {

this.businessSeats = businessSeats;

}

public double getEconomyFare() {

return economyFare;

}

public void setEconomyFare(double economyFare) {

this.economyFare = economyFare;

}

public double getBusinessFare() {

return businessFare;

}

public void setBusinessFare(double businessFare) {

this.businessFare = businessFare;

}

@Override
public String toString() {
	return "[company=" + company + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
			+ ", fare=" + fare + "]";
}

//@Override

/*public String toString() {

return "FlightPojo [company=" + company + ", source=" + source + ", destination=" + destination

+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", date=" + date

+ ", economySeats=" + economySeats + ", businessSeats=" + businessSeats + ", economyFare=" + economyFare

+ ", businessFare=" + businessFare + "]";

}

 

*/

}