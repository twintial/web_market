package com.web.market.controller;

import com.web.market.common.api.CommonResult;
import com.web.market.dto.CartListParam;
import com.web.market.dto.OrderGoodsParam;
import com.web.market.model.Goods;
import com.web.market.model.OrderInfo;
import com.web.market.model.UserOrder;
import com.web.market.service.OrderInfoService;
import com.web.market.service.ShopCarService;
import com.web.market.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    final UserOrderService userOrderService;
    final OrderInfoService orderInfoService;
    final ShopCarService shopCarService;

    @Autowired
    public OrderController(UserOrderService userOrderService, OrderInfoService orderInfoService, ShopCarService shopCarService) {
        this.userOrderService = userOrderService;
        this.orderInfoService = orderInfoService;
        this.shopCarService = shopCarService;
    }

    @PostMapping("/create/{total}")
    public CommonResult<Double> createOrder(@RequestBody CartListParam goods,
                                            @PathVariable Double total, HttpSession session) {
        Integer uId = (Integer) session.getAttribute("id");

        UserOrder userOrder = new UserOrder(
                UUID.randomUUID().toString().replace("-", ""),
                uId, total, new Date(), "0");
        userOrderService.add(userOrder);

        for (Goods checkGoods: goods.getCheckoutList()) {
            OrderInfo info = new OrderInfo(null, userOrder.getOrderId(),
                    checkGoods.getGoodsId(), checkGoods.getGoodsCount());
            orderInfoService.add(info);
            shopCarService.deleteByUserGoodsId(uId, checkGoods.getGoodsId());
        }

        return CommonResult.success(total, "success");
    }

    @GetMapping(value = "/search/{page}/{size}" )
    public CommonResult<List<OrderGoodsParam>> findPage(@PathVariable int page, @PathVariable int size, HttpSession session) {
        Integer uId = (Integer) session.getAttribute("id");

        UserOrder order = new UserOrder();
        order.setUserId(uId);
        List<UserOrder> userOrderList = userOrderService.findList(order);
        List<OrderGoodsParam> orderList = new ArrayList<>();
        for (UserOrder userOrder : userOrderList) {
            OrderGoodsParam orderGoodsParam = new OrderGoodsParam();
            orderGoodsParam.setCreateTime(userOrder.getCreateTime());
            orderGoodsParam.setOrderId(userOrder.getOrderId());
            orderGoodsParam.setTotal(userOrder.getTotalCost());

            List<Goods> goodsList = userOrderService.findGoodsByOrderId(userOrder.getOrderId());
            orderGoodsParam.setGoodsList(goodsList);
            orderList.add(orderGoodsParam);
        }
        return CommonResult.success(orderList);
    }
}
