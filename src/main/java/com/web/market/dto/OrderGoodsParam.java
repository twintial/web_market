package com.web.market.dto;

import com.web.market.model.Goods;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderGoodsParam {

    private List<Goods> goodsList;

    private String orderId;

    private Date createTime;

    private double total;
}
