package com.example.demo.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.Goods;
import com.example.demo.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



public interface GoodsDao extends BaseMapper<Goods> {
	
	@Select("select g.id,g.goods_stock as goodsStock,g.goods_detail as goodsDetail,g.goods_name as goodsName,g.goods_img as goodsImg,g.goods_price as goodsPrice,mg.stock_count as stockCount, mg.start_date as startDate, mg.end_date as endDate,mg.miaosha_price as miaoshaPrice from miaosha_goods mg left join goods g on mg.goods_id = g.id")
	public List<GoodsVo> listGoodsVo();

	@Select("select g.id,g.goods_stock as goodsStock,g.goods_detail as goodsDetail,g.goods_name as goodsName,g.goods_img as goodsImg,g.goods_price as goodsPrice,mg.stock_count as stockCount, mg.start_date as startDate, mg.end_date as endDate,mg.miaosha_price as miaoshaPrice from miaosha_goods mg left join goods g on mg.goods_id = g.id where g.id = #{goodsId}")
	public GoodsVo getGoodsVoByGoodsId(@Param("goodsId") long goodsId);

	/*@Update("update miaosha_goods set stock_count = stock_count - 1 where goods_id = #{goodsId} and stock_count > 0")
	public int reduceStock(MiaoshaGoods g);

	@Update("update miaosha_goods set stock_count = #{stockCount} where goods_id = #{goodsId}")
	public int resetStock(MiaoshaGoods g);*/
	
}
