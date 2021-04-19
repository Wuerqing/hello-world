package com.oak.service;

import com.oak.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{
	@Autowired
	private TestMapper testMapper;
	@Override
	public String getTime() {
		System.out.println("获取当前时间"+testMapper.getTime());
		return testMapper.getTime();
	}
	
	public static void main(String[] args) {
		int i = 1;
		int j;
		j = i++;
		System.out.println("j"+j);
		System.out.println("i"+i);
		
		int q = 2;
		for (int k = 0; k < 2; k++) {
			q =q++;
		}
		System.out.println("q:"+q);
		
	}

}
