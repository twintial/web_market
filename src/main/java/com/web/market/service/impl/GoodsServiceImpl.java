package com.web.market.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.market.dao.GoodsMapper;
import com.web.market.model.Goods;
import com.web.market.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenjunjie
 * @Description:Goods业务层接口实现类
 * @Date:2020/05/19
 *****/
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;


    /**
     * Goods条件+分页查询
     *
     * @param goods 查询条件
     * @param page  页码
     * @param size  页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Goods> findPage(Goods goods, int page, int size) {
        //分页
        PageHelper.startPage(page, size);
        //搜索条件构建
        Example example = createExample(goods);
        //执行搜索
        return new PageInfo<Goods>(goodsMapper.selectByExample(example));
    }

    /**
     * Goods分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Goods> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page, size);
        //分页查询
        return new PageInfo<Goods>(goodsMapper.selectAll());
    }

    /**
     * Goods条件查询
     *
     * @param goods
     * @return
     */
    @Override
    public List<Goods> findList(Goods goods) {
        //构建查询条件
        Example example = createExample(goods);
        //根据构建的条件查询数据
        return goodsMapper.selectByExample(example);
    }


    /**
     * Goods构建查询对象
     *
     * @param goods
     * @return
     */
    public Example createExample(Goods goods) {
        Example example = new Example(Goods.class);
        Example.Criteria criteria = example.createCriteria();
        if (goods != null) {
            if (!StringUtils.isEmpty(goods.getGoodsName())) {
                criteria.andLike("goodsName", "%" + goods.getGoodsName() + "%");
            }
        }
        return example;
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        goodsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Goods
     *
     * @param goods
     */
    @Override
    public void update(Goods goods) {
        goodsMapper.updateByPrimaryKey(goods);
    }

    /**
     * 增加Goods
     *
     * @param goods
     */
    @Override
    public void add(Goods goods) {
        goodsMapper.insert(goods);
    }

    /**
     * 根据ID查询Goods
     *
     * @param id
     * @return
     */
    @Override
    public Goods findById(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Goods全部数据
     *
     * @return
     */
    @Override
    public List<Goods> findAll() {
        return goodsMapper.selectAll();
    }
}
