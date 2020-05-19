package com.web.market.model;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.Double;
import java.lang.String;
import java.lang.Integer;
/**
 * @Author:shenjunjie
 * @Description:Goods构建
 * @Date:2020/05/19
 */

@Data
@Table(name="goods")
public class Goods implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_id")
	private Integer goodsId;//

    @Column(name = "goods_name")
	private String goodsName;//

    @Column(name = "type_id")
	private String typeId;//

    @Column(name = "price")
	private Double price;//

    @Column(name = "img")
	private String img;//

    @Column(name = "goods_content")
	private String goodsContent;//

    @Column(name = "goods_count")
	private Integer goodsCount;//
}
