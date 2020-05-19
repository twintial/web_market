package com.web.market.model;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.Integer;
/**
 * @Author:shenjunjie
 * @Description:ShopCar构建
 * @Date:2020/05/19
 */

@Data
@Table(name="shop_car")
public class ShopCar implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_car_id")
	private Integer shopCarId;//

    @Column(name = "user_id")
	private Integer userId;//

    @Column(name = "goods_id")
	private Integer goodsId;//

    @Column(name = "count")
	private Integer count;//
}
