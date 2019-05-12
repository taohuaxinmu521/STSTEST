package com.example.demo.web;

import com.example.demo.model.MiaoshaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by tanwen on 2018/9/15.
 */
@Controller
@RequestMapping("goods")
public class GoodsController {

 
    @RequestMapping(value="/to_list")
    public ModelAndView list(Model model, MiaoshaUser user) {
       
        return new ModelAndView("goods_list");
    }

    
}
