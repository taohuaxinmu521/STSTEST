package com.example.demo.springRestTemplateTest.restfare;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.springRestTemplateTest.common.PersonRehiredVo;
import com.example.demo.springRestTemplateTest.common.User;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserListDao userDao;
	@SuppressWarnings("null")
	@Override
	public List<String> getUserList() {
		List<String> list = new ArrayList<String>();
		List<User> userList = userDao.getUserList();
		
		for(User u : userList ){
			list.add(String.valueOf(u.getW3cAccount()));
		}
		
		return list;
	}
	
	@Override
	public int updatePersonRehired(List<PersonRehiredVo> list) {
	   	
		int effect = userDao.updatePersonRehired(list);
		
		return effect;
	}

}
