package com.web.market.service;

import com.github.pagehelper.PageInfo;
import com.web.market.model.GoodsType;

import java.util.List;
/****
 * @Author:shenjunjie
 * @Description:GoodsType业务层接口
 * @Date:2020/05/19
 *****/
public interface GoodsTypeService {

    /***
     * GoodsType多条件分页查询
     * @param goodsType
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodsType> findPage(GoodsType goodsType, int page, int size);

    /***
     * GoodsType分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodsType> findPage(int page, int size);

    /***
     * GoodsType多条件搜索方法
     * @param goodsType
     * @return
     */
    List<GoodsType> findList(GoodsType goodsType);

    /***
     * 删除GoodsType
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改GoodsType数据
     * @param goodsType
     */
    void update(GoodsType goodsType);

    /***
     * 新增GoodsType
     * @param goodsType
     */
    void add(GoodsType goodsType);

    /**
     * 根据ID查询GoodsType
     * @param id
     * @return
     */
     GoodsType findById(Integer id);

    /***
     * 查询所有GoodsType
     * @return
     */
    List<GoodsType> findAll();
}
