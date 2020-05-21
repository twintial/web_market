package com.web.market.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class RegisterParam implements Serializable {

    @NotBlank(message = "昵称不能为空")
    private String nickName;

    @NotBlank(message = "邮箱不能为空")
    private String email;

    @NotBlank(message = "密码不能为空")
    private String password;
}
