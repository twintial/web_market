package com.web.market.dto;

import lombok.Data;
import sun.plugin2.message.Message;

import javax.validation.constraints.*;

@Data
public class LoginParam {

    @NotBlank(message = "邮箱不能为空")
    private String email;
    @NotBlank(message = "密码不能为空")
    private String password;
}
