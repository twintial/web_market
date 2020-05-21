package com.web.market.dto;

import com.web.market.model.Goods;
import lombok.Data;

import java.util.List;

@Data
public class CartListParam {

    private List<Goods> checkoutList;
}
