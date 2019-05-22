package com.example.demo.web;

import com.example.demo.result.Result;
import com.example.demo.service.MiaoshaUserService;
import com.example.demo.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by tanwen on 2018/9/8.
 */
@Controller
@RequestMapping("seckill")
public class SeckillUserController {

    @Autowired
    private MiaoshaUserService userService;
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("loginPage")
    public ModelAndView loginPage(){
        return new ModelAndView("seckillLogin");
    }

    @RequestMapping("do_login")
    @ResponseBody
    public Result<String> login(HttpServletResponse response, @Valid LoginVo loginVo){
    	Result<String> result = userService.login(response, loginVo);
    	logger.info("用户：" + loginVo.getMobile() + " 登陆成功！");
        return result;
    }
}
