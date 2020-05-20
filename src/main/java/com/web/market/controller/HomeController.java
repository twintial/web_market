package com.web.market.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class HomeController {

    @RequestMapping("/home")
    public String Home(Model model, HttpSession httpSession) {
        // 处理
        if (httpSession.getAttribute("id") != null) {
            log.info((String) httpSession.getAttribute("username"));
            model.addAttribute("username", httpSession.getAttribute("username"));
            model.addAttribute("email", httpSession.getAttribute("email"));
        }
        return "home";
    }
}
