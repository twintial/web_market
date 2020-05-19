package com.web.market.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.market.dao.OrderInfoMapper;
import com.web.market.model.OrderInfo;
import com.web.market.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenjunjie
 * @Description:OrderInfo业务层接口实现类
 * @Date:2020/05/19
 *****/
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;


    /**
     * OrderInfo条件+分页查询
     * @param orderInfo 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OrderInfo> findPage(OrderInfo orderInfo, int page, int size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(orderInfo);
        //执行搜索
        return new PageInfo<OrderInfo>(orderInfoMapper.selectByExample(example));
    }

    /**
     * OrderInfo分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OrderInfo> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OrderInfo>(orderInfoMapper.selectAll());
    }

    /**
     * OrderInfo条件查询
     * @param orderInfo
     * @return
     */
    @Override
    public List<OrderInfo> findList(OrderInfo orderInfo) {
        //构建查询条件
        Example example = createExample(orderInfo);
        //根据构建的条件查询数据
        return orderInfoMapper.selectByExample(example);
    }


    /**
     * OrderInfo构建查询对象
     * @param orderInfo
     * @return
     */
    public Example createExample(OrderInfo orderInfo) {
        Example example = new Example(OrderInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if(orderInfo != null) {
            // write it yourself
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id) {
        orderInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改OrderInfo
     * @param orderInfo
     */
    @Override
    public void update(OrderInfo orderInfo) {
        orderInfoMapper.updateByPrimaryKey(orderInfo);
    }

    /**
     * 增加OrderInfo
     * @param orderInfo
     */
    @Override
    public void add(OrderInfo orderInfo) {
        orderInfoMapper.insert(orderInfo);
    }

    /**
     * 根据ID查询OrderInfo
     * @param id
     * @return
     */
    @Override
    public OrderInfo findById(Integer id) {
        return  orderInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询OrderInfo全部数据
     * @return
     */
    @Override
    public List<OrderInfo> findAll() {
        return orderInfoMapper.selectAll();
    }
}
