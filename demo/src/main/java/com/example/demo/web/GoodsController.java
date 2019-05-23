package com.example.demo.web;

import com.example.demo.model.MiaoshaUser;
import com.example.demo.service.GoodsService;
import com.example.demo.vo.GoodsVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by tanwen on 2018/9/15.
 */
@Controller
@RequestMapping("goods")
public class GoodsController {
	
	@Autowired
	GoodsService goodsService;

 
    @RequestMapping(value="/to_list")
    public ModelAndView list(Model model, MiaoshaUser user) {
    	List<GoodsVo> goodsList = goodsService.listGoodsVo();
        model.addAttribute("goodsList", goodsList);
        return new ModelAndView("goods_list");
    }

    
}
