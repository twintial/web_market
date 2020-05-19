package com.web.market.model;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
/**
 * @Author:shenjunjie
 * @Description:OrderInfo构建
 * @Date:2020/05/19
 */

@Data
@Table(name="order_info")
public class OrderInfo implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_info_id")
	private Integer orderInfoId;//

    @Column(name = "order_id")
	private String orderId;//

    @Column(name = "goods_id")
	private Integer goodsId;//

    @Column(name = "count")
	private Integer count;//
}
