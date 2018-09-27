package com.cloud;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerControllerClient 
{
@Autowired
private LoadBalancerClient loadBalancer;
@RequestMapping(value="/getEmployee",method=RequestMethod.GET)
public String getEmployee()
{
	ServiceInstance si=loadBalancer.choose("employee-producer");
	System.out.println(si.getUri());
String baseUrl=si.getUri().toString()+"/employee";

RestTemplate restTemplate=new RestTemplate();
ResponseEntity<String>response=null;
try
{
response=restTemplate.exchange(baseUrl,HttpMethod.GET,getHeaders(),String.class);
}
catch(Exception e)
{
	System.out.println(e);
}
System.out.println(response.getBody());
return response.getBody();
}
private static HttpEntity<?>getHeaders() throws IOException
{
HttpHeaders headers=new HttpHeaders();
headers.set("Accept",MediaType.APPLICATION_JSON_VALUE);
return new HttpEntity<>(headers);
}
}

