package com.web.market.controller;

import com.github.pagehelper.PageInfo;

import com.web.market.common.api.CommonPage;
import com.web.market.common.api.CommonResult;
import com.web.market.dto.CartItemParam;
import com.web.market.model.Goods;
import com.web.market.model.ShopCar;
import com.web.market.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author:shenjunjie
 * @Description:ShopCarController构建
 * @Date:2020/05/19
 */

@RestController
@RequestMapping("/shopCar")
@CrossOrigin
public class ShopCarController {

    @Autowired
    private ShopCarService shopCarService;

    /***
     * ShopCar分页条件搜索实现
     * @param shopCar
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public CommonResult<CommonPage<ShopCar>> findPage(@RequestBody(required = false)  ShopCar shopCar, @PathVariable  int page, @PathVariable  int size) {
        //调用ShopCarService实现分页条件查询ShopCar
        if (shopCar.getUserId() == null) {
            return CommonResult.failed("error");
        }
        PageInfo<ShopCar> pageInfo = shopCarService.findPage(shopCar, page, size);
        return CommonResult.success(CommonPage.restPage(pageInfo));
    }

    /***
     * ShopCar分页搜索实现
     * @param page :当前页
     * @param size :每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public CommonResult<CommonPage<ShopCar>> findPage(@PathVariable  int page, @PathVariable  int size) {
        //调用ShopCarService实现分页查询ShopCar
        PageInfo<ShopCar> pageInfo = shopCarService.findPage(page, size);
        return CommonResult.success(CommonPage.restPage(pageInfo));
    }

    /***
     * 根据ID删除shopCar数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public CommonResult<String> delete(@PathVariable Integer id) {
        //调用ShopCarService实现根据主键删除
        shopCarService.delete(id);
        return CommonResult.success("success");
    }

    /***
     * 修改ShopCar数据
     * @param shopCar
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public CommonResult<String> update(@RequestBody  ShopCar shopCar, @PathVariable Integer id) {
        //设置主键值
        shopCar.setShopCarId(id);
        //调用ShopCarService实现修改ShopCar
        shopCarService.update(shopCar);
        return CommonResult.success("success");
    }

    /***
     * 新增ShopCar数据
     * @param shopCar
     * @return
     */
    @PostMapping
    public CommonResult<String> add(@RequestBody ShopCar shopCar) {
        //调用ShopCarService实现添加ShopCar
        shopCarService.add(shopCar);
        return CommonResult.success("success");
    }

    /***
     * 根据ID查询ShopCar数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public CommonResult<ShopCar> findById(@PathVariable Integer id) {
        //调用ShopCarService实现根据主键查询ShopCar
        ShopCar shopCar = shopCarService.findById(id);
        return CommonResult.success(shopCar, "success");
    }

    /***
     * 查询ShopCar全部数据
     * @return
     */
    @GetMapping
    public CommonResult<List<ShopCar>> findAll() {
        //调用ShopCarService实现查询所有ShopCar
        List<ShopCar> list = shopCarService.findAll();
        return CommonResult.success(list, "success");
    }

    @PostMapping("/goodsInfo/{page}/{size}")
    public CommonResult<CommonPage<CartItemParam>> findInfo(@RequestBody(required = false)  ShopCar shopCar, @PathVariable  int page, @PathVariable  int size) {
        //调用ShopCarService实现分页条件查询ShopCar
        if (shopCar.getUserId() == null) {
            return CommonResult.failed("error");
        }
        PageInfo<CartItemParam> pageInfo = shopCarService.findInfo(shopCar, page, size);
        return CommonResult.success(CommonPage.restPage(pageInfo));
    }
}
