package com.test.student.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author admin
 * @date 2019/6/9
 */
@Data
@Accessors(chain = true)
public class User {
    private Long id;
    private String username;
    private String password;
    private String tel;
    private String email;
    private int status;
}
