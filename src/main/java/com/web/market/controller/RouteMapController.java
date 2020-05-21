package com.web.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class RouteMapController {

    @RequestMapping("/")
    public String Home() {
        return "forward:/home";
    }

    @RequestMapping("/login")
    public String login(HttpSession httpSession) {
//        if (httpSession.getAttribute("username") != null) {
//            return "redirect:/";
//        }
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/cart")
    public String shopCart(Model model, HttpSession httpSession){
        // 处理
        if (httpSession.getAttribute("id") != null) {
            model.addAttribute("username", httpSession.getAttribute("username"));
            model.addAttribute("email", httpSession.getAttribute("email"));
        }
        return "cart";
    }
}
