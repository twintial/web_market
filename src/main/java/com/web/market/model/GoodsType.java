package com.web.market.model;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
/**
 * @Author:shenjunjie
 * @Description:GoodsType构建
 * @Date:2020/05/19
 */

@Data
@Table(name="goods_type")
public class GoodsType implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
	private Integer typeId;//

    @Column(name = "type_name")
	private String typeName;//
}
