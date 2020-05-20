package com.web.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class RouteMapController {

    @RequestMapping("/")
    public String Home() {
        return "redirect:/home";
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
}
