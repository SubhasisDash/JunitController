package com.example.service.impl;

import com.example.dto.BeanPojo;
import com.example.service.HelloService;

public class HelloServiceImpl implements HelloService{

	@Override
	public String helloService() {
		return "Hello";
	}

	@Override
	public BeanPojo getData() {
		BeanPojo bean=new BeanPojo();
		bean.setFirst("Subhasis");
		bean.setFirst("Dash");
		return bean;
	}

}
