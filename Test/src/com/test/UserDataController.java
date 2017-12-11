package com.test;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/UserProfiles")
public class UserDataController {
	
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String showData() {
		System.out.println("-------------In Method------------------");
		
		return "HelloWorld"; 
	
		
		
	}
	

}
