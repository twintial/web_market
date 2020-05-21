package com.web.market.dao;

import com.web.market.model.Goods;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author:shenjunjie
 * @Description:GoodsDao构建
 * @Date:2020/05/19
 *****/
@Repository
public interface GoodsMapper extends Mapper<Goods> {
}
