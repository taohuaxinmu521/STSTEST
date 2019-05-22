package com.example.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.DemoApplication;
import com.example.demo.dao.TestMyBatis;
import com.example.demo.model.Girl;
import com.example.demo.redis.RedisService;
import com.example.demo.redis.UserKey;
import com.example.demo.result.Result;

@Controller
public class TestController {
	
	@Autowired
	private RedisService redisService;
	
	@Autowired
	private TestMyBatis testMyBatis;
	
	private Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	
	
	@RequestMapping("hello")
	@ResponseBody
	public String TestWeb(){
		return "Hello Word";
	}
	
	@RequestMapping("index")
    public String index(ModelMap map){
        map.addAttribute("name","谈闻你好呐");
        logger.info("-----------测试成功-------------");
        return "hello";
    }
	
	@RequestMapping("insert")
	@ResponseBody
    public String insert(){
		Girl girl = new Girl();
		girl.setName("xiaofang");
		girl.setAge("20");
		girl.setCupSize("30");
		System.out.println(girl);
		testMyBatis.insert(girl);
        return "插入成功----------";
    }
	
	@RequestMapping("set")
	@ResponseBody
    public Result<Boolean> set(){
		Girl girl = new Girl();
		girl.setId(1000l);
		girl.setName("xiaofang");
		girl.setAge("20");
		girl.setCupSize("30");
		Boolean isSuccess= redisService.set(UserKey.getById,"id", girl);
        return Result.success(isSuccess);
    }
	
	@RequestMapping("get")
	@ResponseBody
    public Result<Girl> get(){
		Girl girl= redisService.get(UserKey.getById,"id", Girl.class);
        return Result.success(girl);
    }

}
