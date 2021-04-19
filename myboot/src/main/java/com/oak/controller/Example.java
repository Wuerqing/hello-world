package com.oak.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Example {
	@RestController
	class ThisWillActuallyRun {

	    @RequestMapping("/")
	    String home() {
	    	return "hello world how are you";
	    }

	}
	static public  void main(String[] args) {
		String s = null;
		System.out.println(s.length());
	}
	
}
