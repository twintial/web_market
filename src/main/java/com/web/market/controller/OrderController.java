package com.web.market.controller;

import com.web.market.common.api.CommonResult;
import com.web.market.dto.CartListParam;
import com.web.market.model.Goods;
import com.web.market.model.OrderInfo;
import com.web.market.model.UserOrder;
import com.web.market.service.OrderInfoService;
import com.web.market.service.ShopCarService;
import com.web.market.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
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
}
