package com.example.demo.springRestTemplateTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

@RestController
public class SpringRestTemplateController {
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ClientHttpRequestFactory clientHttpRequestFactory;
	
	@RequestMapping(value = "/testGetAction",method =RequestMethod.GET)
    public Object getJson() {
        JSONObject json = new JSONObject();
        json.put("username", "tester");
        json.put("pwd", "123456748");
        return json;
    }
	
	@RequestMapping(value = "/getApi",method = RequestMethod.GET)
    public String testGet() {
        String url = "http://localhost:8080/testGetAction";
        JSONObject json = restTemplate.getForEntity(url, JSONObject.class).getBody();
        JSONObject js = restTemplate.getForObject(url, JSONObject.class);
        return js.toJSONString();
    }
	
	
	
	@RequestMapping(value = "/testGetBook",method =RequestMethod.GET)
    public Book getBook() {
        Book b = new Book();
        b.setId(1);
        b.setLength("123");
        b.setName("wq");
        return b;
    }
	
	@RequestMapping(value = "/getBook",method = RequestMethod.GET)
    public Book testGetBook() {
        String url = "http://localhost:8080/testGetBook";
        Book b = restTemplate.getForObject(url, Book.class);
        System.out.println(b);
        System.out.println(clientHttpRequestFactory);
        return b;
    }
	
	 	
	 	//@RequestMapping(value = "testPsotAction",method = RequestMethod.POST)
		@PostMapping(value = "/testPostAction")
		
	    public Object postJson(@RequestBody JSONObject param) {
	        System.out.println(param.toJSONString());
	       param.put("action", "post");
	        param.put("username", "tester");
	        param.put("pwd", "123456748");
	        return param;
	    }

	    //@RequestMapping(value = "postApi",method = RequestMethod.POST)
	 	@PostMapping(value = "/postApi")
	    public Object testPost() {
	        String url = "http://localhost:8080/testPostAction";
	        JSONObject postData = new JSONObject();
	        postData.put("descp", "request for post");
	        JSONObject json = restTemplate.postForEntity(url, postData, JSONObject.class).getBody();
	        
	        return json.toJSONString();
	    }
	 	
	 	@PostMapping(value = "/posta")
	    public Object test1(String name) {
	      
	        return name;
	    }
	 	
	 	@PostMapping(value = "/postb")
	    public Object test1() {
	      
	        return "qw";
	    }


	
}

