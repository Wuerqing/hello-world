package com.oak.controller;

import com.oak.entity.ConfigParamGet;
import com.oak.entity.User;
import com.oak.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private TestService testService;


	//从配置文件获取参数
	@Value("${url.orderUrl}")
	private String orderUrl;
	@Value(("${ddd.youUrl}"))
	private String ddd;
	@Resource
	private ConfigParamGet configParamGet;
	
	@RequestMapping("/getTime")
	public String getTime(Model model){
		String timeString = testService.getTime();
		model.addAttribute("time", timeString);
		return "test";
	}
	@RequestMapping("/user")
	public User getUser(){
		return new User((long) 1,"刘亦菲","20");
	}
	@RequestMapping("/list")
	public List<User> getList(){
		ArrayList<User> list = new ArrayList<>();
		User user = new User((long) 1, "张韶涵", "20");
		User user1 = new User((long) 2,"赵敏","23");
		list.add(user);
		list.add(user1);
		return list;
	}
	@RequestMapping("/map")
	public Map<String,Object> getMap(){
		HashMap<String, Object> map = new HashMap<>();
		User user1 = new User((long) 2,"赵敏",null);
		map.put("笔者",user1);
		map.put("年龄",null);
		return  map;
	}
	@RequestMapping("/getParam")
	public void getParam(){
		logger.info("==========orderURL:"+orderUrl);
		logger.info("==========ddd:"+ddd);
	}

	@RequestMapping("/config")
	public String testConfig() {
		logger.info("=====获取的订单服务地址为：{}", configParamGet.getOrderUrl());
		logger.info("=====获取的用户服务地址为：{}", configParamGet.getUserUrl());
		logger.info("=====获取的购物车服务地址为：{}", configParamGet.getShopUrl());

		return "success";
	}
}
