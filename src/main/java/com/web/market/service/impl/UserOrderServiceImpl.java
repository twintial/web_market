package com.web.market.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.market.dao.UserOrderMapper;
import com.web.market.model.Goods;
import com.web.market.model.UserOrder;
import com.web.market.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenjunjie
 * @Description:UserOrder业务层接口实现类
 * @Date:2020/05/19
 *****/
@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    private UserOrderMapper userOrderMapper;


    /**
     * UserOrder条件+分页查询
     * @param userOrder 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<UserOrder> findPage(UserOrder userOrder, int page, int size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(userOrder);
        //执行搜索
        return new PageInfo<UserOrder>(userOrderMapper.selectByExample(example));
    }

    /**
     * UserOrder分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<UserOrder> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<UserOrder>(userOrderMapper.selectAll());
    }

    /**
     * UserOrder条件查询
     * @param userOrder
     * @return
     */
    @Override
    public List<UserOrder> findList(UserOrder userOrder) {
        //构建查询条件
        Example example = createExample(userOrder);
        //根据构建的条件查询数据
        return userOrderMapper.selectByExample(example);
    }


    /**
     * UserOrder构建查询对象
     * @param userOrder
     * @return
     */
    public Example createExample(UserOrder userOrder) {
        Example example = new Example(UserOrder.class);
        Example.Criteria criteria = example.createCriteria();
        if(userOrder != null) {
            if (!StringUtils.isEmpty(userOrder.getUserId())) {
                criteria.andEqualTo("userId", userOrder.getUserId());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(String id) {
        userOrderMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改UserOrder
     * @param userOrder
     */
    @Override
    public void update(UserOrder userOrder) {
        userOrderMapper.updateByPrimaryKey(userOrder);
    }

    /**
     * 增加UserOrder
     * @param userOrder
     * @return
     */
    @Override
    public int add(UserOrder userOrder) {
        return userOrderMapper.insert(userOrder);
    }

    /**
     * 根据ID查询UserOrder
     * @param id
     * @return
     */
    @Override
    public UserOrder findById(String id) {
        return  userOrderMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询UserOrder全部数据
     * @return
     */
    @Override
    public List<UserOrder> findAll() {
        return userOrderMapper.selectAll();
    }

    @Override
    public List<Goods> findGoodsByOrderId(String orderId) {
        return userOrderMapper.findGoodsByOrderId(orderId);
    }
}
