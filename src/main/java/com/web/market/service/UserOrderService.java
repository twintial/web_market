package com.web.market.service;

import com.github.pagehelper.PageInfo;
import com.web.market.model.Goods;
import com.web.market.model.UserOrder;

import java.util.List;
/****
 * @Author:shenjunjie
 * @Description:UserOrder业务层接口
 * @Date:2020/05/19
 *****/
public interface UserOrderService {

    /***
     * UserOrder多条件分页查询
     * @param userOrder
     * @param page
     * @param size
     * @return
     */
    PageInfo<UserOrder> findPage(UserOrder userOrder, int page, int size);

    /***
     * UserOrder分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<UserOrder> findPage(int page, int size);

    /***
     * UserOrder多条件搜索方法
     * @param userOrder
     * @return
     */
    List<UserOrder> findList(UserOrder userOrder);

    /***
     * 删除UserOrder
     * @param id
     */
    void delete(String id);

    /***
     * 修改UserOrder数据
     * @param userOrder
     */
    void update(UserOrder userOrder);

    /***
     * 新增UserOrder
     * @param userOrder
     * @return
     */
    int add(UserOrder userOrder);

    /**
     * 根据ID查询UserOrder
     * @param id
     * @return
     */
     UserOrder findById(String id);

    /***
     * 查询所有UserOrder
     * @return
     */
    List<UserOrder> findAll();

    List<Goods> findGoodsByOrderId(String orderId);
}
