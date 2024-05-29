package com.teamgreen.userservice.controller;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	public static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@GetMapping("/greet")
	public String greeting() {
		return "Hello employee";
	}
	
	@GetMapping("/dept-employes")
	public String callingFromDept() throws Exception {
		log.info("calling daprtment and employee service");
		if(true)
			throw new FileNotFoundException("error from employee servie.");
		return "Departmetn - calling employee service";
	}
	
}
