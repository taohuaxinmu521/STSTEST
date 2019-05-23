package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Goods {
	private Long id;

	private String goodsName;

	private String goodsTitle;

	private String goodsImg;

	private String goodsDetail;

	private Double goodsPrice;

	private Integer goodsStock;

}
