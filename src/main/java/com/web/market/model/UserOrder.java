package com.web.market.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.Double;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;
/**
 * @Author:shenjunjie
 * @Description:UserOrder构建
 * @Date:2020/05/19
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_order")
public class UserOrder implements Serializable{

	@Id
    @Column(name = "order_id")
	private String orderId;//

    @Column(name = "user_id")
	private Integer userId;//

    @Column(name = "total_cost")
	private Double totalCost;//

    @Column(name = "create_time")
	private Date createTime;//

    @Column(name = "status")
	private String status;//
}
