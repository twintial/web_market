package com.web.market.service;

import com.github.pagehelper.PageInfo;
import com.web.market.model.Goods;
import java.util.List;
/****
 * @Author:shenjunjie
 * @Description:Goods业务层接口
 * @Date:2020/05/19
 *****/
public interface GoodsService {

    /***
     * Goods多条件分页查询
     * @param goods
     * @param page
     * @param size
     * @return
     */
    PageInfo<Goods> findPage(Goods goods, int page, int size);

    /***
     * Goods分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Goods> findPage(int page, int size);

    /***
     * Goods多条件搜索方法
     * @param goods
     * @return
     */
    List<Goods> findList(Goods goods);

    /***
     * 删除Goods
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Goods数据
     * @param goods
     */
    void update(Goods goods);

    /***
     * 新增Goods
     * @param goods
     */
    void add(Goods goods);

    /**
     * 根据ID查询Goods
     * @param id
     * @return
     */
     Goods findById(Integer id);

    /***
     * 查询所有Goods
     * @return
     */
    List<Goods> findAll();
}
