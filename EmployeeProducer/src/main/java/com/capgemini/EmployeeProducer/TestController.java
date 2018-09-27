package com.capgemini.EmployeeProducer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestController {
	
	@RequestMapping(value="/employee" ,method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="getDataFallBack")
	public Employee firstPage()
	{
		Employee emp1=new Employee();
		emp1.setName("Ashwini");
		emp1.setDesignation("Analyst");
		emp1.setSalary(20000);
		emp1.setEmpid("155154");
		if(emp1.getName().equalsIgnoreCase("Ashwini"))
			throw new RuntimeException();
		
		return emp1;
		
		
	}
	
	public Employee getDataFallBack()
	{
		Employee emp1=new Employee();
		emp1.setName("fallback-Ashwini");
		emp1.setDesignation("fallback-manager");
		emp1.setSalary(40000);
		emp1.setEmpid("fallback-155154");
		
		
		return emp1;
		
		
	}

}
