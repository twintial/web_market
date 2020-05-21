package com.web.market.dao;

import com.web.market.dto.CartItemParam;
import com.web.market.model.Goods;
import com.web.market.model.ShopCar;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:shenjunjie
 * @Description:ShopCarDao构建
 * @Date:2020/05/19
 *****/

public interface ShopCarMapper extends Mapper<ShopCar> {

    @Select("select goods_id as goodsId, goods_name as goodsName, price, img, " +
            "goods_content as goodsContent, goods_count as goodsCount, shop_car_id as cartId" +
            " from goods natural join shop_car where user_id=#{userId}")
    List<CartItemParam> findInfo(ShopCar shopCar);

    @Delete("delete from shop_car where user_id=#{uId} and goods_id=#{goodsId}")
    void deleteByUserGoodsId(Integer uId, Integer goodsId);
}
