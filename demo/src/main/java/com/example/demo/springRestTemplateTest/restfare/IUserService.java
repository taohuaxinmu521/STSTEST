package com.example.demo.springRestTemplateTest.restfare;

import java.util.List;

import com.example.demo.springRestTemplateTest.common.PersonRehiredVo;


public interface IUserService {
	
	/**
	 * 获取所有的用户列表
	 * @return
	 */
	public List<String> getUserList();
	
	/**
	 * 更新用户信息
	 * @param list
	 * @return
	 */
	public int updatePersonRehired(List<PersonRehiredVo> list);

}
