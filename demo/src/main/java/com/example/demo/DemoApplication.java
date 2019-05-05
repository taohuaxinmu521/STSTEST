package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@SpringBootApplication
public class DemoApplication {
	
	private Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
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
	

}


