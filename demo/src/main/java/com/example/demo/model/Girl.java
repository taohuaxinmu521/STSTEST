package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName(value="GIRL")
public class Girl {
	
	private Long id;
	
	private String age;
	
	private String cupSize;
	
	private String name;

}
