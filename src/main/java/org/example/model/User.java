package org.example.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Setter
@Getter
//User对象需要保存在session里，属于java对象序列化(序列化为二进制数据)
public class User implements Serializable {


    private static final long serialVersionUID = 0;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */

    private String nickname;

    /**
     * 邮箱
     */

    private String email;

    /**
     * 头像
     */

    private String head;


}
