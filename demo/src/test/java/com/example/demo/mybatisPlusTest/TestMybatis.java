package com.example.demo.mybatisPlusTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.TestMapper;
import com.example.demo.dao.UserDao;
import com.example.demo.model.MiaoshaUser;
import com.example.demo.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMybatis {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	TestMapper testMapper;
	
	@Test
	public void Test01(){
		MiaoshaUser user = userDao.selectById(13000000000l);
		System.out.println(user);
	}
	
	
	@Test
	public void Test02(){
		User user = new User("1000", "Kirby");
		testMapper.insert(user);
		System.out.println(user);
	}
	
	
	@Test
	public void Test03(){
		User user = testMapper.selectById("1000");
		System.out.println(user);
	}
	
	
	
	
	

}
