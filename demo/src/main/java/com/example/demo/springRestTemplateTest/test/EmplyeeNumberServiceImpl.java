package com.example.demo.springRestTemplateTest.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.springRestTemplateTest.common.PersonRehiredVo;

@Service
public class EmplyeeNumberServiceImpl implements IEmplyeeNumberService{
	
	@Autowired
	private EmplyeeNumberMapper emplyeeNumberMapper;

	@Override
	public void updatePersonRehired(List<PersonRehiredVo> users) {
		
		List<String> list = new ArrayList<String>();
		for(PersonRehiredVo p : users){
			list.add(p.getOldW3account());
		}
		//要不要根据工号查询员工是否存在
		
		
		emplyeeNumberMapper.updatePersonRehired(users);
		
		
		
	}

}
