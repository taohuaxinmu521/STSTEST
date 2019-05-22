package com.example.demo.springRestTemplateTest.test;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import com.example.demo.springRestTemplateTest.common.PersonRehiredVo;

public interface EmplyeeNumberMapper {
	
	
	
	@Update("update hr_user_histroy set oldW3caccount = #{oldW3caccount} where w3cAccount = #{w3cAccount}")
	public void updatePersonRehired(List<PersonRehiredVo> users);

}
