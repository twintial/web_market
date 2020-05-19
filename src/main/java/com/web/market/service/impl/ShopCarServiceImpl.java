package com.web.market.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.market.dao.ShopCarMapper;
import com.web.market.model.ShopCar;
import com.web.market.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenjunjie
 * @Description:ShopCar业务层接口实现类
 * @Date:2020/05/19
 *****/
@Service
public class ShopCarServiceImpl implements ShopCarService {

    @Autowired
    private ShopCarMapper shopCarMapper;


    /**
     * ShopCar条件+分页查询
     * @param shopCar 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<ShopCar> findPage(ShopCar shopCar, int page, int size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(shopCar);
        //执行搜索
        return new PageInfo<ShopCar>(shopCarMapper.selectByExample(example));
    }

    /**
     * ShopCar分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<ShopCar> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<ShopCar>(shopCarMapper.selectAll());
    }

    /**
     * ShopCar条件查询
     * @param shopCar
     * @return
     */
    @Override
    public List<ShopCar> findList(ShopCar shopCar) {
        //构建查询条件
        Example example = createExample(shopCar);
        //根据构建的条件查询数据
        return shopCarMapper.selectByExample(example);
    }


    /**
     * ShopCar构建查询对象
     * @param shopCar
     * @return
     */
    public Example createExample(ShopCar shopCar) {
        Example example = new Example(ShopCar.class);
        Example.Criteria criteria = example.createCriteria();
        if(shopCar != null) {
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
        shopCarMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改ShopCar
     * @param shopCar
     */
    @Override
    public void update(ShopCar shopCar) {
        shopCarMapper.updateByPrimaryKey(shopCar);
    }

    /**
     * 增加ShopCar
     * @param shopCar
     */
    @Override
    public void add(ShopCar shopCar) {
        shopCarMapper.insert(shopCar);
    }

    /**
     * 根据ID查询ShopCar
     * @param id
     * @return
     */
    @Override
    public ShopCar findById(Integer id) {
        return  shopCarMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询ShopCar全部数据
     * @return
     */
    @Override
    public List<ShopCar> findAll() {
        return shopCarMapper.selectAll();
    }
}
