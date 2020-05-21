package com.web.market.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class CartItemParam implements Serializable {

    private Integer goodsId;//

    private String goodsName;//

    private String typeId;//

    private Double price;//

    private String img;//

    private String goodsContent;//

    private Integer goodsCount;//

    private Integer cartId;
}
