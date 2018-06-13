package com.example.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.BeanPojo;
import com.example.service.HelloService;

@RestController
public class ApiController {
	
	@Autowired
	HelloService helloService;
	
	 @GetMapping("/hi")
	 public String helloWorld() {
	        return helloService.helloService();
	 }

	 @GetMapping(value="/data", produces=MediaType.APPLICATION_JSON_VALUE)
	 public BeanPojo data() {
	    return helloService.getData();
		
	 }
	 
	 @PostMapping(value="/postData",consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	 public BeanPojo dataPost(@RequestBody BeanPojo pojo) {
		  return new BeanPojo(pojo);
		}
	 

}
