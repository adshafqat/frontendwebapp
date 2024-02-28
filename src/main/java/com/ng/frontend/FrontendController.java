package com.ng.frontend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@RestController
public class FrontendController {


	@Autowired
	private BackendserverProperties backendserverProperties;
	
	@Value("${testurl}")
   	private String urlvalue;
	
	@GetMapping("/")
	public String returnResponse() {
		System.out.println("This is a test application. URL1:"+urlvalue+" URL2:"+backendserverProperties.getUrl());		
		return "This is a test application. URL1:"+urlvalue+". URL2 value is :"+backendserverProperties.getUrl()+" Port:"+backendserverProperties.getPort();
	}

	@GetMapping(value = "/callbackend")
	private String backendCaller()
	{
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(backendserverProperties.getUrl(), String.class);
	    return "Here I am printing Results :"+result; 
	}


}
