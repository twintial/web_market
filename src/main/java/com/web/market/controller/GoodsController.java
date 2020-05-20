package com.market.controller;

import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author:shenjunjie
 * @Description:GoodsController构建
 * @Date:2020/05/19
 */

@RestController
@RequestMapping("/goods")
@CrossOrigin
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /***
     * Goods分页条件搜索实现
     * @param goods
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  Goods goods, @PathVariable  int page, @PathVariable  int size) {
        //调用GoodsService实现分页条件查询Goods
        PageInfo<Goods> pageInfo = goodsService.findPage(goods, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Goods分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size) {
        //调用GoodsService实现分页查询Goods
        PageInfo<Goods> pageInfo = goodsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索goods数据
     * @param goods
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Goods>> findList(@RequestBody(required = false)  Goods goods) {
        //调用GoodsService实现条件查询Goods
        List<Goods> list = goodsService.findList(goods);
        return new Result<List<Goods>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除goods数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id) {
        //调用GoodsService实现根据主键删除
        goodsService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Goods数据
     * @param goods
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  Goods goods,@PathVariable Integer id) {
        //设置主键值
        goods.setGoodsId(id);
        //调用GoodsService实现修改Goods
        goodsService.update(goods);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Goods数据
     * @param goods
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   Goods goods) {
        //调用GoodsService实现添加Goods
        goodsService.add(goods);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Goods数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Goods> findById(@PathVariable Integer id) {
        //调用GoodsService实现根据主键查询Goods
        Goods goods = goodsService.findById(id);
        return new Result<Goods>(true,StatusCode.OK,"查询成功",goods);
    }

    /***
     * 查询Goods全部数据
     * @return
     */
    @GetMapping
    public Result<List<Goods>> findAll() {
        //调用GoodsService实现查询所有Goods
        List<Goods> list = goodsService.findAll();
        return new Result<List<Goods>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
