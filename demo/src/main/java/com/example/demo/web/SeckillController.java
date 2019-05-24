package com.example.demo.web;


import com.example.demo.model.MiaoshaOrder;
import com.example.demo.model.MiaoshaUser;
import com.example.demo.result.CodeMsg;
import com.example.demo.service.GoodsService;
import com.example.demo.service.MiaoshaService;
import com.example.demo.service.OrderService;
import com.example.demo.vo.GoodsVo;
import com.example.demo.vo.OrderInfo;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by tanwen on 2018/9/23.
 */
@Controller
@RequestMapping("seckill")
public class SeckillController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private MiaoshaService miaoshaService;
    
    private Logger logger = LoggerFactory.getLogger(SeckillController.class);

    @RequestMapping("do_seckill")
    public String doSeckill(Model model, MiaoshaUser user, @RequestParam("goodsId")long goodsId){
        if (user == null) {
            return "seckillLogin";
        }
        user.setId(17782531931l);//暂时先这样
        //判断库存
        GoodsVo goodsVo = goodsService.getGoodsVoByGoodsId(goodsId);
        int count = goodsVo.getStockCount();
        if (count < 0){
            model.addAttribute("seckill_over", CodeMsg.MIAO_SHA_OVER.getMsg());
            return "seckill_error";
        }
        //判断是否重复秒杀
        MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(user.getId(),goodsId);
        if (order != null) {
            model.addAttribute("seckill_over",CodeMsg.REPEATE_MIAOSHA.getMsg());
            return "seckill_error";
        }
        
        logger.info("开始秒杀操作，，，，，，，，，，，，，，，，，");
        
        //开始秒杀操作
        OrderInfo orderInfo = miaoshaService.miaosha(user,goodsVo);
        model.addAttribute("orderInfo",orderInfo);
        model.addAttribute("goods",goodsVo);
        logger.info("秒杀成功，，，，，，，，，，，，，，，，，");
        return "order_detail";
    }
}
