package com.web.market.controller;

import com.github.pagehelper.PageInfo;

import com.web.market.common.api.CommonPage;
import com.web.market.common.api.CommonResult;
import com.web.market.model.Goods;
import com.web.market.service.GoodsService;
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
    public CommonResult<CommonPage<Goods>> findPage(
            @RequestBody(required = false) Goods goods, @PathVariable  int page, @PathVariable  int size) {
        //调用GoodsService实现分页条件查询Goods
        PageInfo<Goods> pageInfo = goodsService.findPage(goods, page, size);
        return CommonResult.success(CommonPage.restPage(pageInfo));
    }

    /***
     * Goods分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public CommonResult<CommonPage<Goods>> findPage(@PathVariable int page, @PathVariable int size) {
        //调用GoodsService实现分页查询Goods
        PageInfo<Goods> pageInfo = goodsService.findPage(page, size);
        return CommonResult.success(CommonPage.restPage(pageInfo));
    }

    /***
     * 多条件搜索goods数据
     * @param goods
     * @return
     */
    @PostMapping(value = "/search" )
    public CommonResult<List<Goods>> findList(@RequestBody(required = false)  Goods goods) {
        //调用GoodsService实现条件查询Goods
        List<Goods> list = goodsService.findList(goods);
        return CommonResult.success(list);
    }

    /***
     * 根据ID删除goods数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public CommonResult<String> delete(@PathVariable Integer id) {
        //调用GoodsService实现根据主键删除
        goodsService.delete(id);
        return CommonResult.success("删除成功");
    }

    /***
     * 修改Goods数据
     * @param goods
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public CommonResult update(@RequestBody  Goods goods,@PathVariable Integer id) {
        //设置主键值
        goods.setGoodsId(id);
        //调用GoodsService实现修改Goods
        goodsService.update(goods);
        return CommonResult.success("修改成功");
    }

    /***
     * 根据ID查询Goods数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public CommonResult<Goods> findById(@PathVariable Integer id) {
        //调用GoodsService实现根据主键查询Goods
        Goods goods = goodsService.findById(id);
        return CommonResult.success(goods);
    }

    /***
     * 查询Goods全部数据
     * @return
     */
    @GetMapping
    public CommonResult<List<Goods>> findAll() {
        //调用GoodsService实现查询所有Goods
        List<Goods> list = goodsService.findAll();
        return CommonResult.success(list);
    }
}
