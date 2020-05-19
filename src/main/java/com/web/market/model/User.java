package com.web.market.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
/**
 * @Author:shenjunjie
 * @Description:User构建
 * @Date:2020/05/19
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user")
public class User implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
	private Integer userId;//

    @Column(name = "nick_name")
	private String nickName;//

    @Column(name = "e_mail")
	private String email;//

    @Column(name = "password")
	private String password;//
}
