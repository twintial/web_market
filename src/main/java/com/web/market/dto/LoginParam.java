package com.web.market.dto;

import lombok.Data;
import sun.plugin2.message.Message;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
public class LoginParam implements Serializable {

    @NotBlank(message = "邮箱不能为空")
    private String email;
    @NotBlank(message = "密码不能为空")
    private String password;
}
