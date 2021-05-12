package com.customerlogservice.rest.springapp.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.customerlogservice.rest.springapp.model.CustomerLog;
import com.customerlogservice.rest.springapp.repository.CustomerLogJpaRepository;


@RestController
public class CustomerLogController {
	static String  getCurrDate() {
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		   LocalDateTime now = LocalDateTime.now();  
		   return dtf.format(now).toString();
	}
	 static String  getCurrTime() {
	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
	   LocalDateTime now = LocalDateTime.now();  
	   return dtf.format(now).toString();  
	    }
	@Autowired
	private CustomerLogJpaRepository jpaRepo;
	
	@GetMapping("/checkIn")
	public @ResponseBody CustomerLog updateCheckIn(@RequestParam String name) {
		CustomerLog user = jpaRepo.findByname(name);
		user.setLogType("IN");
		user.setDate(getCurrDate());
		user.setTime(getCurrTime());
		user.setId(user.getName()+getCurrTime());
		
		jpaRepo.save(user);
		return user;
	}
	@GetMapping("/checkOut")
	public @ResponseBody CustomerLog updateCheckOut(@RequestParam String name) {
		CustomerLog user = jpaRepo.findByname(name);
		user.setLogType("OUT");
		user.setDate(getCurrDate());
		user.setTime(getCurrTime());
		user.setId(user.getName()+getCurrTime());
		
		jpaRepo.save(user);
		return user;
	}
	
	@GetMapping("/getLog")
	public @ResponseBody  List<CustomerLog> getByDate(@RequestParam String date) {
		
		return jpaRepo.findBydate(date);
	}
	
	@GetMapping("/getAllLog")
	public @ResponseBody  List<CustomerLog> getAllLog(@RequestParam String date) {
		
		return jpaRepo.findAll();
	}
	
		
	

}
