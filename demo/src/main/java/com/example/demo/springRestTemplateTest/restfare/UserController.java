package com.example.demo.springRestTemplateTest.restfare;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
public class UserController {
	@Autowired
	private UserServiceImpl IUserService;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public JSONObject getAllUsers(){
		JSONObject result = new JSONObject();
		List<String> userList = IUserService.getUserList();
		try {
			if (null != userList) {
				result.put("code", 0);
				result.put("result", userList);
			} 
		} catch (Exception e) {
			result.put("code", -1);
			result.put("errorInfo", e.getMessage());
		}
		return result;
	}

}
