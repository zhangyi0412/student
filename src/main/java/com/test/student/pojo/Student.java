package com.test.student.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author admin
 * @date 2019/6/9
 */
@Data
@Accessors(chain = true)
public class Student {
    private Long id;
    private String sname;
    private String sno;
    private String tel;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;
    private int sex;
}
