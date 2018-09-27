package com.capgemini;

public class LRMain {

	public static void main(String[] args) {
		
		
		UserService ob=new UserService(null);
		System.out.println(ob.findByUserName("Ashwini").getUserMail());
		// TODO Auto-generated method stub

	}

}
