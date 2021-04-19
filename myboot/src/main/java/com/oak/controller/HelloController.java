package com.oak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@ResponseBody
	@RequestMapping("/hello")
	public String hello(){
		return "hi boot";
	}
	@RequestMapping("/hi")
	public String hi(){
		return "hi";
	}
	
	public static void main(String[] args) {
		String s1= "hello";
		String s2= "world";
		String s3= "helloworld";
		System.out.println(s1+s2==s3);
		System.out.println(s1+"world"==s3);
		System.out.println("hello"+"world"==s3);
		System.out.println("hello"+"world"=="helloworld");
		
	}
	
}
