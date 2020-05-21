package com.web.market.controller;

import com.web.market.model.Goods;
import com.web.market.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;

@Controller
public class RouteMapController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/")
    public String Home() {
        return "forward:/home";
    }

    @RequestMapping("/login")
    public String login(HttpSession httpSession) {
        if (httpSession.getAttribute("username") != null) {
            return "redirect:/";
        }
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/cart")
    public String shopCart(){
        return "cart";
    }

    @RequestMapping("/order")
    public String order(){
        return "order";
    }

    @RequestMapping("/single")
    public String goods(Integer goodsId, Model model){
        Goods goods = goodsService.findById(goodsId);
        if (goods == null) {
            return "404";
        }
        model.addAttribute("goods", goods);
        return "single";
    }
}
