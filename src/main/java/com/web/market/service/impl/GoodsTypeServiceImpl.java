package com.web.market.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.market.dao.GoodsTypeMapper;
import com.web.market.model.GoodsType;
import com.web.market.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenjunjie
 * @Description:GoodsType业务层接口实现类
 * @Date:2020/05/19
 *****/
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;


    /**
     * GoodsType条件+分页查询
     * @param goodsType 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<GoodsType> findPage(GoodsType goodsType, int page, int size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(goodsType);
        //执行搜索
        return new PageInfo<GoodsType>(goodsTypeMapper.selectByExample(example));
    }

    /**
     * GoodsType分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<GoodsType> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<GoodsType>(goodsTypeMapper.selectAll());
    }

    /**
     * GoodsType条件查询
     * @param goodsType
     * @return
     */
    @Override
    public List<GoodsType> findList(GoodsType goodsType) {
        //构建查询条件
        Example example = createExample(goodsType);
        //根据构建的条件查询数据
        return goodsTypeMapper.selectByExample(example);
    }


    /**
     * GoodsType构建查询对象
     * @param goodsType
     * @return
     */
    public Example createExample(GoodsType goodsType) {
        Example example = new Example(GoodsType.class);
        Example.Criteria criteria = example.createCriteria();
        if(goodsType != null) {
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
        goodsTypeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改GoodsType
     * @param goodsType
     */
    @Override
    public void update(GoodsType goodsType) {
        goodsTypeMapper.updateByPrimaryKey(goodsType);
    }

    /**
     * 增加GoodsType
     * @param goodsType
     */
    @Override
    public void add(GoodsType goodsType) {
        goodsTypeMapper.insert(goodsType);
    }

    /**
     * 根据ID查询GoodsType
     * @param id
     * @return
     */
    @Override
    public GoodsType findById(Integer id) {
        return  goodsTypeMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询GoodsType全部数据
     * @return
     */
    @Override
    public List<GoodsType> findAll() {
        return goodsTypeMapper.selectAll();
    }
}
