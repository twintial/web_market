package com.web.market.dao;

import com.web.market.model.Goods;
import com.web.market.model.UserOrder;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:shenjunjie
 * @Description:UserOrderDao构建
 * @Date:2020/05/19
 *****/
@Repository
public interface UserOrderMapper extends Mapper<UserOrder> {

    @Select("SELECT goods_id as goodsId, goods_name as goodsName, count as goodsCount, img, price " +
            "FROM order_info natural join goods where order_id=#{orderId}")
    List<Goods> findGoodsByOrderId(String orderId);
}
