package com.web.market.controller;

import com.web.market.common.api.CommonResult;
import com.web.market.dto.LoginParam;
import com.web.market.dto.RegisterParam;
import com.web.market.model.User;
import com.web.market.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @PostMapping("/login")
    public CommonResult<String> LoginHandler(@RequestBody @Valid LoginParam loginParam, HttpSession session) {
        User user = new User();
        user.setEmail(loginParam.getEmail());
        List<User> list = userService.findList(user);
        for (User item : list) {
            if (item.getPassword().equals(loginParam.getPassword())) {
                session.setAttribute("id", item.getUserId());
                session.setAttribute("username", item.getNickName());
                session.setAttribute("email", item.getEmail());
                return CommonResult.success("success", "登陆成功");
            }
        }
        return CommonResult.failed("用户名或密码错误");
    }

    @ResponseBody
    @PostMapping("/register")
    public CommonResult<String> RegisterHandle(@RequestBody @Valid RegisterParam registerParam){
        log.info(registerParam.toString());
        userService.add(new User(null, registerParam.getNickName(),
                registerParam.getEmail(), registerParam.getPassword()));
        return CommonResult.success("success", "注册成功");
    }

    @RequestMapping("/logout")
    public String LogoutHandle(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
