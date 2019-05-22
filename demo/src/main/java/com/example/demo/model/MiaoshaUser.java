package com.example.demo.model;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MiaoshaUser {
	private Long id;
	private String nickname;
	private String password;
	private String salt;
	private String head;
	private Date registerDate;
	private Date lastLoginDate;
	private Integer loginCount;
	
}
