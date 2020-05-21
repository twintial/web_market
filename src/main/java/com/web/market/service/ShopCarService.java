package com.web.market.service;

import com.github.pagehelper.PageInfo;
import com.web.market.dto.CartItemParam;
import com.web.market.model.Goods;
import com.web.market.model.ShopCar;

import java.util.List;
/****
 * @Author:shenjunjie
 * @Description:ShopCar业务层接口
 * @Date:2020/05/19
 *****/
public interface ShopCarService {

    /***
     * ShopCar多条件分页查询
     * @param shopCar
     * @param page
     * @param size
     * @return
     */
    PageInfo<ShopCar> findPage(ShopCar shopCar, int page, int size);

    /***
     * ShopCar分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<ShopCar> findPage(int page, int size);

    /***
     * ShopCar多条件搜索方法
     * @param shopCar
     * @return
     */
    List<ShopCar> findList(ShopCar shopCar);

    /***
     * 删除ShopCar
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改ShopCar数据
     * @param shopCar
     */
    void update(ShopCar shopCar);

    /***
     * 新增ShopCar
     * @param shopCar
     */
    void add(ShopCar shopCar);

    /**
     * 根据ID查询ShopCar
     * @param id
     * @return
     */
     ShopCar findById(Integer id);

    /***
     * 查询所有ShopCar
     * @return
     */
    List<ShopCar> findAll();

    PageInfo<CartItemParam> findInfo(ShopCar shopCar, int page, int size);

    void deleteByUserGoodsId(Integer uId, Integer gId);
}
