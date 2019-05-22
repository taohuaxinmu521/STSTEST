package com.example.demo.springRestTemplateTest.restfare;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.springRestTemplateTest.common.PersonRehiredVo;
import com.example.demo.springRestTemplateTest.common.User;


public interface UserListDao {
	/**
	 * 获取所有的用户
	 * @return
	 */
	 @Select(value = { "select * from hr_user" })
	public List<User> getUserList();
	 
	 
	/**
	 *  更新用户
	 * @param list  需要更新的用户列表
	 * @return
	 */
	@Update(value = {"update hr_user_histroy set oldW3caccount = #{oldW3caccount} where w3cAccount = #{w3cAccount}"})
	public int updatePersonRehired(List<PersonRehiredVo> list);

}
