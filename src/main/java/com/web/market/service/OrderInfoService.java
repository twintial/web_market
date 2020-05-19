package com.web.market.service;

import com.github.pagehelper.PageInfo;
import com.web.market.model.OrderInfo;

import java.util.List;
/****
 * @Author:shenjunjie
 * @Description:OrderInfo业务层接口
 * @Date:2020/05/19
 *****/
public interface OrderInfoService {

    /***
     * OrderInfo多条件分页查询
     * @param orderInfo
     * @param page
     * @param size
     * @return
     */
    PageInfo<OrderInfo> findPage(OrderInfo orderInfo, int page, int size);

    /***
     * OrderInfo分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OrderInfo> findPage(int page, int size);

    /***
     * OrderInfo多条件搜索方法
     * @param orderInfo
     * @return
     */
    List<OrderInfo> findList(OrderInfo orderInfo);

    /***
     * 删除OrderInfo
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改OrderInfo数据
     * @param orderInfo
     */
    void update(OrderInfo orderInfo);

    /***
     * 新增OrderInfo
     * @param orderInfo
     */
    void add(OrderInfo orderInfo);

    /**
     * 根据ID查询OrderInfo
     * @param id
     * @return
     */
     OrderInfo findById(Integer id);

    /***
     * 查询所有OrderInfo
     * @return
     */
    List<OrderInfo> findAll();
}
