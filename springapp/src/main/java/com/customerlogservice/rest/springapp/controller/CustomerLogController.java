package com.customerlogservice.rest.springapp.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<CustomerLog> updateCheckIn(@RequestParam String name) {
		CustomerLog user = jpaRepo.findByname(name);
		user.setLogType("IN");
		user.setDate(getCurrDate());
		user.setTime(getCurrTime());
		user.setId(user.getName()+getCurrTime());
		
		jpaRepo.save(user);
		return new ResponseEntity<CustomerLog>(user, HttpStatus.OK);
	}
	@GetMapping("/checkOut")
	public ResponseEntity<CustomerLog> updateCheckOut(@RequestParam String name) {
		CustomerLog user = jpaRepo.findByname(name);
		user.setLogType("OUT");
		user.setDate(getCurrDate());
		user.setTime(getCurrTime());
		user.setId(user.getName()+getCurrTime());
		
		jpaRepo.save(user);
		return new ResponseEntity<CustomerLog>(user, HttpStatus.OK);
	}
	
	@GetMapping("/getLog")
	public ResponseEntity<List<CustomerLog>> getByDate(@RequestParam String date) {
		
		List<CustomerLog> customerLogs = jpaRepo.findBydate(date);
		return new ResponseEntity<List<CustomerLog>>(customerLogs, HttpStatus.OK);
	}
	
	@GetMapping("/getAllLog")
	public ResponseEntity<List<CustomerLog>> getAllLog(@RequestParam String date) {
		
		List<CustomerLog> customerLogs = jpaRepo.findAll();
		return new ResponseEntity<List<CustomerLog>>(customerLogs, HttpStatus.OK);
	}
	
		
	

}
