package com.example.demo.springRestTemplateTest.test;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.springRestTemplateTest.common.PersonRehiredVo;

@RestController
public class EmplyeeNumberCollectController {
	
	@Autowired
	private EmplyeeNumberServiceImpl emplyeeNumberService;
	
	@RequestMapping("/updatePersonRehired")
	public JSONObject updatePersonRehired(List<PersonRehiredVo> users){
		JSONObject result = new JSONObject();
		try {
			if(CollectionUtils.isNotEmpty(users)){
				emplyeeNumberService.updatePersonRehired(users);
			}
			result.put("code", 0);
		} catch (Exception e) {
			
			result.put("code", -1);
			result.put("errorInfo", e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
	

}
